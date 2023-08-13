package Functions;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import Functions.MoneyExConversor.ExRate;
/**
 * @author DigitalITSolutions82
 * Conversion System
 */
public class ConversionSys {
	/**
	 * Get Divisa Name
	 * @return Return Value Converted.
	 */
	public static Map<String, Double> CreateDivisa() {
		Map<String, Double> mapDivisa = new HashMap<>();
		for (ExRate divisa : ExRate.values()) {
			mapDivisa.put(divisa.getName(), divisa.getValue());
		}
		return mapDivisa;
		
	}
	/**
	 * Get Divisa Name	
	 * @param divisaName Currency Name
	 * @return Divisa
	 */
	public static ExRate getDivisa(String divisaName) {
		for(ExRate divisa : ExRate.values()) {
			if (divisa.getName().equals(divisaName)) {
				return divisa;
			}
		}
		return null;
	}
	/**
	 * Money Exchange Conversor
	 * @param typeDivisa Type Visa
	 * @param amount Quantity to Convert
	 * @return Result
	 */
	public String MoneyExConversor(String typeDivisa, Double amount) {
		Map<String, Double> mapDivisa = CreateDivisa();
		ExRate divisa = getDivisa(typeDivisa);
//		Map<String, Double> mapDivisa = new HashMap<>();
//		ExRate divisa = getDivisa(typeDivisa);
		DecimalFormat format = new DecimalFormat("#,##0.00");
        if(divisa != null){
            double value = mapDivisa.get(typeDivisa);
            double total = amount * value;
            String symbol = divisa.getSymbol();
            return symbol + " " + format.format(total);
        }else {
            return "Currency it doesn't exist";
        }
	}
}

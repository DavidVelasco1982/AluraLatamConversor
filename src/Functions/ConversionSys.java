package Functions;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import Functions.MoneyExConversor.ExRate;

public class ConversionSys {

	public static Map<String, Double> CreateDivisa() {
		Map<String, Double> mapDivisa = new HashMap<>();
		for (ExRate divisa : ExRate.values()) {
			mapDivisa.put(divisa.getName(), divisa.getValue());
		}
		return mapDivisa;
		
	}
	
	public static ExRate getDivisa(String divisaName) {
		for(ExRate divisa : ExRate.values()) {
			if (divisa.getName().equals(divisaName)) {
				return divisa;
			}
		}
		return null;
	}
	
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
            return "No se encuentra la moneda";
        }
	}
}

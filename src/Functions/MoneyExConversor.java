package Functions;

import Model.MoneyExInterface;

public class MoneyExConversor {

	
	

	public enum ExRate {
        MXNtoUSD(0.0585,"Pesos MXN to Dolares" ,"$"),
        MXNtoEUR(0.0532,"Pesos MXN to Euros", "€"),
        MXNtoGBP(0.0458,"Pesos MXN to Libras", "£"),
        MXNtoJPY(8.3685,"Pesos MXN to Yen", "¥"),
        MXNtoKWR(76.9225,"Pesos MXN to Won-Coreano", "₩"),
        USDtoMXN(17.1213,"Dolares to Pesos MXN", "MXN $"),
        EURtoMXN(18.7925,"Euros to Pesos MXN", "MXN $"),
        GBPtoMXN(21.8308, "Libras to Pesos MXN",  "MXN $"),
        JPYtoMXN(0.1195, "Yen Japones to Pesos MXN",  "MXN $"),
        KWRtoMXN(0.013, "Won Sul-Coreano to Pesos MXN",  "MXN $");
		/*MXNtoUSD(17.0797 ,"Pesos MXN to Dolares" ,"$"),
		MXNtoEUR(18.7925 ,"Pesos MXN to Euros", "€"),
		MXNtoGBP(21.8308 ,"Pesos MXN to Libras", "£"),
		MXNtoJPY(0.1198 ,"Pesos MXN to Yen", "¥"),
		MXNtoKRW(0.0131 ,"Pesos MXN to Yen", "₩"),
        USDtoMXN(0.0585 ,"Dolares to Pesos", "MXN"),
        EURtoMXN(0.0532 ,"Euros to Pesos", "MXN"),
        GBPtoMXN(0.0458, "Libras to Pesos",  "MXN"),
        JPYtoMXN(8.3447, "Yen Japones to Pesos",  "MXN"),
        KRWtoMXN(76.94, "Won Sul-Coreano to Pesos",  "MXN");*/
		
        //atributos
        private double value;
        private String name;
        private String symbol;
        
		ExRate() {
		}
		
		ExRate(double value, String name, String symbol) {
			this.value = value;
			this.name = name;
			this.symbol = symbol;
		}
		
		public double getValue() {
			return value;
		}
		
		public String getName() {
			return name;
		}
		
		public String getSymbol() {
			return symbol;
		}
	}
	
	private ConversionSys ConversionSys;
	
	public MoneyExConversor( ) {
		ConversionSys = new ConversionSys();
		OpenWindow();
	}
	
	public void OpenWindow() {
		MoneyExInterface interface1 = new MoneyExInterface();
		//interface1.asignConversion(ConversionSys);
		interface1.asignConversion(ConversionSys);
		interface1.setVisible(true);
	}
}

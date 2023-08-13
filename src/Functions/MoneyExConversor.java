package Functions;

import Model.MoneyExInterface;
/**
 * Money Exchange Conversor Rate
 */
public class MoneyExConversor {
	/**
	 * Exchange Rate Convertion
	 */
	public enum ExRate {
        MXtoUS(0.0585,"Pesos MXN to Dolares" ,"$"),
        MXtoEU(0.0532,"Pesos MXN to Euros", "€"),
        MXtoGB(0.0458,"Pesos MXN to Libras", "£"),
        MXtoJP(8.3685,"Pesos MXN to Yen", "¥"),
        MXtoKW(76.9225,"Pesos MXN to Won-Coreano", "₩"),
        UStoMX(17.1213,"Dolares to Pesos MXN", "MXN $"),
        EUtoMX(18.7925,"Euros to Pesos MXN", "MXN $"),
        GBtoMX(21.8308, "Libras to Pesos MXN",  "MXN $"),
        JPtoMX(0.1195, "Yen Japones to Pesos MXN",  "MXN $"),
        KWtoMX(0.013, "Won Sul-Coreano to Pesos MXN",  "MXN $");
		/**
		 * Variables
		 */
        private double value;
        private String name;
        private String symbol;
		/**
		 * ExRate Instance 1
		 */
		ExRate() {
		}
		/**
		 * ExRate Instance 2
		 * @param value Parameter Value
		 * @param name Parameter Name
		 * @param symbol Parameter Symbol
		 */
		ExRate(double value, String name, String symbol) {
			this.value = value;
			this.name = name;
			this.symbol = symbol;
		}
		/**
		 * Get Value
		 * @return Value
		 */
		public double getValue() {
			return value;
		}
		/**
		 * Get Name
		 * @return Name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Get Symbol
		 * @return Symbol
		 */
		public String getSymbol() {
			return symbol;
		}
	}
	
	private ConversionSys ConversionSys;
	/**
	 * System Convertion
	 */
	public MoneyExConversor( ) {
		ConversionSys = new ConversionSys();
		OpenWindow();
	}
	/**
	 * Open Window
	 */
	public void OpenWindow() {
		MoneyExInterface interface1 = new MoneyExInterface();
		//interface1.asignConversion(ConversionSys);
		interface1.asignConversion(ConversionSys);
		interface1.setVisible(true);
	}
}

package Functions;
/**
 * WeatherConversor Class
 */
public class WeatherConversor {
	/**
	 * WeatherConversor Instance
	 */
	public WeatherConversor() {
		
	}
	/**
	 * CelsiuAFahrenheit Convertion
	 * @param celsius Parameter
	 * @return celsius to Fahrenheit
	 */
    public String CelsiuAFahrenheit(double celsius){
        return "" + ((celsius * 1.8)+32) +"°F";
    }
	/**
	 * Fahrenheit to Celsius Convertion
	 * @param fahrenheit
	 * @return fahrenheit to Celsius
	 */
    public String FahrenheitACelsius(double fahrenheit) {
        return "" + ((fahrenheit - 32) / 1.8) + "ºC";
    }
	/**
	 * Celsius to Kevin Convertion
	 * @param celsius Parameter
	 * @return Celsius to Kevin
	 */
    public String CelsiusAKevin(double celsius) {
        return "" + (celsius + 273.15) + "°K";
    }
	/**
	 * Kelvin to Celsius Convertion
	 * @param kelvin Parameter
	 * @return Kelvin to Celsius
	 */
    public String KelvinACelsius(double kelvin) {
        return "" + (kelvin - 273.15) + "ºC";
    }
	/**
	 * Fahrenheit to Kelvin Convertion
	 * @param fahrenheit Parameter
	 * @return Fahrenheit to Kelvin
	 */
    public String FahrenheitAKelvin(double fahrenheit) {
        return "" + (5 / 9 * (fahrenheit - 32) + 273.15) + "°K";
    }
	/**
	 * Kelvin to Fahrenheit Convertion
	 * @param kelvin Parameter
	 * @return Kelvin to Fahrenheit
	 */
    public String KelvinAFahrenheit(double kelvin) {
        return "" + (1.8 * (kelvin - 273.15) + 32) + "°F";

    }
}

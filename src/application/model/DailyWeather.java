package application.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 
 * @author members of Team Dragon
 *
 */
public class DailyWeather {
	
	/**
	 * Class variables being created and will generate Getter/Setters.
	 * Each for the data that comes from the Weather API
	 */
	double temp;
	double tempMin;
	double tempMax;
	String forecast;
	String icon;
	String date;
	
	
	public  DailyWeather(JSONObject weatherobj){
		try {
		JSONObject weatherObject = (JSONObject) ((JSONArray)weatherobj.get("weather")).get(0);
		
		JSONObject main = ((JSONObject) weatherobj.get("main"));
		
		
		//setters
		this.setIcon((String) weatherObject.get("icon"));
		this.setForecast((String) weatherObject.get("main"));
		this.setTemp((double) main.get("temp"));
		this.setTempMin((double) main.get("temp_min"));
		this.setTempMax((double) main.get("temp_max"));
		
		System.out.println("Temp Max:" + this.getTempMax());
		System.out.println("Temp min:" + this.getTempMin());
		System.out.println(this.getForecast());
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * @return the temp
	 */
	public double getTemp() {
		return temp;
	}
	/**
	 * @param string the temp to set
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return "http://openweathermap.org/img/w/" + icon + ".png";
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	/**
	 * @return the forecast
	 */
	public String getForecast() {
		return forecast;
	}
	/**
	 * @param forecast the forecast to set
	 */
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	/**
	 * @return the tempMin
	 */
	public double getTempMin() {
		return tempMin;
	}
	/**
	 * @param tempMin the tempMin to set
	 */
	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}
	/**
	 * @return the tempMax
	 */
	public double getTempMax() {
		return tempMax;
	}
	/**
	 * @param tempMax the tempMax to set
	 */
	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

}
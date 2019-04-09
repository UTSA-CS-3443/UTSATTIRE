package application.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	Integer date;
	
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
		this.setDate((Integer)weatherobj.get("dt"));
		
		
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
	 * Changes the date from the api from epoch to days
	 * @return the date
	 */
	public String getDate() {

		Integer i = this.date;
		Long l = new Long(i)*1000;
        Date date = new Date(l);
        DateFormat format = new SimpleDateFormat("EEE, MM/dd");
        String formatted = format.format(date);
        formatted = format.format(date);

		return formatted;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Integer date) {
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
		System.out.println("YEET");
		this.tempMax = tempMax;
	}

}
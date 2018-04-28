package application.model;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.scene.image.Image;


/**
 * 
 * @author members of Team Dragon
 *
 */
public class FiveDayForecast {
	
	/**
	 * Arraylist 
	 */
	public static ArrayList<DailyWeather> forecast = new ArrayList();
	
	
	public FiveDayForecast() throws ClientProtocolException, IOException {
		
		
		
		String endpoint  = "http://api.openweathermap.org/data/2.5/forecast?zip=78023,us&appid=c457ac9a917181dbe62eba28722659c0";
    	String jObjString = ApiUtility.callAPI(endpoint);
    	
    	// for each day call api create object and set;
    	try {
    		
			JSONObject responseObj = new JSONObject(jObjString);
			JSONArray weatherList = (JSONArray)responseObj.get("list");
			
			for(int i = 0; i<weatherList.length();i++) {
				DailyWeather test = new DailyWeather((JSONObject)weatherList.get(i));
								
				forecast.add(test);
				
				i+=7;
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return the forecast
	 */
	public static ArrayList<DailyWeather> getForecast() {
		return forecast;
	}

	/**
	 * @param forecast the forecast to set
	 */
	public static void setForecast(ArrayList<DailyWeather> forecast) {
		FiveDayForecast.forecast = forecast;
	}
	
	/**
	 * Method created to convert the Double Kelvin temp. we get from the weather data
	 * euation takes in Kelvin as Double and convert to Celsius and then Fahrenheit and will return
	 * Double Value of Fahrenheit.  
	 * @param k
	 * @return
	 */
	public static double getFahrenheit(double k) {
	
		double kelvin = k;
		double celsius = kelvin - 273.0;
		double fah = (celsius * 9.0/5.0) + 32.0;
		fah = Math.round(fah * 10.0) / 10.0;
		
		return fah;
	}
	
}

	
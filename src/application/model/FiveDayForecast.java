package application.model;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FiveDayForecast {
	
	public static ArrayList<DailyWeather> forecast = new ArrayList();
	
	public FiveDayForecast() throws ClientProtocolException, IOException {
		
		
		
		String endpoint  = "http://api.openweathermap.org/data/2.5/forecast?zip=78023,us&appid=c457ac9a917181dbe62eba28722659c0";
    	String jObjString = ApiUtility.callAPI(endpoint);
    	//ArrayList<DailyWeather> forecast = new ArrayList<DailyWeather>();
    	//System.out.println(jObjString);
    	System.out.println("----------------------------------------------");
    	// for each day call api create object and set;
    	try {
    		
			JSONObject responseObj = new JSONObject(jObjString);
			JSONArray weatherList = (JSONArray)responseObj.get("list");
			
			
			//System.out.println(weatherList);
			
			for(int i = 3; i<weatherList.length();i++) {
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
	public static ArrayList<String> getPrettyForecast() {
		ArrayList<String> list = new ArrayList<String>();
		//loop through objects and print information 
		// for each object 
		// string = "Temp:" + object.temp 
		
		return list;
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

}
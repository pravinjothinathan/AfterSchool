import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str  = "{\"op\":\"contains\",\"attr\":\"businessEntitiesName\",\"value\":\"he\"}";
		String str1 = "[{\"op\":\"contains\",\"attr\":\"businessEntitiesName\",\"value\":\"he\"},{\"op\":\"contains\",\"attr\":\"platformName\",\"value\":\"crs\"}]";
		ArrayList<Map<String,String>> jsonJavaRootObject = new Gson().fromJson(str1, new TypeToken<ArrayList<Map<String,String>>>(){}.getType());
		for(Map map : jsonJavaRootObject){
			for (Object string : map.keySet()) {
				System.out.println(map.get(string));
			}
		}

	}

}

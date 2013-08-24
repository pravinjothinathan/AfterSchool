import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> lines = new ArrayList<String>();
		try{
			BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
			int noofLines = Integer.parseInt(br.readLine());
			for (int i = 0; i < noofLines; i++) {
				lines.add(br.readLine());
			}
		}catch(IOException io){
			io.printStackTrace();
		}
		
		cacheLRU cache = new cacheLRU();
		for (String line : lines){
//			System.out.println(line);
			String[] params = line.split(" ");
//			System.out.println(params[0]);
			if(params[0].equalsIgnoreCase("BOUND")){
//				System.out.println("Inside Bound");
				cache.setCacheBound(Integer.parseInt(params[1]));
			}else if(params[0].equalsIgnoreCase("SET")){
				cache.setValue(params[1], Integer.parseInt(params[2]));
			}else if(params[0].equalsIgnoreCase("GET")){
				cache.get(params[1]);
			}else if(params[0].equalsIgnoreCase("PEEK")){
				cache.peek(params[1]);
			}else if(params[0].equalsIgnoreCase("DUMP")){
				cache.dump();
			}
		}
	}

}

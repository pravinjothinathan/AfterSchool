import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String wordsString = null;
		String checkString = null;
		try {
			wordsString = br.readLine();
			checkString =  br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(wordsString!=null && checkString!=null)
		{
			String[] words = wordsString.split(" ");
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			HashMap<String, Integer> countMap = new HashMap<String, Integer>();
			HashMap<Integer,Integer> indexToWordMap = new HashMap<Integer, Integer>();
	//		HashSet<String> wordSet = new HashSet<String>();
			int length = words[0].length();//assuming that there are words
			int wordId =0;
			for (String string : words) {
				if(!map.containsKey(string)){
					map.put(string,wordId++);
//					System.out.println(":"+string);
					countMap.put(string, 1);
				}
				else
					countMap.put(string, countMap.get(string) + 1);
			}
//			System.out.println(map);
//			System.out.println(countMap);
			ArrayList<Integer> indices = new ArrayList<Integer>();
			for (int i = 0; i < checkString.length() - length + 1; i++) {
				String temp = checkString.substring(i, i + length);
				if(map.containsKey(temp)){
					indexToWordMap.put(i, map.get(temp));
					indices.add(i);
				}
					
	//			System.out.println(temp);
			}
			int max = 0;
			int maxIndex = 0;
			int[] vals = new int[words.length];
			HashSet<Integer> checkSet = new HashSet<Integer>();
			for (Integer integer : indices) {
				checkSet.clear();
				checkSet.add(indexToWordMap.get(integer));
				int nextIndex = integer + length;
				
				while(true){
					if(indexToWordMap.containsKey(nextIndex)){
						int nxtWordIndex = indexToWordMap.get(nextIndex);
						if(!checkSet.contains(nxtWordIndex)){
							vals[nxtWordIndex] += 1;
							if(vals[nxtWordIndex]>countMap.get(words[nxtWordIndex]))
								checkSet.add(nxtWordIndex);
							nextIndex += length;
						}else{
							break;
						}
					}else{
						//no matching word
						break;
						
					}
				}
				if(checkSet.size()>max){
					max = checkSet.size();
					maxIndex = integer;
				}
				
			}
	//		System.out.println(indices);
	//		System.out.println(indexToWordMap);
			System.out.println(maxIndex);
		}else{
			System.out.println(0);
		}
	}

}

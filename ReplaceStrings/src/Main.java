import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {
	
	public static ArrayList<String> readFile(String fileLoc){
		ArrayList<String> points = new ArrayList<String>();
		File file = new File(fileLoc);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line ="";
			while((line=br.readLine())!=null){
				points.add(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return points;
	}

	public static void main(String[] args) {
		ArrayList<String> lines = readFile(args[0]);
		
		for (String test : lines) {
			findAndReplaceString(test);
		}
	}

	private static void findAndReplaceString(String test) {
		if(test.contains(";")){
			String[] splitTest = test.split(";");
			String givenString = splitTest[0];
			String finalString = splitTest[0];
			String[] findReplacePlaceHolder = splitTest[1].split(",");
			ArrayList<String> findList = new ArrayList<String>();
			ArrayList<String> replaceList = new ArrayList<String>();
			prepareFindandReplaceList(findReplacePlaceHolder, findList, replaceList);
			ArrayList<Character> finalStringCharArr = convertStringtoCharArrayList(finalString);
			for (int i = 0; i < findList.size(); i++) {
				givenString = subSetFindandReplace(givenString, findList,
						replaceList, finalStringCharArr, i);
			}
			System.out.println(givenString);
			System.out.println(convertCharArrListtoString(finalStringCharArr));
		}else{
			System.out.println(test);
		}
	}

	private static String subSetFindandReplace(String givenString,
			ArrayList<String> findList, ArrayList<String> replaceList,
			ArrayList<Character> finalStringCharArr, int i) {
		int index = givenString.indexOf(findList.get(i));
//		System.out.println(index);
		if(index>=0){
			String replaceString = getReplacement(replaceList.get(i).length());
//			System.out.println(replaceString);
			givenString = givenString.replaceFirst(findList.get(i),replaceString);			
			removeCharactersFromIndexforLength(finalStringCharArr,index,findList.get(i).length());
			addCharectersFromIndex(finalStringCharArr,index,replaceList.get(i));
			givenString = givenString.replace("X", "_");
//			System.out.println(givenString);
		}
		return givenString;
	}

	private static String convertCharArrListtoString(
			ArrayList<Character> finalStringCharArr) {
		StringBuffer temp = new StringBuffer();
		for (Character character : finalStringCharArr) {
			temp.append(character);
		}
		return temp.toString();
	}

	private static void prepareFindandReplaceList(
			String[] findReplacePlaceHolder, ArrayList<String> findList,
			ArrayList<String> replaceList) {
		for (int i = 0; i < findReplacePlaceHolder.length; i++) {
			if(i%2==0)
				findList.add(findReplacePlaceHolder[i]);
			else
				replaceList.add(findReplacePlaceHolder[i]);
		}
	}

	private static void addCharectersFromIndex(
			ArrayList<Character> finalStringCharArr, int index, String replaceString) {
		char[] replaceStringCharArr = replaceString.toCharArray();
		for (int i = 0; i < replaceString.length(); i++) {
			finalStringCharArr.add(index + i, replaceStringCharArr[i]);
		}
	}

	private static void removeCharactersFromIndexforLength(
			ArrayList<Character> finalStringCharArr, int index, int findLength) {
		for (int i = 0; i < findLength; i++) {
			finalStringCharArr.remove((int)(index));
		}
	}

	private static ArrayList<Character> convertStringtoCharArrayList(
			String finalString) {
		ArrayList<Character> charArrList = new ArrayList<Character>();
		for (char character : finalString.toCharArray()) {
			charArrList.add(character);
		}
		return charArrList;
	}

	private static String getReplacement(int replaceLength) {
		StringBuffer tempBuf = new StringBuffer();
		for (int i = 0; i < replaceLength; i++) {
			tempBuf = tempBuf.append("X");
		}
		return tempBuf.toString();
	}

}

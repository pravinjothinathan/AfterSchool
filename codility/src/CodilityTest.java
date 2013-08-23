import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
public class CodilityTest {
	/*
	A prefix of a string S is any leading contiguous part of S. A suffix of the string S is any trailing contiguous part of S. For example, "c" and "cod" are prefixes, and "ty" and "ity" are suffixes of the string "codility". For simplicity, we require prefixes and suffixes to be non-empty and shorter than the whole string S.
	A border of a string S is any string that is both a prefix and a suffix. For example, "cut" is a border of a string "cutletcut", and a string "barbararhubarb" has two borders: "b" and "barb".
	We are looking for such borders of S that have at least three non-overlapping occurrences; that is, for some string that occurs as a prefix, as a suffix and elsewhere in between. For example, for S = "barbararhubarb", the only such string is "b".
	In this problem we consider only strings that consist of lower-case English letters (a−z).
	Write a function:
	class Solution { public int solution(String S); }
	that, given a string S consisting of N characters, returns the length of its longest border that has at least three non-overlapping occurrences in the given string. If there is no such border in S, the function should return 0.
	For example, given a string S as follows:
	if S = "barbararhubarb" the function should return 1, as explained above;
	if S = "ababab" the function should return 2, as "ab" and "abab" are both borders of S, but only "ab" has three non-overlapping occurrences;
	if S = "baaab" the function should return 0, as its only border "b" occurs only twice.
	Assume that:
	N is an integer within the range [0..1,000,000];
	string S consists only of lower-case letters (a−z).
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
	*/
	
	public static void main(String[] args) {
		String str = "aradaaaarrarareeeeddara";
		System.out.println(solution1(str));
//		PhantomReference<String> vals = new PhantomReference<String>(referent, q)
	}
	
	public static int solution1(String S) {
		char[] charArr = S.toCharArray();
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for (char c : charArr) {
			if(!map.containsKey(c)){
				map.put(c, 1);
			}else{
				map.put(c, map.get(c)+1);
			}
		}
		
		TreeSet<Character> dummy = new TreeSet<Character>();
		for (char c : map.keySet()) {
			int count = map.get(c);
			if(count<3)
				dummy.add(c);
				
		}
		
		int maxLen = S.length() / 3;
		
		//set perfect maxLen
		for (int i = 0; i < maxLen; i++) {
			
			if(dummy.contains(charArr[i]))
				maxLen = i;
		}
		
		
		
//		System.out.println(maxLen);
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < maxLen; i++) {
			stack.push(charArr[S.length() - (i + 1)]);
		}
//		System.out.println(stack);
//		System.out.println(S);
		List<Integer> possibleSizes = new ArrayList<Integer>();
		while(true){
			if(stack.size()==0)
				break;
			if(stack.pop()==charArr[0]){
				possibleSizes.add(stack.size());
			}
		}
		
		while(possibleSizes.size()==0)
			return 0;
		
		int size = charArr.length;
		
		for (Integer i : possibleSizes) {
			i +=1;
			String first = S.substring(0, i);
			String last = S.substring( size - i );
//			System.out.println(first);
//			System.out.println(last);
			if(first.equals(last)){
				String mid = S.substring(i, size - i);
				if(mid.contains(first))
					return i;
			}
		}
		
		return 0;
	}

	public static int solution(String S) {
        int longestSeq = S.length()/3;
        int size = S.length();
        int length = 0;
		for (int i = longestSeq; i >0; i--) {
			String first = S.substring(0, i);
			String last = S.substring( size - i );
			if(first.equals(last)){
				String mid = S.substring(i, size - i);
				if(mid.contains(first))
					length = i;
			}			
		}
        return length;
    }
}

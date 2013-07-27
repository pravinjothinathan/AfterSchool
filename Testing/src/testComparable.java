import java.util.ArrayList;
import java.util.Collections;


public class testComparable implements Comparable<testComparable>{

	int start;
	int end;
	
	public testComparable(int Start,int End){
		start = Start;
		end = End;
	}
	
	public void print(){
		System.out.println("start:"+start+"end:"+end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<testComparable> list = new ArrayList<testComparable>();
		list.add(new testComparable(0, 5));
		list.add(new testComparable(1, 6));
		list.add(new testComparable(7, 10));
		list.add(new testComparable(2, 6));
		list.add(new testComparable(2, 5));
		list.add(new testComparable(1, 2));
		list.add(new testComparable(1, 2));
		
		System.out.println(list);
		for (testComparable testComparable : list) {
			testComparable.print();
		}
		Collections.sort(list);
		System.out.println(list);
		for (testComparable testComparable : list) {
			testComparable.print();
		}
	}

	@Override
	public int compareTo(testComparable arg0) {
		if(start<arg0.start)
			return -1;
		else if (start>arg0.start)
			return 1;
		else if(start == arg0.start){
			if(end<arg0.end)
				return -1;
			else if(end>arg0.end)
				return 1;
			else
				return 0;
		}
		return 0;
	}

}

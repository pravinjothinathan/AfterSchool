import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class fileParse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> inputs = new ArrayList<String>();
		File file = new File(args[0]);
		
		try{
		    BufferedReader in = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = in.readLine()) != null) {
		    	inputs.add(line.trim());
		    }
		}catch(Exception ex){
			System.out.println("File Read Exception!!");
		}
//		System.out.println(inputs.size());
		//String[] vals = inputs.get(0).split(";");
//		System.out.println(inputs.get(0).length());
		String doc = inputs.get(0); 
		int size = doc.length();
		
//		System.out.println(doc.length());
		int start = Integer.parseInt(args[1]);//20100000;
		//(*((volatile UINT32 *)(0x20100000)) = (0xfeff));
		for (int i = 0; i < size / 4; i++) {
			System.out.println(String.format("(*((volatile UINT32 *)(0x%d)) = (0x%s));", (start+i),doc.substring(4*i,4*i+4)));
		}
		
		
	}

}

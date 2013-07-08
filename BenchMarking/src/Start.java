import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Timer;


public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader fr = new FileReader(args[0]);
		List<String> files = fr.ParseFile();
		System.out.println(files.size());
		
		for (int i = 0; i < files.size(); i++) {				
			System.out.println(files.get(i));
			ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", files.get(i));
			pb.command();
			long start = System.currentTimeMillis();
			try{
			final Process process = pb.start();
		    InputStream is = process.getInputStream();
		    InputStreamReader isr = new InputStreamReader(is);
		    BufferedReader br = new BufferedReader(isr);
		    String line;
		    while ((line = br.readLine()) != null) {
		      System.out.println(line);
		    }}catch(Exception ex){
		    	ex.printStackTrace();
		    }
			long stop = System.currentTimeMillis();
			System.out.println("Time taken->"+(double)(stop-start)/1000);
		}
		
	}

}

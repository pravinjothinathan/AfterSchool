import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File(args[0]);
		File outfile = new File(args[1]);
		BufferedWriter bw = null; 
		String content ="";
		try{
		bw = new BufferedWriter(new FileWriter(outfile));
		}catch(Exception ex){
			System.out.println("Exception in opening file for writing !");
		}
		
		for (File tempFile : f.listFiles()) {
			if(!tempFile.getName().contains(".")){
				try{
					System.out.println(tempFile.getName());
				BufferedReader br = new BufferedReader(new FileReader(tempFile));
				String line;
				while((line = br.readLine())!=null){
					//System.out.println(line);
					content += line + "\n";
				}
				br.close();
				}catch(Exception ex){
					
				}
			}
		}
		
		try {
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

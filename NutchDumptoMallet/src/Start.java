import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Start {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputfile = args[0];
		String classificationInfo = "X";
		String outputfile = args[2];
		try{
		FileInputStream fis = new FileInputStream(inputfile);
		DataInputStream dis = new DataInputStream(fis);
		BufferedReader br = new BufferedReader(new InputStreamReader(dis));
		
		String line= "";
		String parseText;
		String content ="";
		String url = "";
		String eol = System.getProperty("line.separator");  

		while((line=br.readLine())!=null){
			if(line.contains("URL")){
				url = line;
			}
			if(line.contains("ParseText")){
				parseText = br.readLine();
				if(parseText.equals("")){
				}
				else
					content += url + "," + classificationInfo + "," + parseText + eol;
			}
			else{
			}
			
			File file = new File(outputfile);
			 
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		}
		}catch(Exception ex){
			System.out.println("Print Stream");
		}
	}

}

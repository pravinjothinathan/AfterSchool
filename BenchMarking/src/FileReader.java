import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FileReader {
	String file;
	List<String> fileData;
	
	public FileReader(String string) {
		file = string;
	}
	
	public List<String> ParseFile(){
		fileData = new ArrayList<String>();
		File f = new File(file);
		try {
			FileInputStream fis = new FileInputStream(f);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String line;
			while((line = reader.readLine())!=null){
				fileData.add(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileData;
	}

}

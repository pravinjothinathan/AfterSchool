import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {
	
	
	int x,y;
	
	public Main(int inx,int iny){
		x = inx;
		y = iny;
	}
	
	public int calcDistance(Main in){
		return  (int)Math.sqrt(Math.pow(in.x - x, 2.0) + Math.pow(in.y - y, 2.0)); 
	}
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return points;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<String> lines = readFile(args[0]);
		
		for (String temp : lines) {
			temp = temp.replace(") (",":");
			temp = temp.replace("(","");
			temp = temp.replace(")","");
			temp = temp.replace(", ",",");
			
			String[] strPoints = temp.split(":");		
			String[] p1 = strPoints[0].split(",");
			String[] p2 = strPoints[1].split(",");
			
			Main cd1 = new Main(Integer.parseInt(p1[0]),Integer.parseInt(p1[1]));
			Main cd2 = new Main(Integer.parseInt(p2[0]),Integer.parseInt(p2[1]));
			System.out.println(cd1.calcDistance(cd2));

		}
		
	}

}


public class Students {
	
	private String name;
	private int id;
	private String address;
	
	public void printStudent(){
		System.out.println("name:"+name);
		System.out.println("address"+address);
	}
	
	public void setName(String inName,String inAddr){
		name = inName;
		address = inAddr;
	}
}

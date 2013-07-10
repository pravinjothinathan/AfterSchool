import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class PassTriangle {

	private static class Node{
		private Node lptr;
		private Node rptr;
		private int value;
		
		public int getValue() {
			return value;
		}

		public Node(Node lptr, Node rptr, int value){
			this.lptr = lptr;
			this.rptr = rptr;
			this.value = value;
		}
		
		public Node getLptr() {
			return lptr;
		}
		public void setLptr(Node lptr) {
			this.lptr = lptr;
		}
		public Node getRptr() {
			return rptr;
		}
		public void setRptr(Node rptr) {
			this.rptr = rptr;
		}
		
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ArrayList<String> inputs = new ArrayList<String>();
		ArrayList<Node> list = new ArrayList<PassTriangle.Node>();
		
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

		Node root =null;
		for (String string : inputs) {
			if(root==null){
				//first node - do nothing
				Node temp = new Node(null, null, Integer.parseInt(string.trim()));
				root = temp;
				list.add(temp);
			}else{
				String[] tempStrings = string.split(" ");
				ArrayList<Node> tempNodes = new ArrayList<PassTriangle.Node>();
				for (int i = 0; i < tempStrings.length; i++) {
					Node tempNode = new Node(null,null,Integer.parseInt(tempStrings[i].trim()));
					tempNodes.add(tempNode);
				}
				for (int i = 0; i < tempNodes.size()-1; i++) {
					Node prevNode = list.remove(0);
					prevNode.setLptr(tempNodes.get(i));
					prevNode.setRptr(tempNodes.get(i+1));
				}
				for (Node node : tempNodes) {
					list.add(node);
				}
			}
			
		}
		
		traverserTree(root);
		int val = calculateMaxPathWeight(root,0,0);
		System.out.println("final val"+val);
		
	}
	
	
	private static void traverserTree(Node node) {
		if(node==null)
			return;
		else{
			System.out.println(node.getValue());
			traverserTree(node.getLptr());
			traverserTree(node.getRptr());
		}
	}
	
	
	private static int calculateMaxPathWeight(Node node,int weight, int maxWeight){
		
		if(node==null){
			System.out.println(weight);
			return weight;
		}else{
			weight += node.getValue();
			int weight1 = calculateMaxPathWeight(node.getLptr(),weight,maxWeight);
			int weight2 = calculateMaxPathWeight(node.getRptr(), weight, maxWeight);
			
			if(maxWeight<weight1){
				maxWeight = weight1;
			}
			if(maxWeight<weight2){
				maxWeight = weight2;
			}
			
			weight -= node.getValue();
			
		}
		
		return maxWeight;
	}

}

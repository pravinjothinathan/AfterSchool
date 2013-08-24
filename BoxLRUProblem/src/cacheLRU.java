import java.util.WeakHashMap;


public class cacheLRU {
	
	private WeakHashMap<String,NodeDoubleLL> cache;
	private NodeDoubleLL head;
	private NodeDoubleLL tail;
	private int bound;
	private int count;
	
	public cacheLRU(){
		count = 0;
		cache = new WeakHashMap<String, NodeDoubleLL>();
	}
	
	void setCacheBound(int n){
		//if n is greater than bound
		//we are increasing the size!
		bound = n;
		if(count>bound){
			//delete entries from the end
			while(count>bound){
				NodeDoubleLL newHead = head.right;
				newHead.left = null;
				cache.remove(newHead.key);
				head = newHead;
				count--;
			}
		}
	}
	
	void setValue(String key,int value){
		
		if(!cache.containsKey(key)){
			NodeDoubleLL node = new NodeDoubleLL(key,value);
//			System.out.println("Add Node");
			if(count<bound){
				if(count==0){
//					System.out.println("Head Node");
					head = node;
					tail = node;
				}else{
//					System.out.println("Tail Node");
					tail.right = node;
					node.left = tail;
					tail = node;
				}
			}else{
//				System.out.println("Delete Head");
				NodeDoubleLL nodetoremove = head;
				head = head.right;
				cache.remove(nodetoremove.key);
				count--;
				tail.right = node;
				node.left = tail;
				tail = node;
			}
			cache.put(key, node);
			count++;
		}else{
			ReorderDLL(key,value);
		}
	}
	
	private void ReorderDLL(String key, int value) {
		NodeDoubleLL curNode = cache.get(key);
		if(curNode == head || curNode == tail){
			if(curNode == head){
				head = head.right;
				head.left = null;
				tail.right = curNode;
				curNode.left = tail;
				curNode.right = null;
				tail = curNode;
				curNode.val = value;
			}else{
				tail.val = value;
			}
		}else{
			//the element is present in the middle
			NodeDoubleLL prevNode = curNode.left;
			NodeDoubleLL nextNode = curNode.right;
			prevNode.right = nextNode;
			nextNode.left = prevNode;
			tail.right = curNode;
			curNode.left = tail;
			curNode.right = null;
			curNode.val = value;
			tail = curNode;
		}
	}

	void dump(){
		NodeDoubleLL temp = head;
		while(temp!=null){
//			System.out.print(temp.key + ":" + temp.val+",");
			System.out.println(temp.key + " " + temp.val);
			temp = temp.right;
		}
//		System.out.println( " count ->"+count);
	}

	public void peek(String key) {
		if(cache.containsKey(key)){
			NodeDoubleLL value = cache.get(key);
			System.out.println(value.val);
		}
		else
			System.out.println("NULL");
	}
	
	public void get(String key){
		if(cache.containsKey(key)){
			NodeDoubleLL value = cache.get(key);
			System.out.println(value.val);
			ReorderDLL(key, value.val);
		}
		else
			System.out.println("NULL");
	}
	

}

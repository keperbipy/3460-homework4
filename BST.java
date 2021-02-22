
public class BST {
	public Node root; 
	public Node pred = new Node(-1, -1);
	public Node succ = new Node(-1, -1);
	
	public BST() {
		root = null;
	}

	public void insert(int key, int req_index) { 
       root = insRecursive(root, key, req_index); 
    } 
      

    public Node insRecursive(Node root, int key, int req_index) { 
  
        if (root == null) { 
            root = new Node(key, req_index); 
            return root; 
        } 

        if (key < root.getTime()) {
            root.setLeft(insRecursive(root.getLeft(), key, req_index)); 
		}
        else if (key > root.getTime()) {
            root.setRight(insRecursive(root.getRight(), key, req_index)); 
		}

        return root; 
    } 


	void findPreSuc(Node root, int key) { 		
	
		if (root == null) {
			return; 
		}
		if (root.getTime() == key) 
		{ 

			if (root.getLeft() != null) 
			{ 
				Node tmp = root.getLeft(); 
				while (tmp.getRight() != null) {
					tmp = tmp.getRight(); 
				}
				pred = tmp ; 
			} 
  
			if (root.getRight() != null) { 
				Node tmp = root.getRight(); 
				while (tmp.getLeft() != null) {
					tmp = tmp.getLeft() ; 
				}
				succ = tmp ; 
			} 
			return; 
		} 
		if (root.getTime() > key) { 
			succ = root; 
			findPreSuc(root.getLeft(), key); 
		} 
		else { 
			pred = root ; 
			findPreSuc(root.getRight(), key) ; 
		} 
	}



	public Node min(Node root){
		
		Node current = root;
		
		while (current.getLeft() != null) { 
            current = current.getLeft(); 
        } 
        return (current); 
	}
	
	public Node max(Node root){
		
		Node current = root;
		
		while (current.getRight() != null) { 
            current = current.getRight(); 
        } 
        return (current); 
	}



	public void delete(int key) { 
        root = deleteRec(root, key); 
    } 

	public Node deleteRec(Node root, int key) { 

        if (root == null)  return root; 

        if (key < root.getTime()) {
            root.setLeft(deleteRec(root.getLeft(), key)); 
		}
        else if (key > root.getTime()) {
            root.setRight(deleteRec(root.getRight(), key)); 
		}
 
        else { 
            if (root.getLeft() == null) {
                return root.getRight(); 
			}
            else if (root.getRight() == null) {
                return root.getLeft(); 
			}
            root.setTime(min(root.getRight()).getTime()); 
            root.setRight(deleteRec(root.getRight(), root.getTime())); 
        } 
        return root; 
    } 

	void print(Node root, Requests[] _req) { 
		inOrderTraversal(root, _req); 
    } 
  
  
    
    void inOrderTraversal(Node root, Requests[] _req) { 
        if (root != null) { 
            inOrderTraversal(root.getLeft(), _req); 
            System.out.println(_req[root.getReq_index()].getAirline().toString()); 
            inOrderTraversal(root.getRight(), _req); 
        } 
    } 
	
	

}

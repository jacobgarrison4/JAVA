
public class BST<E extends Comparable<E>> {
    private Node<E> root;

    public BST(){
        root = null;
    }
    // down and slow, focus
    public Node<E> getRoot(){
        return root;
    }

    public Node<E> find(E data){

        // Search the tree for a node whose data field is equal to data
    	Node<E> current = root;
    	E value = current.getData();
    	while ((current != null) && (value.compareTo(data) != 0)){
    		if (data.compareTo(value) == -1){
    			current = current.getLeftChild();
    		}

    		else if (data.compareTo(value) == 1){
    			current = current.getLeftChild();
    		}
    	}

    	return current;
    }

    public void insert(E data){
        Node<E> parent = null;
		Node<E> val = new Node<E>(data);
		Node<E> current = root;
		//see if tree is empty, if so, set root to the inserted value
		if (root == null){
			root = val;
			return;
		}
		//if tree is not empty, compare the insert value to the root, then its children until value is found 
		while (current != null){
			parent = current;
			//if inset value is less than current node, get left child
			if (data.compareTo(current.getData()) == -1){
				current = current.getLeftChild();
			} 
			//else, get right child
			else if (data.compareTo(current.getData()) == 1){
				current = current.getRightChild();
			} 
			//value is found
			else {
				return;
			}

		}
		//compare insert value to parent of current node and set nodes
		if (data.compareTo(parent.getData()) == -1){
			parent.setLeftChild(val);
			val.setParent(parent);

		} 

		else {
			parent.setRightChild(val);
			val.setParent(parent);
		}

    }

    public void delete(E data){
        // Find the right node to be deleted
        Node<E> current = find(data);
        Node<E> min;

        if (current == null) {
            return;
        }

        Node<E> parent = current.getParent();
        E cVal = current.getData();
        Node<E> lc = current.getLeftChild();
        Node<E> rc = current.getRightChild();
        if ((lc == null) && (rc == null)){
                if (parent != null){
                        if (parent.getData().compareTo(cVal) == -1){
                                parent.setRightChild(null);
                        } 

                        else {
                                parent.setLeftChild(null);
                        }
                }
            return;
        }
        // If said node has one child, delete it by making its parent point to its child.
        else if (((rc != null) && (lc == null)) || ((lc != null) && (rc == null))) {
            if (lc == null){
                if (parent != null){
                        if (parent.getData().compareTo(cVal) == -1){
                                parent.setRightChild(rc);
                        } 

                        else {
                                parent.setLeftChild(rc);
                        }
                }
                rc.setParent(parent);
            } 

            else {
                if (parent != null){
                        if (parent.getData().compareTo(cVal) == -1){
                                parent.setRightChild(lc);
                        } 

                        else {
                                parent.setLeftChild(lc);
                        }
                }
                lc.setParent(parent);
            }
            return;
        }
        
        else if ((rc != null) && (lc != null)){
            min = current;

            while (min.getLeftChild() != null){
                min = min.getLeftChild();
            }
            current.setData(min.getData());
            min.getParent().setLeftChild(null);
        }
    }

    public Node<E> minNode(Node<E> node) {

		Node<E> successor = node.getRightChild();

		while (successor.getLeftChild() != null) {
			successor = successor.getLeftChild();
		}

		return successor;

	}

    public void traverse(String order, Node<E> top) {
        if (top != null){
        	Node<E> lc = top.getLeftChild();
            Node<E> rc = top. getRightChild();
            switch (order) {
                case "preorder":
                   String preorder = "preorder";
                   System.out.print(top.getData() + " ");
                   traverse(preorder, lc);
                   traverse(preorder, rc);

                    break;
                case "inorder":
                	String inorder = "inorder";
                	traverse(inorder, lc);
                    System.out.print(top.getData() + " ");
                    traverse(inorder, rc);

                    break;
                case "postorder":
                    String postorder = "postorder";
                    traverse(postorder, lc);
                    traverse(postorder, rc);
                    System.out.print(top.getData() + " ");
                    break;
            }
        }
    }

    public boolean compare(Node<E> n1, Node<E> n2){
    	//nodes are same
    	if (n1 == null && n2 == null){
    		return true;
    	}
    	//nodes are different
    	else if ((n1 == null && n2 != null) || (n1 != null && n2 == null)){
    		return false;
    	}
    	//check left and right child nodes
    	else {
    		boolean rightChild = compare(n1.getRightChild(), n2.getRightChild());
    		boolean leftChild = compare(n1.getLeftChild(), n2.getLeftChild());
    		return (rightChild && leftChild);
    	}
    }
}

public class RBT1<E extends Comparable<E>> {
    private Node<E> root;

    public RBT1(){
        root = null;
    }

    public Node<E> getRoot(){
        return root;
    }

    public void insert(E data){
        boolean done = false;
        Node<E> temp = root;

        while(!done){
            if (root == null) {
                root = new Node<E>(data);
                temp.setColor('B');
                done = true;
            } else if (temp.getData().compareTo(data) > 0){
                if (temp.getLeftChild() == null){
                    temp.setLeftChild(new Node<E>(data));
                    temp.getLeftChild().setParent(temp);
                    done = true;
                }
                temp = temp.getLeftChild();
            } else if (temp.getData().compareTo(data) <= 0){
                if (temp.getRightChild() == null){
                    temp.setRightChild(new Node<E>(data));
                    temp.getRightChild().setParent(temp);
                    done = true;
                }
                temp = temp.getRightChild();
            }
        }

        if (temp != null){
            temp.setColor('R');
        }

        InsertColorFix(temp);
    }

    public void InsertColorFix(Node<E> x){
        while(x.getParent().getColor() == 'R'){
            if(x.getParent() == x.getParent().getParent().getLeftChild()){
                Node<E> y = x.getParent().getParent().getRightChild();
                if(y.getColor() == 'R'){
                    //case 1: x's uncle y is red
                    x.getParent().setColor('B');
                    y.setColor('B');
                    x.getParent().getParent().setColor('R');
                    x = x.getParent().getParent();
                }
                else {
                    if(x == x.getParent().getRightChild()){
                    //case 2: x's uncle y is black and x is a right child
                    x = x.getParent();
                    leftRotate(x);
                    }
                    //case 3: x's unlce is black and x is a left child
                    x.getParent().setColor('B');
                    x.getParent().getParent().setColor('R');
                    rightRotate(x.getParent().getParent());
                }
            }
            //same as above, only left and right are switched
            else {
                Node<E> y = x.getParent().getParent().getLeftChild();
                if(y.getColor() == 'R'){
                    x.getParent().setColor('B');
                    y.setColor('B');
                    x.getParent().getParent().setColor('R');
                    x = x.getParent().getParent();
                }
                else {
                    if(x == x.getParent().getLeftChild()){
                        x = x.getParent();
                        rightRotate(x);
                    }
                    x.getParent().setColor('B');
                    x.getParent().getParent().setColor('R');
                    leftRotate(x.getParent().getParent());
                }
            }
        }
        //make sure root is black
        root.setColor('B');
    }

    public Node<E> search(E data){
        boolean done = false;
        Node<E> temp = root;


        while(!done){
            if (temp == null){
                return null;
            }
            if(temp.getData().compareTo(data) == 0){
                done = true;
            } else if (temp.getData().compareTo(data) > 0){
                temp = temp.getLeftChild();
            } else if (temp.getData().compareTo(data) < 0){
                temp = temp.getRightChild();
            }
        }
        return temp;
    }

    public void delete(E data){
    	Node<E> temp = search(data);
        if (temp == null){
            return;
        }
        Node<E> replacement = new Node(null);

        boolean isRight;
        boolean isLeft;
        boolean isRoot;

        boolean hasChildren;
        boolean hasLeft;
        boolean hasRight;
        boolean hasBoth;

        // Find out if the node to be deleted is the root or if it is a left/right child
        if (temp == root){
            isRoot = true;
            isLeft = false;
            isRight = false;
        } else if (temp == temp.getParent().getLeftChild()){
            isRoot = false;
            isLeft = true;
            isRight = false;
        } else {
            isRoot = false;
            isLeft = false;
            isRight = true;
        }

        // Find out if the node to be deleted has children
        // If it does, find out if it has a Right/Left Child or both
        if (temp.getLeftChild() == null && temp.getRightChild() == null){
            hasChildren = false;
            hasBoth = false;
            hasLeft = false;
            hasRight = false;
        } else if (temp.getLeftChild() != null && temp.getRightChild() != null){
            hasChildren = true;
            hasBoth = true;
            hasLeft = true;
            hasRight = true;
        } else if (temp.getLeftChild() == null){
            hasChildren = true;
            hasBoth = false;
            hasRight = true;
            hasLeft = false;
        } else {
            hasChildren = true;
            hasBoth = false;
            hasRight = false;
            hasLeft = true;
        }

        // Seperate cases if the node to be deleted is the root of the tree
        if (isRoot){
            // Seperate cases depending on the number of children the node to be deleted has
            if (!hasChildren){
                root = replacement;
            } else if (hasBoth){
                replacement = getMin(temp.getRightChild());
                if (replacement == temp.getRightChild()){
                    replacement.setLeftChild(temp.getLeftChild());
                    replacement.setParent(temp.getParent());
                    replacement.getLeftChild().setParent(replacement);
                    root = replacement;
                } else {
                    if (replacement.getParent().getLeftChild() == replacement){
                        replacement.getParent().setLeftChild(null);
                    } else if (replacement.getParent().getRightChild() == replacement){
                        replacement.getParent().setRightChild(null);
                    }
                    replacement.setParent(temp.getParent());
                    replacement.setLeftChild(temp.getLeftChild());
                    replacement.setRightChild(temp.getRightChild());
                    temp.getLeftChild().setParent(replacement);
                    temp.getRightChild().setParent(replacement);
                    root = replacement;
                }

            } else if (hasLeft && !hasRight){
                temp.getLeftChild().setParent(null);
                root = temp.getLeftChild();
            } else if (hasRight && !hasLeft) {
                temp.getRightChild().setParent(null);
                root = temp.getRightChild();
            }
        } else {
            // This is the case where it isn't the root node
            if (!hasChildren){
                if (isLeft){
                    temp.getParent().setLeftChild(null);
                } else if (isRight){
                    temp.getParent().setRightChild(null);
                }
            } else if (hasBoth){
                replacement = getMin(temp.getRightChild());
                if (replacement == temp.getRightChild()){
                    replacement.setLeftChild(temp.getLeftChild());
                    replacement.setParent(temp.getParent());
                    replacement.getLeftChild().setParent(replacement);
                } else {
                    if (replacement.getParent().getLeftChild() == replacement){
                        replacement.getParent().setLeftChild(null);
                    } else if (replacement.getParent().getRightChild() == replacement){
                        replacement.getParent().setRightChild(null);
                    }
                    replacement.setParent(temp.getParent());
                    replacement.setLeftChild(temp.getLeftChild());
                    replacement.setRightChild(temp.getRightChild());
                    temp.getLeftChild().setParent(replacement);
                    temp.getRightChild().setParent(replacement);
                }
                if(isLeft){
                    temp.getParent().setLeftChild(replacement);
                } else if (isRight){
                    temp.getParent().setRightChild(replacement);
                }

            } else if (hasLeft && !hasRight){
                temp.getLeftChild().setParent(temp.getParent());
                temp.getParent().setLeftChild(temp.getLeftChild());
            } else if (hasRight && !hasLeft) {
                temp.getRightChild().setParent(temp.getParent());
                temp.getParent().setRightChild(temp.getRightChild());
            }
        }

        if (temp.getColor() == 'B'){
            DeleteColorFix(replacement);
        }
    }

    public void DeleteColorFix(Node<E> x){
        while(x != root && x.getColor() == 'B'){
            if(x == x.getParent().getLeftChild()){
                Node<E> w = x.getParent().getRightChild();
                if(w.getColor() == 'R'){
                    w.setColor('B');
                    x.getParent().setColor('R');
                    leftRotate(x.getParent());
                    w = x.getParent().getRightChild();
                }
                if(w.getLeftChild().getColor() == 'B' && w.getRightChild().getColor() == 'B'){
                    w.setColor('R');
                    x = x.getParent();
                }
                else {
                    if(w.getRightChild().getColor() == 'B'){
                        w.getLeftChild().setColor('B');
                        w.setColor('R');
                        rightRotate(w);
                        w = x.getParent().getRightChild();
                    }
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor('B');
                    w.getRightChild().setColor('B');
                    leftRotate(x.getParent());
                    x = root;
                }
            }
            //same as above with left and right switched
            else {
                Node<E> w = x.getParent().getLeftChild();
                if(w.getColor() == 'R'){
                    w.setColor('B');
                    x.getParent().setColor('R');
                    rightRotate(x.getParent());
                    w = x.getParent().getLeftChild();
                }
                if(w.getRightChild().getColor() == 'B' && w.getLeftChild().getColor() == 'B'){
                    w.setColor('R');
                    x = x.getParent();
                }
                else {
                    if(w.getLeftChild().getColor() == 'B'){
                        w.getRightChild().setColor('B');
                        w.setColor('R');
                        leftRotate(w);
                        w = x.getParent().getLeftChild();
                    }
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor('B');
                    w.getLeftChild().setColor('B');
                    rightRotate(x.getParent());
                    x = root;
                }
            }
        }
        x.setColor('B');
    }

    public void traverse(String order, Node<E> top) {
        if (top != null){
            switch (order) {
                case "preorder":
                    if (top.getData() != null) {
                        System.out.print(top.getData().toString() + " ");
                        traverse("preorder", top.getLeftChild());
                        traverse("preorder", top.getRightChild());
                    }
                    break;
                case "inorder":
                    if (top.getData() != null) {
                        traverse("inorder", top.getLeftChild());
                        System.out.print(top.getData().toString() + " ");
                        traverse("inorder", top.getRightChild());
                    }
                    break;
                case "postorder":
                    if (top.getData() != null) {
                        traverse("postorder", top.getLeftChild());
                        traverse("postorder", top.getRightChild());
                        System.out.print(top.getData().toString() + " ");
                    }
                    break;
            }
        }
    }


    public void rightRotate(Node<E> y){
        //set x
        Node<E> x = y.getLeftChild();
        //turn x's right subtree into y's left subtree
        y.setLeftChild(x.getRightChild());
        //if y's left child not null, sety's left child's new parent to x
        if(x.getRightChild() != null){
            x.getRightChild().setParent(y);
        }
        //link x's parent to y
        x.setParent(y.getParent());
        if(y.getParent() == null){
            root = x;
        }
        else if(y == y.getParent().getRightChild()){
            y.getParent().setRightChild(x);
        }
        else{
            y.getParent().setLeftChild(x);
        }
        //put y on x's right
        x.setRightChild(y);
        y.setParent(x);
    }

    public void leftRotate(Node<E> x){
        //set y
        Node<E> y = x.getRightChild();
        //turn y's left subtree into x's right subtree
        x.setRightChild(y.getLeftChild());
        //if y's left child not null, sety's left child's new parent to x
        if(y.getLeftChild() != null){
            y.getLeftChild().setParent(x);
        }
        //link x's parent to y
        y.setParent(x.getParent());
        if(x.getParent() == null){
            root = y;
        }
        else if(x == x.getParent().getLeftChild()){
            x.getParent().setLeftChild(y);
        }
        else{
            x.getParent().setRightChild(y);
        }
        //put x on y's left
        y.setLeftChild(x);
        x.setParent(y);
    }

    public Node<E> getMin(Node<E> top){
        boolean done = false;
        Node<E> temp = top;
        while(!done) {
            if (temp.getLeftChild() == null) {
                done = true;
            } else {
                temp = temp.getLeftChild();
            }
        }
        return temp;
    }   
}

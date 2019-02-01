

public class RedBlackTree <E extends Comparable<E>> {
	
	@SuppressWarnings("hiding")
	private  class Node <E extends Comparable<E>> {
		
		E element;
		Node<E> leftChild;
		Node<E> rightChild;
		Node<E> parent;
		boolean color;
		
		Node(E e, Node<E> left, Node<E> right,boolean c,Node<E> par){
			element = e;
			leftChild = left;
			rightChild = right;
			color = c;
			parent = par;
		}
	}

		Node<E> root = null;

		private String a="";
		
		private boolean done = false;

		

		public boolean insert(E el) {
			
			done=false;

			if (root == null) {

				root = new Node<E>(el, null, null, true,null);
				
				return true;

			}

			else {

				Node<E> p = root;

				while (done!=true) {
					
					if (el.compareTo(p.element)<0) {

						if (p.leftChild==null) {
					
							p.leftChild= new Node<E>(el,null,null,false,p);

							adjustAfterInsertion (p.leftChild);
							
							done = true;
							
							return true;

						}

						else {

							p=p.leftChild;
						}

					}

					if (el.compareTo(p.element)>0) {

						if (p.rightChild==null) {

							p.rightChild= new Node<E>(el,null,null,false,p);
				
							adjustAfterInsertion (p.rightChild);
							
							done = true;
							
							return true;
							
						}

						else {

							p=p.rightChild;

							System.out.println(p.element);
						}

					}
					
					if (el.compareTo(p.element)==0) {
						done = true;
						return false;
					}

				}

			}
			
			return false;

		}

		private void adjustAfterInsertion (Node<E> n) {
			
			System.out.println("T");
			
	        if (n != null && n != root && n.parent.color==false) {
	        	
	        	if (siblingOf(n.parent)!=null) {

	        		if (siblingOf(n.parent).color==false) {

	        			n.parent.color=true;

	        			siblingOf(n.parent).color=true;

	        			n.parent.parent.color = false;

	        			adjustAfterInsertion(n.parent.parent);
	

	        		}
	        	}

	        	
	            else if (n.parent == n.parent.parent.leftChild) {
	            	if ((n.parent!=null) && (n.parent.parent!=null)){ 
	            		
	            		if (n == n.parent.rightChild) {

	            			rotateLeft(n = n.parent);
	            		}

	            		n.parent.color=true;

	            		n.parent.parent.color=false;

	            		rotateRight(n.parent.parent);

	            	}
	        	}

	            else if (n.parent == n.parent.parent.rightChild) {
	            	if ((n.parent!=null) && (n.parent.parent!=null)){
	            		
	            		if (n == n.parent.leftChild) {

	            			rotateRight(n = n.parent);

	            		}  

	            		rotateLeft(n.parent.parent);

	            	}
	            }

	        }

	        	root.color=true;

	    }

		private Node<E> rotateLeft(Node<E> node) {

			Node<E> x = node.rightChild;
			if (node==root) {
	    		root=x;
			}
			node.rightChild = x.leftChild;

			x.leftChild = node;
			
			if (node.parent!=null) {
				if (node.parent.leftChild==node)
				node.parent.leftChild=x;
				if (node.parent.rightChild==node)
					node.parent.rightChild=x;
			}
			
			x.parent=node.parent;
			
			node.parent=x;
			
	        x.color = x.leftChild.color;

	        x.leftChild.color = false;

	        return x;		

		}

		

		private Node<E> rotateRight(Node<E> node) {

	        // assert (h != null) && isRed(h.left);

	        Node<E> x = node.leftChild;

	        node.leftChild = x.rightChild;

	        x.rightChild = node;
	        
	        if (node==root) {
	        	root = x;
	        }
	     
	        x.parent=node.parent;
	        
	        if (x.parent!=null)
	        	x.parent.rightChild=x;
	        
	        node.parent=x;

	        x.color = x.rightChild.color;

	        x.rightChild.color = false;

	        return x;

	    }



		private Node<E> siblingOf(Node<E> n) {

	        return (n == null || n.parent == null) ? null : (n == n.parent.leftChild) ? (Node<E>) n.parent.rightChild: (Node<E>) n.parent.leftChild;

	    }

		

		public String toString() {

			a="";

			

			if (root==null) {

				return "List Empty";

			}

			PreOrder(root);

			return a;

		}

		

		private void PreOrder (Node<E> root) {

			if (root == null)

				return;

			a+=" ";
			
			if (root.color==false) {
				a+="*";
			}

			a += String.valueOf(root.element);

			

			PreOrder (root.leftChild);

			PreOrder (root.rightChild);

		}

	
	public boolean contains (E key) {
		Node<E> p= root;
		if (p==null) {
			return false;
		}
		else {
			
			while (p!=null) {
				if (p.element.compareTo(key) == 0) {
						return true;
				}
				else if (key.compareTo(p.element)<0) {
					p=p.leftChild;
				}
				else if (key.compareTo(p.element)>0) {
					p=p.rightChild;				}
			}
		}
		return false;
		}
	

	

	

}


	

	



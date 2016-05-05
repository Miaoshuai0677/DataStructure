package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeADT {
	private String data=null;  
    private TreeADT  leftChild=null;  
    private TreeADT  rightChild=null;      
  
    public TreeADT (String data){
    	
        this.data=data;  
        this.leftChild=null;  
        this.rightChild=null;  
    }  

    //创建一颗二叉树
	public void createBinTree(TreeADT  root){  
	TreeADT  newNodeB = new TreeADT ("B");  
        TreeADT  newNodeC = new TreeADT ("C");  
        TreeADT  newNodeD = new TreeADT ("D");  
        TreeADT  newNodeE = new TreeADT ("E");  
        TreeADT newNodeF = new TreeADT ("F");  
        root.leftChild=newNodeB;  
        root.rightChild=newNodeC;  
        root.leftChild.leftChild=newNodeD;  
        root.leftChild.rightChild=newNodeE;  
        root.rightChild.rightChild=newNodeF;  
    }  
	//访问节点数据
	public void visted(TreeADT subTree){   
		System.out.println(subTree.data);;  
	    }
	//前序递归遍历
	public void preOrder(TreeADT subTree){  
		 if(subTree!=null){  
	            visted(subTree);  
	            preOrder(subTree.leftChild);  
	            preOrder(subTree.rightChild);  
	        }  
	    }
    //非递归,前序遍历.
  	public void noPreOrder(TreeADT subTree){
    	 Stack <TreeADT>stack=new Stack<TreeADT>();
    	 TreeADT p=subTree;
    	 while(!stack.empty()||p!=null){
    		 if(p!=null){
    			 visted(p);
    			 stack.push(p);
    			 p=p.leftChild;
    		 }
    		 else{
    			 p=stack.pop();
    			 p=p.rightChild;
    		 }
    		
    	 }
     }
	//递归中序遍历
	public void inOrder(TreeADT subTree){
		if(subTree!=null){
			inOrder(subTree.leftChild);
			visted(subTree);
			inOrder(subTree.rightChild);
		}
	}
	//非递归中序遍历
	public void noInOrder(TreeADT subTree){
		Stack<TreeADT> stack=new Stack<TreeADT>();
		TreeADT p=subTree;
		while(p!=null||!stack.empty()){
			if(p!=null){
				stack.push(p);
				p=p.leftChild;
			}
			else{
				p=stack.pop();
				visted(p);
				p=p.rightChild;
			}
		}
		
	}
	//递归后序遍历
	public void postOrder(TreeADT subTree){
		if(subTree!=null){
			postOrder(subTree.leftChild);
			postOrder(subTree.rightChild);
			visted(subTree);
		}
	}
	//非递归后序遍历
	public void noPostOrder(TreeADT subTree){
		Stack<TreeADT>stack=new Stack<TreeADT>();
		TreeADT p=subTree;
		TreeADT r=null;
		while(p!=null||!stack.empty()){
			if(p!=null){
				stack.push(p);
				p=p.leftChild;
			}
			else{
				p=stack.peek();
				if(p.rightChild!=null&&p.rightChild!=r){
					p=p.rightChild;
					stack.push(p);
					p=p.leftChild;
				}
				else{
					p=stack.pop();
					visted(p);
					r=p;
					p=null;
				}
				
			}
		}
		
	}
	//层次遍历
	public void levelOrder(TreeADT subtree){
		TreeADT p=subtree;
		Queue <TreeADT>queue=new  LinkedList<TreeADT>();//接口不能直接实例化，需要对象上转型;queue是个接口，而stack是个类。。
		queue.add(p);
		while(!queue.isEmpty()){
			p=queue.remove();//一定要保存队列的指针
			visted(p);
			if(p.leftChild!=null) queue.add(p.leftChild);
			if(p.rightChild!=null) queue.add(p.rightChild);
			
		}
	}
    public static void main(String[] args) {
// TODO Auto-generated method stub
    	TreeADT  root =new TreeADT ("A");
        root.createBinTree(root);
        //root.inOrder(root);
        //root.noInOrder(root);
       //root.postOrder(root);
		//root.noPostOrder(root);
        root.levelOrder(root);

}

}

	
	        

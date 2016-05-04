package tree;

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
  	public void noPreOrder(TreeNode subTree){
    	 Stack <TreeNode>stack=new Stack<TreeNode>();
    	 TreeNode p=subTree;
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
	       
    public static void main(String[] args) {
// TODO Auto-generated method stub
    	TreeADT  root =new TreeADT ("A");
        root.createBinTree(root);
        root.preOrder(root);

}

}

	
	        

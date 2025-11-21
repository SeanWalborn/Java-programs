package Lab8;


public class TreeNode {
		
		private String data;
		private TreeNode left;
		private TreeNode right;
		
		
		public TreeNode(String val, TreeNode lt, TreeNode rt) {
			data = val;
			left = lt;
			right = rt;
		}
		
		public void setData(String data) { this.data = data; }
		public void setLeft(TreeNode left) { this.left = left; }
		public void setRight(TreeNode right) { this.right = right; }
		public String getData() { return data; }
		public TreeNode getLeft() { return left; }
		public TreeNode getRight() { return right; }
		
}

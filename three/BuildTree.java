class Solution {

    int[] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0 , inorder.length - 1 , 0 , postorder.length - 1);
    }

    public TreeNode build(int l1 , int r1 , int l2 , int r2){
        if(l1 > r1)return null;
        TreeNode root = new TreeNode(postorder[r2]);
        int mid = l1;
        while(inorder[mid] != root.val) mid++;
        root.left = build(l1 , mid-1 , l2 , mid-l1-1+l2);
        root.right = build(mid+1 , r1 , mid-l1+l2 , r2-1);
        return root;

    }
}
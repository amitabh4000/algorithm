package ElementsofPI.BinaryTree;

import sun.reflect.generics.tree.Tree;

/**
 * Created by SAmitabh on 01-09-2016.
 */
public class LowestCommonAncestor {

    public static class Status{
        public int numOfNodes;
        public TreeNode<Integer> ancestor;

        public Status(int numOfNodes , TreeNode<Integer> ancestor){
            this.numOfNodes = numOfNodes;
            this.ancestor = ancestor;
        }
    }
    public static TreeNode<Integer> leastAncestor(TreeNode <Integer> tree ,
                                                  TreeNode <Integer> node0 ,
                                                  TreeNode <Integer> node1){

        return findAncestor(tree , node0, node1).ancestor;

    }
    public static Status findAncestor( TreeNode <Integer> tree , TreeNode <Integer> node0 , TreeNode <Integer> node1){


        if(tree == null ) return new Status(0 , null);
        Status leftStatus = findAncestor(tree.left, node0,node1);
        if( leftStatus.numOfNodes == 2) return leftStatus;
        Status rightStatus = findAncestor(tree.right,node0,node1);
        if( rightStatus.numOfNodes == 2) return rightStatus;

        int numNodes = leftStatus.numOfNodes + rightStatus.numOfNodes +  ((node0 == tree || node1 == tree ) ? 1 : 0 );
        return new Status(numNodes ,numNodes == 2  ? tree:null);
    }

}

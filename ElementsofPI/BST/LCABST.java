package ElementsofPI.BST;

/**
 * Created by SAmitabh on 16-09-2016.
 */
public class LCABST {

    public BSTNode<Integer> LCA(BSTNode<Integer> root ,
                                BSTNode<Integer> a ,
                                BSTNode<Integer> b) {

        BSTNode<Integer> iter = root;
        while (iter != null) {
            if (iter.data > a.data && iter.data > b.data) {
                iter = iter.left;
            }
            else
            if (iter.data < a.data && iter.data < b.data) {
                iter = iter.right;
            } else return iter;

        }
        return iter;
    }
}

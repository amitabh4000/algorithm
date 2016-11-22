package ElementsofPI.BST;

/**
 * Created by SAmitabh on 16-09-2016.
 */
public class FirstKeyGreater {

    public static BSTNode<Integer> firstKeyGreater(BSTNode<Integer> root,int num){

        BSTNode<Integer> firstSoFar = null;
        BSTNode<Integer> iter = root;
        while(iter != null) {
            if (iter.data > num) {
                firstSoFar = iter;
                iter = iter.left;
            }
            else{
                iter = iter.right;
            }
        }
        return firstSoFar;
    }

}

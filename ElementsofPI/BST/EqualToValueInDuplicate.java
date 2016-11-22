package ElementsofPI.BST;

/**
 * Created by SAmitabh on 16-09-2016.
 */
public class EqualToValueInDuplicate {

    public static BSTNode<Integer> EqualToValueInDuplicate(BSTNode<Integer> root,int num){

        BSTNode<Integer> firstSoFar = null;
        BSTNode<Integer> iter = root;
        while(iter != null) {
            if (iter.data > num) {
                iter = iter.left;
            }
            else if(iter.data == num){
                firstSoFar = iter;
                if(iter.left.data == num)
                    iter = iter.left;
                else return firstSoFar;
            }
            else{
                iter = iter.right;
            }
        }
        return firstSoFar;
    }

}

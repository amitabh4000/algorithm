package ElementsofPI.BinaryTree;

/**
 * Created by SAmitabh on 15-09-2016.
 */
public class LockingBinaryTree {

    public static class Binarytree{

        private Binarytree left,right,parent;
        private boolean locked = false;
        private int numLockedDescendents = 0;

        public boolean lock(){

            if(locked || numLockedDescendents >0) {
                return false;
            }
            for(Binarytree iter = parent; parent != null ; iter = iter.parent){
                if(iter.locked){
                    return false;
                }
            }

            locked = true;
            for(Binarytree iter = parent; parent != null ; iter = iter.parent){
                ++parent.numLockedDescendents;
            }

            return true;
        }
        public boolean isLocked(){
            return locked;
        }
        public void unlock(){
            if(locked){
                locked = false;
                for(Binarytree iter = parent; parent != null ; iter = iter.parent){
                    --parent.numLockedDescendents;
                }

            }
        }

    }

}

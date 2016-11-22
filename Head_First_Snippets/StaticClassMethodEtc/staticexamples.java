package Head_First_Snippets.StaticClassMethodEtc;

/**
 * Created by SAmitabh on 09-11-2016.
 */
public class staticexamples {

    static int numstat = 2;
    int num = 9;

    static class STC {
        static int statnumstat = numstat + staticexamples.numstat;

    }
     class MC {
         int g;
         MC(){
             g = staticexamples.this.numstat;
         }                 // The variable could not be declared static
     }
     void test(){
         class inner{
             int n = numstat;
         }
     }
    static void test2(){
        class inner{
            void innerfunc(){
                int g = 5;
            }
        }
    }


    public static void main(String[] args){

        staticexamples se = new staticexamples();
        STC stc  = new STC();
        MC mc = se.new MC();
    }
}

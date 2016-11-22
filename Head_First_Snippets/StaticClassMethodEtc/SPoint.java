package Head_First_Snippets.StaticClassMethodEtc;

import java.util.*;

public class SPoint {


    static List<SPoint> objStore = new ArrayList<>();
    int x;
    int y;
    SPoint(int x, int y){                 /// Here we can see how the static list stores a list where all objects of this class
                                          /// can be stored.
        objStore.add(this);
        this.x = x;
        this.y =y;
    }

    public int getIndex(){
        return objStore.indexOf(this);
    }
    public SPoint getPoint(int i){
        return objStore.get(i);
    }
}

package EffectiveJava.hashCodeExample;

import java.util.*;
public class PhoneNumber {

    String code;
    String number;
    //PhoneNumber()

    @Override
    public boolean equals(Object o){

        if(o== this) return true;
        else if(o instanceof PhoneNumber){
            PhoneNumber number = (PhoneNumber) o;
            return Objects.equals(code,number.code)
                    && Objects.equals(number,number.number);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(code,number);
    }
}

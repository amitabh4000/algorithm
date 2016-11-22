package Head_First_Snippets;

import Head_First_Snippets.SinkDotCom.Sinkdriver;

/**
 * Created by SAmitabh on 23-07-2016.
 */
public class Triangle extends Sinkdriver {
    @Override
    public void india() {
        
        super.india();
    }

    int height;
    int length;
    int area;

    public Triangle(int height, int length) {
        this.height = height;
        this.length = length;

    }

    public void setheight(){
        height = height+10;
    }

    public static void main(String[] args) {

        Triangle[] tArray = new Triangle[3];

        tArray[0] = new Triangle(4, 7);
        tArray[0].india();
        tArray[1] = new Triangle(5, 8);
        tArray[2] = tArray[0];
        for( int i = 0 ; i <= 2 ; i++) {
            tArray[i].setArea();
            System.out.printf("The triangle no. %d has area : %d\n" ,i ,tArray[i].area);
        }
        tArray[1].setheight();
        Triangle temp = new Triangle(4,6);
        temp.passObject(tArray[1]);
    }

    public void passObject(Triangle t2){
        t2.setArea();
        System.out.println("The area of t2 is: " + t2.area);
        System.out.println("The height of t2 is: "+t2.height);
    }

    public void setArea() {
        if (height > 4)
            area = height * length - 5;
        else{
            area = height*length;
        }
    }
}
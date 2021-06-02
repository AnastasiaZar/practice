package ru.stqa.pft.sandbox;

import java.awt.*;

public class MyFirstProgram {

    public static void main(String[] args) {
        Hello("Eva");
        Hello("user!");
        Square s = new Square(5);
        System.out.println("square "+ s.l + " = " + s.area () );
        Rectangle r = new Rectangle(4,6);
        System.out.println(" rectangle " + " = " + r.area());
        Chtoto c = new Chtoto(2,2,2);
        System.out.println(" Chtoto " + " = " +  c.area());

    }


    


    public static void Hello(String smd){
        System.out.println("Hello , " + smd);
    }




}





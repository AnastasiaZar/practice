package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        Hello("Eva");
        Hello("user!");
    double len = 5;
        System.out.println("square "+ len + " = " + area (len) );
        double a = 4;
        double b = 6;
        System.out.println(" x " + " = " + area(a, b));

    }


    public static void Hello(String smd){
        System.out.println("Hello , " + smd);
    }

    public static double area(double l) {
        return l*l;
    }

    public static double area(double a, double b){
        return a * b;
    }
}





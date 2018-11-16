package com.company;

public class Main {

    public static void main(String[] args) {

        Vector A = new Vector(1, 2, 3);
        Vector B = new Vector(10, 6, 3);
        Vector.checkСollinearity(A, B);
        System.out.println(A.hashCode());
        A = null;
        System.gc();


    }
}

import java.util.Scanner;


public class Vector {

    private double X;
    private double Y;
    private double Z;

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getZ() {
        return Z;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setZ(double z) {
        Z = z;
    }

    public Vector(double x, double y, double z) {
        X = x;
        Y = y;
        Z = z;
    }

    public Vector(double x) {
        X =0;
        Y =0;
        Z =0;
    }

    public Vector() {
        Scanner in=new Scanner(System.in);
        X =in.nextInt();
        Y =in.nextInt();
        Z =in.nextInt();
    }

    public void MultiplyByNumber(double number){ //Умножение вектора на скалярную велечину
        X*=number;
        Y*=number;
        Z*=number;
    }

    public void Show(){

        System.out.println("X="+X+"\n"+"Y="+Y+"\n"+"Z="+Z+"\n");
    }

    public double Module(){ //Нахождение модуля

        return Math.sqrt(X*X+Y*Y+Z*Z);
    }

    public void Normalization(){ //Нормирование вектора
        double k =Module();
        X/=k;
        Y/=k;
        Z/=k;
    }
}

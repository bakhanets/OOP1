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

    public boolean checkСollinearity(Vector a,Vector b){ //Проверка векторов на коллинеарность
        if ((a.X/b.X==a.Y/b.Y)&&(a.Y/b.Y==a.Z/b.Z)){
            return true;
        }
        else return false;
    }

    public void Normalization(){ //Нормирование вектора
        double k =Module();
        X/=k;
        Y/=k;
        Z/=k;
    }
    public Vector Sum(Vector a,Vector b){
        Vector C=new Vector(a.X+b.X,a.Y+b.Y,a.Z+b.Z);
        return C;
    }
    public Vector Difference(Vector a,Vector b){ // Есть другой вариант реализации
        Vector C=new Vector(a.X-b.X,a.Y-b.Y,a.Z-b.Z);
        return C;
    }


    public Vector Multiplication(Vector a,Vector b){ // Векторное произведение двух векторов
        if (checkСollinearity(a,b)){ //Если векторы коллинеарны , то их произведение даёт нулевой вектор
            return new Vector(0);
        }
        Vector C=new Vector(a.Y*b.Z-a.Z*b.Y,a.Z*b.X-a.X*b.Z,a.X*b.Y-a.Y*b.X);
        return C;
    }

    public double scalarMultiplication(Vector a,Vector b){ // Скалярное произведение векторов
        return a.X*b.X+a.Y*b.Y+a.Z*b.Z;
    }

    public double cosBetween(Vector a,Vector b){//Косинус угла между векторами
        return (scalarMultiplication(a, b))/(a.Module()*b.Module());
    }

    public double sinBetween(Vector a,Vector b){
        return 1-cosBetween(a,b);
    }

    public double degreeBetween(Vector a, Vector b){//находит угол между векторами значение в градусах
        return Math.toDegrees(Math.acos(cosBetween(a,b)));
    }
}

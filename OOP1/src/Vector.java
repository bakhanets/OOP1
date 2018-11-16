package com.company;

public class Vector {

    private double X;
    private double Y;
    private double Z;

//    public void delete(){
//        this=null;
//        System.gc();
//        System.out.println("Объект был удалён");
//    }

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
        System.out.println(this.hashCode());
    }

    public Vector() {
        X = 0;
        Y = 0;
        Z = 0;
        System.out.println(this.hashCode());
    }

    public void MultiplyByNumber(double number) { //Умножение вектора на скалярную велечину
        X *= number;
        Y *= number;
        Z *= number;
    }

    public void Show() {

        System.out.println("X=" + X + "\n" + "Y=" + Y + "\n" + "Z=" + Z + "\n");
    }

    public double Module() { //Нахождение модуля

        return Math.sqrt(X * X + Y * Y + Z * Z);
    }

    static public boolean checkСollinearity(Vector a, Vector b) { //Проверка векторов на коллинеарность
        if (b.X==0||b.Y==0||b.Z==0){throw new NullPointerException("Нельзя делить на ноль!!!");

        }
        if ((a.X / b.X == a.Y / b.Y) && (a.Y / b.Y == a.Z / b.Z)) {
            return true;
        } else return false;
    }

    public void Normalization() { //Нормирование вектора
        double k = Module();
        X /= k;
        Y /= k;
        Z /= k;
    }

    static public Vector Sum(Vector a, Vector b) {
        Vector C = new Vector(a.X + b.X, a.Y + b.Y, a.Z + b.Z);
        return C;
    }

    static public Vector Difference(Vector a, Vector b) { // Есть другой вариант реализации
        Vector C = new Vector(a.X - b.X, a.Y - b.Y, a.Z - b.Z);
        return C;
    }


    static public Vector Multiplication(Vector a, Vector b) { // Векторное произведение двух векторов
        if (checkСollinearity(a, b)) { //Если векторы коллинеарны , то их произведение даёт нулевой вектор
            return new Vector();
        }
        Vector C = new Vector(a.Y * b.Z - a.Z * b.Y, a.Z * b.X - a.X * b.Z, a.X * b.Y - a.Y * b.X);
        return C;
    }

    static public double scalarMultiplication(Vector a, Vector b) { // Скалярное произведение векторов
        return a.X * b.X + a.Y * b.Y + a.Z * b.Z;
    }

    static public double cosBetween(Vector a, Vector b) {//Косинус угла между векторами
        return (scalarMultiplication(a, b)) / (a.Module() * b.Module());
    }

    static public double sinBetween(Vector a, Vector b) {
        Vector c = Multiplication(a, b);
        return c.Module() / a.Module() * b.Module();
    }

    static public double degreeBetween(Vector a, Vector b) {//находит угол между векторами значение в градусах
        Vector c = Multiplication(a, b);
        return Math.atan2(c.Module(),scalarMultiplication(a, b));
    }
}

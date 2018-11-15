//Копирование вектора , нужно ли оно ?

public class Main {

    public static void main(String[] args) {

        Vector A = new Vector(3,-4,0);

        Vector B = new Vector(4, -4, 2);

        System.out.println(A.cosBetween(A,B));
        System.out.println(A.degreeBetween(A,B));


    }
}

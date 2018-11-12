//Копирование вектора , нужно ли оно ?

public class Main {

    public static void main(String[] args) {

        Vector first=new Vector(0);
        System.identityHashCode(first);

        //Vector second=new Vector();
       // System.identityHashCode(second);

        Vector third=new Vector(2.5,3.2,4.2);
        System.identityHashCode(third);


        first.setX(10);

        first.MultiplyByNumber(10);
        first.Show();
        System.out.println(first.Module());
        first.Normalization();
        first.Show();



        /*System.out.println(first.hashCode());
        System.out.println(second.hashCode());
        System.out.print(third.hashCode());*/


    }
}

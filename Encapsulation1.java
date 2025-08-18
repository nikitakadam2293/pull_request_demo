package encapsulation;
class Encapsulation11{
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    private void dummy()
    {
        System.out.println("Encapsulation");
    }
     void dummy1()
    {
        dummy();
        System.out.println("Encapsulation====");
    }
    /*Encapsulation11(int b)
    {
        this.a=b;
    }*/
}
public class Encapsulation1 {
    public static void main(String[] args) {
        Encapsulation11 obj=new Encapsulation11();
        obj.setA(22);
        obj.setA(44);
        obj.dummy1();
        System.out.println(obj.getA());
    }


}

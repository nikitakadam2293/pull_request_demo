package encapsulation;

/*
class A1
{
    private int b;
    A1(int a)
    {
        this.b=a;
    }

   */
/* public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
    }*/




public class WhyUseObjectAndSetterMethod {

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

  /*  WhyUseObjectAndSetterMethod(int d)
        {
            this.a=d;
        }*/
    public static void main(String[] args) {
        WhyUseObjectAndSetterMethod obj=new WhyUseObjectAndSetterMethod();
        obj.setA(44);
        System.out.println(obj.getA());
        //System.out.println(obj.a);

        /*A1 obj=new A1(11);
        System.out.println("value of a "+obj.b);
       obj.setA(11);
        System.out.println(obj.getA());
*/
    }

}

package encapsulation;

 class M
 {
     static {
         System.out.println("static block");


         // inside static block static/ non static  method not allowed
         //A static block can contain only statements (such as variable initialization, method calls, etc.),
         // not method declarations.
          /* static void fundd()
         {

         }//*/
     }
  static void fun()
     {
         System.out.println("M fun");
     }
 }
 class StaticScenario1 extends  M {


  static void fun()
     {
         System.out.println("StaticScenario1 static method");
     }

         public static void main(String[] args) {
             StaticScenario1 a = new StaticScenario1();

             a.fun();
            // StaticScenario1.fun();
             //M m =new StaticScenario1();
             //m.fun();

// static method override hot nahi

             //System.out.println(StaticScenario1.a);


     }

 }


public class Foothill
{
   public static void main(String[] args)
   {
//       InternetUser user,user1,user2,user3;
//       System.out.println("/*---------------------------------------------------------");
//       System.out.println("Base Class Testing ***********************\n");
//       user = new InternetUser();
//       user1 = new InternetUser("dns","");
//       user2 = new InternetUser("n","75.75.75.75");
//       user3 = new InternetUser();
//       user3.setName("n");
//       System.out.println(user);
//       System.out.println(user1);
//       System.out.println(user2);
//       System.out.println(user3);
//       System.out.println("\nsuccess as expected");
//       System.out.println("---------------------------------------------------------*/");

      System.out.println("Derived Class Constructor Testing ***************\n");
      System.out.println("----------------");
      Communicator user,user1, user2, user3, user4, user5;
      user = new Communicator();
      System.out.println(user);
      
      System.out.println("\n\n----------------");
      user1 = new Communicator("salim lakhani","10.1.10.1");
      System.out.println(user1);
      
      System.out.println("\n\n----------------");
      user2 = new Communicator("yan kam","127.90.32.14");
      System.out.println(user2);
      
      System.out.println("\n\n----------------");
      user3 = new Communicator("sally","");
      System.out.println(user3);
      
      System.out.println("\n\n----------------");
      user4 = new Communicator("betty","1.1.1.1");
      System.out.println(user4);
      
      System.out.println("\n\n----------------");
      user5 = new Communicator("giral","");
      System.out.println(user5);
      System.out.println("\n(more supplied by student)");
      System.out.println("\n\n(other tests supplied by student)");
      System.out.println("--------------------------------------------------------- */");
   }
}

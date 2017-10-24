
public class InternetUser
{
   public final static int MIN_NAME_LENGTH = 2;
   public final static int MAX_NAME_LENGTH = 50;
   public final static int MIN_IP_LENGTH = 7;
   public final static int MAX_IP_LENGTH = 15;
   public final static String DEFAULT_IP = "0.0.0.0";
   public final static String DEFAULT_NAME = "(undefined)";
   private String name;
   private String ip;

   InternetUser(String userName, String ipAddress)
   {
      if (validateName(userName))
      {
         this.name = userName;
      } else
      {
         this.name = "bad";
      }
      if (validateIp(ipAddress))
      {
         this.ip = ipAddress;
      } else
      {
         this.ip = DEFAULT_IP;
      }
   }

   InternetUser()
   {
      this.name = DEFAULT_NAME;
      this.ip = DEFAULT_IP;
   }

//   public String getName()
//   {
//      return name;
//   }
//
//   public String getIp()
//   {
//      return ip;
//   }

   public void setName(String name)
   {
      if (validateName(name))
      {
         this.name = name;
      } else
      {
         this.name = "bad";
      }
   }

   public void setIp(String ip)
   {
      if (validateIp(ip))
      {
         this.ip = ip;
      } else
      {
         this.ip = DEFAULT_IP;
      }
      this.ip = ip;
   }

   public String toString()
   {
      String output;
      output = "Name: " + name + "\n" + "IP Aaddr: " + ip + "\n";
      return output;
   }

   private static boolean validateName(String n)
   {
      if (n.length() > MAX_NAME_LENGTH || n.length() < MIN_NAME_LENGTH)
      {
         return false;
      }
      return true;
   }

   private static boolean validateIp(String ipA)
   {
      if (ipA.length() > MAX_IP_LENGTH || ipA.length() < MIN_IP_LENGTH)
      {
         return false;
      }
      return true;
   }
}

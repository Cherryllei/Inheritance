
public class Communicator extends InternetUser
{

   public final static int ERROR_FLAG_NUM = 0;
   private final static long MAX_PQ = (long) Math.sqrt(Long.MAX_VALUE);

   private IntPair publicKey;
   private IntPair privateKey;

   private long firstPrime;
   private long secondPrime;
   private long n, phi, e, d;

   public Communicator()
   {
      super();
      firstPrime = 0;
      secondPrime = 0;
   }

   public Communicator(long firstPrime, long secondPrime)
   {
      super();
      if (computeBothEncrKeys())
      {
         this.firstPrime = firstPrime;
         this.secondPrime = secondPrime;
      }
   }

   public Communicator(String name, String ip)
   {
      super(name, ip);
      if (computeBothEncrKeys())
      {
         firstPrime = 0;
         secondPrime = 0;
      }
   }

   public Communicator(String name, String ip, long firstPrime, long secondPrime)
   {
      super(name, ip);
      if (computeBothEncrKeys())
      {
         this.firstPrime = firstPrime;
         this.secondPrime = secondPrime;
      }
   }

   public void setFistPrime(long firstPrime)
   {
      if (computeBothEncrKeys())
      {
         this.firstPrime = firstPrime;
      }
   }

   public void setSecondPrime(long secondPrime)
   {
      if (computeBothEncrKeys())
      {
         this.secondPrime = secondPrime;
      }
   }

   public String toString()
   {
      StringBuilder result = new StringBuilder();
      result.append(super.toString());
      result.append(
            "\n(p, q)  n, phi, e, d: (" + firstPrime + ", " + secondPrime + ")" +"  "+ n + ", " + phi + ", " + e + ", " + d);
      result.append("\nprivate key" + privateKey);
      result.append("\npublic key" + publicKey);
      return result.toString();
   }

   private boolean computeBothEncrKeys()
   {
      if (firstPrime < MAX_PQ || secondPrime < MAX_PQ)
      {
         n = firstPrime * secondPrime;
         phi = (firstPrime - 1) * (secondPrime - 1);
         e = EncryptionSupport.getSmallRandomPrime();
         d = EncryptionSupport.inverseModN(e, n);
         publicKey = new IntPair(e, n);
         privateKey = new IntPair(d, n);
         return true;
      } else
         return false;
   }
}
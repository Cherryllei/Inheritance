
public class Communicator extends InternetUser {

    public final static int ERROR_FLAG_NUM = 0;
    private final static long MAX_PQ = (long) Math.sqrt(Long.MAX_VALUE);

    private IntPair publicKey;
    private IntPair privateKey;

    private long firstPrime;
    private long secondPrime;
    private long n, phi, e, d;

    public Communicator() {
        super();
        setPrimes(0, 0);
    }

    public Communicator(long firstPrime, long secondPrime) {
        super();
        setPrimes(firstPrime, secondPrime);
    }

    public Communicator(String name, String ip) {
        super(name, ip);
        setPrimes(0, 0);
    }

    public Communicator(String name, String ip, long firstPrime, long secondPrime) {
        super(name, ip);
        setPrimes(firstPrime, secondPrime);
    }

    public boolean setPrimes(long first, long second) {
        boolean isValid = false;
        if (first != second && EncryptionSupport.isPrime(firstPrime) && EncryptionSupport.isPrime(secondPrime)
                & firstPrime <= MAX_PQ && secondPrime <= MAX_PQ) {
            firstPrime = first;
            secondPrime = second;
            if (computeBothEncrKeys()) {
                isValid = true;
            }
        }
        if (isValid) {
            return true;
        }
        // set all numeric to ERROR_FLAG_NUM
        n = ERROR_FLAG_NUM;
        phi = ERROR_FLAG_NUM;
        e = ERROR_FLAG_NUM;
        d = ERROR_FLAG_NUM;
        publicKey = new IntPair(ERROR_FLAG_NUM, ERROR_FLAG_NUM);
        privateKey = new IntPair(ERROR_FLAG_NUM, ERROR_FLAG_NUM);
        return false;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString());
        result.append(
                "\n(p, q)  n, phi, e, d: (" + firstPrime + ", " + secondPrime + ")" + "  " + n + ", " + phi + ", " + e + ", " + d);
        result.append("\npublic key" + publicKey);
        result.append("\nprivate key" + privateKey);

        return result.toString();
    }

    public IntPair getPublicKey() {
        return publicKey;
    }

    public IntPair getPrivateKey() {
        return privateKey;
    }

    private boolean computeBothEncrKeys() {
        if (firstPrime != ERROR_FLAG_NUM && secondPrime!= ERROR_FLAG_NUM) {
            n = firstPrime * secondPrime;
            phi = (firstPrime - 1) * (secondPrime - 1);
            e = EncryptionSupport.getSmallRandomPrime();
            d = EncryptionSupport.inverseModN(e, n);
            publicKey = new IntPair(e, n);
            privateKey = new IntPair(d, n);
            return true;
        }
        return false;
    }
}
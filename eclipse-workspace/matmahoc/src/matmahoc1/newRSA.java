package matmahoc1;
 
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
 
public class newRSA
{
    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int        bitlength = 1024;
    private Random     r;
 
    public newRSA()
    {
        r = new Random();
        //tao so nguyen to p co gia tri 1024 bit
        p = BigInteger.probablePrime(bitlength, r);
        //tao so nguyen to p co gia tri 1024 bit
        q = BigInteger.probablePrime(bitlength, r);
        //Tinh N
        N = p.multiply(q);
        // phi=(p-1)(q-1)
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        //tim so e la so nguyen to cung nhau voi phi va   0< e < phi
        e = BigInteger.probablePrime(bitlength / 2, r);
        //khi UCLN cua phi va e =1 va e < phi
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        {
            e.add(BigInteger.ONE);
        }
        //d =e^-1 mod phi
        d = e.modInverse(phi);
    }
 
    public newRSA(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }
 
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException
    {
        newRSA rsa = new newRSA();
        DataInputStream in = new DataInputStream(System.in);
        String teststring="loveyousoomuch";
        
        System.out.println("String in Bytes: "
                + bytesToString(teststring.getBytes()));
        
        // encrypt
        byte[] encrypted = rsa.encrypt(teststring.getBytes());
        // decrypt
        byte[] decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypting Bytes: " + bytesToString(decrypted));   
        System.out.println("Decrypted String: " + new String(decrypted));
    }
 
    private static String bytesToString(byte[] encrypted)
    {
        String test = "";
        for (byte b : encrypted)
        {
            test += Byte.toString(b);
        }
        return test;
    }
 
    // Encrypt message
    public byte[] encrypt(byte[] message)
    { // M^e mod N 
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }
    	
     // C^d mod N
    // Decrypt message
    public byte[] decrypt(byte[] message)
    {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }
}
package matmahoc1;

import java.math.BigInteger;
import java.util.Random;

public class test {
	 private static BigInteger p;
	    private static BigInteger q;
	    private BigInteger N;
	    private BigInteger phi;
	    private BigInteger e;
	    private BigInteger d;
	    private static int        bitlength = 1024;
	    private static Random     r;
	public static void main(String[]args) {
		 r = new Random();
		 p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        System.out.print(""+p+" to \n"+q);
	}

}

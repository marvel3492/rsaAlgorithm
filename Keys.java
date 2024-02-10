package rsaAlgorithm;

import java.math.BigInteger;

public interface Keys {
	//Splits messages into smaller parts
	public static final int BYTES_PER_SECTION = 5;
	
	//Private keys; only the receiver has these keys; p and q must be prime
	public static final BigInteger p = new BigInteger("5915587277");
	public static final BigInteger q = new BigInteger("1500450271");
	
	//Public keys; everyone has these keys; e and ɸ(n) (NN) must be relatively prime; do not change n
	public static final BigInteger e = new BigInteger("8876044532898802067");
	public static final BigInteger n = p.multiply(q); //Make sure that n > 2^(8 x BYTES_PER_SECTION)
	
	//More private keys; only the receiver has these keys; do not change below!
	public static final BigInteger P_MINUS_ONE = p.subtract(BigInteger.ONE);
	public static final BigInteger Q_MINUS_ONE = q.subtract(BigInteger.ONE);
	public static final BigInteger NN = P_MINUS_ONE.multiply(Q_MINUS_ONE);
	public static final BigInteger d = e.modInverse(NN);
}
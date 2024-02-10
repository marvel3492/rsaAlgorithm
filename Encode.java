package rsaAlgorithm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

class Encode implements Keys {
	public static void main(String[] args) throws IOException {
		FileInputStream input = new FileInputStream("input.txt");
		byte[] bytes = input.readAllBytes();
		input.close();
		
		ArrayList<BigInteger> sections = new ArrayList<BigInteger>();
		BigInteger num = BigInteger.ZERO;
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];
			num = num.add(BigInteger.valueOf(b));
			if (i != bytes.length - 1) {
				num = num.shiftLeft(8);
			}
			if ((i + 1) % BYTES_PER_SECTION == 0 || i == bytes.length - 1) {
				sections.add(num);
				num = BigInteger.ZERO;
			}
		}
		
		ArrayList<BigInteger> ciphertexts = new ArrayList<BigInteger>();
		for (int i = 0; i < sections.size(); i++) {
			ciphertexts.add(sections.get(i).modPow(e, n));
		}
		
		PrintWriter encrypted = new PrintWriter("encrypted.txt");
		for (BigInteger ciphertext : ciphertexts) {
			encrypted.write(ciphertext.toString() + '\n');
		}
		encrypted.close();
	}
}
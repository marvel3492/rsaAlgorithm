package rsaAlgorithm;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

class Decode implements Keys {
	public static void main(String[] args) throws IOException {
		ArrayList<BigInteger> ciphertext = new ArrayList<BigInteger>();
		Scanner scanner = new Scanner(new FileReader("encrypted.txt"));
		while (scanner.hasNext()) {
			BigInteger num = scanner.nextBigInteger();
			ciphertext.add(num);
		}
		
		ArrayList<BigInteger> sections = new ArrayList<BigInteger>();
		for (int i = 0; i < ciphertext.size(); i++) {
			BigInteger num = ciphertext.get(i).modPow(d, n);
			sections.add(num);
		}
		
		FileOutputStream output = new FileOutputStream("output.txt");
		for (BigInteger section : sections) {
			for (int i = 0; i < section.toByteArray().length && i < BYTES_PER_SECTION; i++) {
				output.write(section.toByteArray()[i]);
			}
		}
		output.close();
	}
}
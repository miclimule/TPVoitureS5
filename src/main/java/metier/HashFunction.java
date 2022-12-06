package metier;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class HashFunction {

	// Available alhgorithms are : MD2 , MD5 , SHA1 , SHA224 , SHA226 , SHA384 , SHA512
	
	public static String getHash(String hashText) {
		byte[] inputBytes = hashText.getBytes();
		String hashValue = "";
		try {
			HashAlgo algo = null;
			int rand = (int)Math.floor(Math.random()*(7-1+1)+1);
			System.out.println(rand);
			for (HashAlgo hashAlgo : HashAlgo.values()) {
				if (rand==hashAlgo.getVal()) {
					algo = hashAlgo;
					break;
				}
			}
			MessageDigest digest = MessageDigest.getInstance(algo.getAlgo());
			digest.update(inputBytes);
			byte[] digestedBytes = digest.digest();
			hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
		} catch (Exception e) {}
		return hashValue;
	}
	
	public static String getHash(String hashText, String algorithm) {
		String hashValue = "";
		try {
			byte[] inputBytes = hashText.getBytes();
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.update(inputBytes);
			byte[] digestedBytes = digest.digest();
			hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
		} catch (Exception e) {}
		return hashValue;
	}
	
	public static void main(String[] args) {
		System.out.println(getHash("ok"));
	}
	
}

import static java.lang.System.out;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Q1 {
	static String s1;
	static String s2;
	public static void HashDigestChange(String string1, String string2) throws NoSuchAlgorithmException {
		s1 = string1;
		s2 = string2;
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.reset();
		messageDigest.update(string2.getBytes());
		byte [] bs1 = messageDigest.digest();
		String base64String1 = Base64.getEncoder().encodeToString(bs1);
		
		
		messageDigest.reset();
		messageDigest.update(string1.getBytes());
		byte [] bs2 = messageDigest.digest();
		String base64String2 = Base64.getEncoder().encodeToString(bs2);
		
		out.println("string: " + string1 + "   base64Digest: " + base64String1);
		out.println("string: " + string2 + "   base64Digest: " + base64String2);
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First String");
		String s1 = sc.next();
		System.out.println("Enter Second String");
		String s2 = sc.next();
		HashDigestChange(s1,s2);
}
}

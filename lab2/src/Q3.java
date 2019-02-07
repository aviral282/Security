import static java.lang.System.out;

import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

public class Q3 {
	static String s1;
	public static void usingAPI(String string) {
		s1 = string;
		out.println(DigestUtils.md5Hex(string.getBytes()));
		out.println(DigestUtils.sha256Hex(string.getBytes()));
	}
public static void main(String[] args) {
	System.out.println("Enter the  String");
	Scanner sc = new Scanner(System.in);
	s1 = sc.next();
	usingAPI(s1);
}
}

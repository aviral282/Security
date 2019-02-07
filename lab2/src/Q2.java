import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;  //import
import java.util.Base64;
import java.util.Scanner;

public class Q2 {
	public static void hashTheFile() throws NoSuchAlgorithmException, IOException {
		File file = new File("aviral.txt");
		
		if(file.exists()) {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.reset();
			
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(file);
			StringBuilder stringBuilder = new StringBuilder();
			while(scanner.hasNextLine()) {
				stringBuilder.append(scanner.nextLine());
			}
		
			messageDigest.update(new String(stringBuilder).getBytes(), 0, new String(stringBuilder).getBytes().length);
			byte [] digestBs = messageDigest.digest();
			
			String string = Base64.getEncoder().encodeToString(digestBs);
			out.println(string);
		}
	}
public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
	
	hashTheFile();
}
}

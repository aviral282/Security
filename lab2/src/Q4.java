import static java.lang.System.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

public class Q4 {
	public static void hashTheFileUsingAPI() throws FileNotFoundException, IOException {
		File file = new File("aviral.txt");
		if(file.exists()) {
			String digest = DigestUtils.sha256Hex(new FileInputStream(file));
			out.println(digest);
		}
	}
public static void main(String[] args) throws FileNotFoundException, IOException {
	hashTheFileUsingAPI();
}
}

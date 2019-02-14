package hMac;

import static java.lang.System.out;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class Q3 {
	public static void Q3() throws NoSuchAlgorithmException,  IOException,ClassNotFoundException ,InvalidKeyException {
		File file = new File("data/secretKey.txt");
	
		Scanner scanner = new Scanner(file);
		SecretKey secretKey = (SecretKey) stringToObject(scanner.nextLine());

		File file2 = new File("data/sendText.txt");
		String messageString = new Scanner(file2).nextLine();
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(secretKey);
		byte [] signature1 = mac.doFinal(messageString.getBytes());
		String signatureString = Base64.getEncoder().encodeToString(signature1);

		String signature = new Scanner(new File("data/hmac.txt")).nextLine();
		System.out.println("Does Signature Match ? : " + signature.equals(signatureString));

	}

	public static String objectToString(Object object) throws IOException {
		String baseString = "";
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(object);
		baseString= Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
		objectOutputStream.close();
		return baseString;
	}
	
	public static Object stringToObject(String string) throws ClassNotFoundException, IOException {
		byte [] bytes2 = Base64.getDecoder().decode(string);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes2);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		return objectInputStream.readObject();
	}
	public static void main(String [] args) throws InvalidKeyException, NoSuchAlgorithmException, ClassNotFoundException, IOException
	{
		System.out.println("Calculate the HMAC for the text and Compare it with the value received.:");
		Q3();
	}

}

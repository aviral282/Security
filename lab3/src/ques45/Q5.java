package ques45;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Mac;
import javax.crypto.SecretKey;

import hMac.Q3;

public class Q5 {
	public static void main(String [] args) throws UnknownHostException, IOException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeyException, InterruptedException {
		Socket socket = new Socket("127.0.0.1", 1152);
		File file = new File("data/secretKey1");
		Scanner scanner = new Scanner(file);
		SecretKey secretKey = (SecretKey) Q3.stringToObject(scanner.nextLine());
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(secretKey);
		byte [] bs2 = null;
		
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader_Server = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            bufferedReader_Server = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.print("Please input some text : ");
            String message = "";
            while ((message = bufferedReader.readLine()) != null) {
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                String getMessage = bufferedReader_Server.readLine();
                System.out.println("Message From server" + getMessage);
                
                getMessage = bufferedReader_Server.readLine();
                System.out.println("Message From server" + getMessage);
                
                bufferedWriter.write(Base64.getEncoder().encodeToString(mac.doFinal(bs2)));
                bufferedWriter.newLine();
                bufferedWriter.flush();
                
                getMessage = bufferedReader_Server.readLine();
                System.out.println("Message From server" + getMessage);
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

	}

}

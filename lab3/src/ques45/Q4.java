package ques45;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

import hMac.Q3;

import static java.lang.System.*;

public class Q4 {
	public static void main(String [] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
		byte[] bs = generatSecretKey();
		ServerSocket serverSocket = new ServerSocket(1152);
		Socket socket = null;
		socket = serverSocket.accept();
		 try {
	            System.out.println("Message From Client: " + socket.getInetAddress().getHostAddress() );
	            BufferedReader bufferedReader = null;
	            BufferedWriter bufferedWriter = null;
	            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	            String message = "";
	            while ((message = bufferedReader.readLine()) != null) {
	                System.out.println("Message From The Client:" + socket.getInetAddress().getHostAddress() + message);
					String s = "";
	                if(message.length() < 20){
						bufferedWriter.write(" Hello There");
						bufferedWriter.newLine();
						bufferedWriter.flush();
						bufferedWriter.write(" Message From Server");
						bufferedWriter.newLine();
						bufferedWriter.flush();
					}else if(true){
	                	out.println(Base64.getEncoder().encodeToString(bs));
	                	if(message.equals(Base64.getEncoder().encodeToString(bs))){
							bufferedWriter.write("Transmission Sucessfull");
							bufferedWriter.newLine();
							bufferedWriter.flush();
						}else {
							bufferedWriter.write("Failed To connect");
							bufferedWriter.newLine();
							bufferedWriter.flush();
							System.exit(0);
						}
					}
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                serverSocket.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	public static byte [] generatSecretKey() throws InvalidKeyException,NoSuchAlgorithmException ,FileNotFoundException, IOException  {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
		SecretKey secretKey = keyGenerator.generateKey();
		File file = new File("data/secretKey1");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileWriter fileWriter2 = new FileWriter(file);
		fileWriter2.write(Q3.objectToString(secretKey));
		fileWriter2.flush();
		fileWriter2.close();
		Mac macinst = Mac.getInstance("HmacSHA256");
		macinst.init(secretKey);
		byte [] bs1 = macinst.doFinal();
		return bs1;
	}

}

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;

import javax.crypto.spec.DHParameterSpec;

public class DhKeyGenerator {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
AlgorithmParameterGenerator paraGen = AlgorithmParameterGenerator.getInstance("DH");
paraGen.init(1024);
AlgorithmParameters params = paraGen.generateParameters();

DHParameterSpec dhspec = params.getParameterSpec(DHParameterSpec.class);
String s = "..."+ dhspec.getP() + "..." + dhspec.getG()+"..."+dhspec.getL();

System.out.println(dhspec.getP());
System.out.println("\n new one");
System.out.println(dhspec.getG());
System.out.println("\n new one");
System.out.println(dhspec.getL());

	}

}

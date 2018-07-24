import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
/**
 * In this Main class we take arguments for the mode(ecb) ,cipher text 1,plain text file and cipher file 2
 * This Main uses methods in a seperate Decipher file to run these specified arguments.
 * static String method at the bottom allows the an argument to be used with standard char sets.
 * User mst enter ecb as first argument in order to receive output file and command output.
 * 
 * @param args
 * @throws IOException
 */
	
public static void main(String[] args) throws IOException{
	
	
	File output = new File(args[4]);	
	Decrypt decrypt = new Decrypt();
		
	
	String ECBc1= new String(args[1]);
	String ECBp1= new String(args[2]);
	String ECBc2= new String(args[3]);
	
	String p1f = readFile(ECBp1, StandardCharsets.UTF_8);
	String c1f = readFile(ECBc1, StandardCharsets.UTF_8);
	String c2f = readFile(ECBc2, StandardCharsets.UTF_8);
	
	String Mode = args[0];
	
	if(Mode.toLowerCase().equals("ecb")){
	
		//decrpy get key method called to obtain the key with the parameters of args[1] and args[2]
		decrypt.getkey(p1f, c1f);
		//decipher method used to pass the key through args[3] file in order to receive args[3] key.
		decrypt.deciper(c2f, decrypt.getKey());
		System.out.println("------------");
		
		//Bufferedwriter creates a file that will be outputted containing the decrypted text of args[3]
		BufferedWriter Filewrite = new BufferedWriter(new FileWriter(output));
		Filewrite.write(decrypt.getDeCip());
		Filewrite.close();
	
	
		//System.out.println(p1f);
		//System.out.println(c1f);
		//System.out.println(c2f);	
		
	}else{
		System.out.println("please enter ecb as the first argument to gain access to ecb mode.");
	}
}

private static String readFile(String path, Charset encoding)throws IOException {
	 byte[] encoded = Files.readAllBytes(Paths.get(path));
	return new String(encoded,encoding);
}

	
	
	
}

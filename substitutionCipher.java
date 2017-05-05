import java.io.*;
import java.util.Scanner;
public class substitutionCipher {
public static void main(String[] args)throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		System.out.print("What is the file name: ");
		String fileName = in.next();
		
		File file = new File(fileName);
		Scanner fileText = new Scanner(file);
		String text = fileText.nextLine().toUpperCase();
		final char key [] = {'B','A','D','C','F','E','H','G','J','I','L','K','N','M','P','O','R','Q','T','S','V','U','W','X','Z','Y'};
		System.out.println("Encypted message: \n" + enc(key, text)); // Encrypt the file
		System.out.println("\nDecypted message: \n" + dec(key, enc(key, text))); //decrypt the file
	}
	
	public static String enc(char[] key, String msg1) { // key=shift
		char a [] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char [] msg = msg1.toCharArray();
		char [] newText = new char[msg.length]; 

		for(int i = 0; i < msg.length; i++){
			if(msg[i] == ' ' || msg[i] == '.'){
				newText[i] = msg[i];
			}else{
				for(int j = 0; j < a.length; j++){
					if(msg[i] == a[j])
						newText[i] = key[j];
				}
			}
		}
		String newStr = new String(newText);
		return newStr;
	}


	public static String dec(char[] key, String msg1){ // key=shift
	char a [] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char [] msg = msg1.toCharArray();
		char [] newText = new char[msg.length]; 

		for(int i = 0; i < msg.length; i++){
			if(msg[i] == ' ' || msg[i] == '.'){
				newText[i] = msg[i];
			}else{
				for(int j = 0; j < a.length; j++){
					if(a[j] == msg[i])
						newText[i] = key[j];
				}
				
			}
		}
		String newStr = new String(newText);
		return newStr;
	}
}
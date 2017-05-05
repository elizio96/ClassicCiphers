import java.io.*;
import java.util.Scanner;
public class shiftCipher {
	public static void main(String[] args)throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		System.out.print("What is the file name and key: ");
		String fileName = in.next();
		int shift = in.nextInt();
		
		File file = new File(fileName);
		Scanner fileText = new Scanner(file);
		String text = fileText.nextLine().toUpperCase();
		
		System.out.println("Encypted message: \n" + enc(shift, text)); // Encrypt the file
		System.out.println("\nDecypted message: \n" + dec(shift, enc(shift, text))); //decrypt the file
	}
	public static String enc(int shift, String msg1) throws FileNotFoundException{
		shift = shift %26;
		char a [] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char [] msg = msg1.toCharArray();
		char [] newText = new char[msg.length]; 
		int pos = 0;	
		for (int j = 0; j < msg.length; j++) {
			for(int k = 0; k < 26; k++){
				if(msg[j] == a[k])
					pos = k;
			}
			int diff;
			if(msg[j] == ' ' || msg[j] == '.'){
				newText[j] = msg[j];
			}
			else if((pos+shift) >= a.length){
				diff = (pos+shift)-a.length;
				newText[j] = (char)(a[diff]);
			}else
			    newText[j] = (char)(msg[j]+ shift);
		}
		String newStr = new String(newText);
		return newStr;
	}
	
	public static String dec(int shift, String msg1) throws FileNotFoundException{
		shift = shift %26;
		char a [] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char [] msg = msg1.toCharArray();
		char [] newText = new char[msg.length]; 
		int pos = 0;
		for (int j = 0; j < msg.length; j++) {
			for(int k = 0; k < 26; k++){
				if(msg[j] == a[k])
					pos = k;
			}
			int diff;
			if(msg[j] == ' '  || msg[j] == '.'){
				newText[j] = msg[j];
			}
			else if((pos-shift) < 0){
				diff = (pos-shift)+a.length;
				newText[j] = (char)(a[diff]);
			}else
		   		newText[j] = (char)(msg[j]-shift);
		}
		String newStr = new String(newText);
		return newStr;
	}
}
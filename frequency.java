import java.io.*;
import java.util.Scanner;
public class frequency {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the file name: ");
		String fileName = in.next();
		final char a [] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		File file = new File(fileName);
		Scanner fileText = new Scanner(file);
		String msg = fileText.nextLine().toUpperCase();
		
		double [] frequ = frequencyFile(msg);
		
		System.out.println("Frequency of characters for file " + file);

		for(int j = 0; j < a.length; j++){
			if(frequ[j] != 0)
				System.out.println(a[j] + ": "+ frequ[j]);
		}
	}
	
	public static double[] frequencyFile(String file){
		char a [] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		double [] frequ = new double[26];
		double sum = 0;
		for(int i = 0; i < frequ.length; i++){
			frequ[i] = countF(file, a[i]);
			sum += frequ[i];
		}
		for (int z = 0; z < frequ.length; z++) {
			frequ[z] = (frequ[z]/sum);
		}
		return frequ;

	}

	public static int countF(String msg, char c){
		int count = 0;
		for(int i = 0; i < msg.length(); i++){
			if(msg.charAt(i) == c)
				count++;
		}
		return count;
	}
	
}
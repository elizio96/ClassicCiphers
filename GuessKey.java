import java.io.*;
import java.util.Scanner;
public class GuessKey {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.println("What is the file name and key: ");
		String fileName = in.next();
		int shift = in.nextInt();
		
		final double e[] = {.08167, .01492, .02782, .04253, .1702, .02228, .02015, .06094, .06966, .00153, .00772, .04025, .02406, .06749, .07507, .01929, .00095, .05987, .06327, .09056, .02758, .00978, .02360, .00150, .01974, .00074}; //letter distribution of plain text
		
		
		File file = new File(fileName);
		Scanner fileText = new Scanner(file);
		String text = fileText.nextLine().toUpperCase();
		
		
		
		shiftCipher shiftC = new shiftCipher();	
		frequency frequ = new frequency();
		findingMin m = new findingMin();
			
		double [] arraySum = new double[26];   
		double [] dis = new double[26];

			
		double sum = 0;
		double result = 0;
		//int num = 0;
			
		for(int i = 0; i<26; i++){
			String decrpyted = shiftC.dec(i, text);
			double [] f = frequ.frequencyFile(decrpyted);
			for(int j = 0; j < f.length; j++){
				dis[j] = Math.abs(f[j]-e[j]);
				sum += dis[j];
			}
			sum = sum/2;
			arraySum[i] = sum;
		}
		
		
		for(int i = 0; i < arraySum.length; i++){
			System.out.println(arraySum[i]);
		}
		m.five(arraySum);
			
	}
	
}

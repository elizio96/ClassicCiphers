public class findingMin {
	public static void five(double array[]){
		int key [] = new int [6];
		double temp = 10.0;
		for(int j = 0; j < key.length; j++){
			double x = min(array);
			for(int i = 0; i < array.length; i++){
				if(array[i] == x){
					key[j] = i;
					array[i] = temp;
				}
			}
		}
		
		System.out.println("\nPossible Keys:");
		for(int i = 1; i < key.length; i++){
			System.out.println("Key " + i + ":" + key[i]);
		}
		
		
	}
	
 	public static double min(double array[]){
		double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
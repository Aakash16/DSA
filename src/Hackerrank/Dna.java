package Hackerrank;

public class Dna {

	private static int findHealthiest(String[] genes, int[] health, int f, int l, String dna) {
		int healthSum = 0;
		
		for(int j=f; j<=l; j++){
            String gene = genes[j];
            System.out.println("dna: " + dna + " gene: " + gene);
            for (int i = -1; (i = dna.indexOf(gene, i + 1)) != -1; i++) {
            	System.out.println(i);
                if(i>=0){
                    healthSum += health[j];
                }
            }
        }
		/*
		 * for(int i=0; i<dna.length(); i++){ for(int j=i; j<=dna.length();j++){ String
		 * subdna = dna.substring(i,j); for(int k=f; k<=l; k++){
		 * if(subdna.equals(genes[k])){ healthSum += health[k]; } } } }
		 */

		return healthSum;
	}

	public static void main(String[] args) {

		int s = 3;
		int[] health = new int[] { 1, 2, 3, 4, 5, 6 };
		String[] genes = new String[] { "a", "b", "c", "aa", "d", "b" };

		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

		int first = 1;
		int last = 5;
		String d = "caaab";
		int hlth1 = findHealthiest(genes, health, first, last, d);
		
		first = 0;
		last = 4;
		d = "xyz";
		int hlth2 = findHealthiest(genes, health, first, last, d);
		
		first = 2;
		last = 3;
		d = "bcdybc";
		int hlth3 = findHealthiest(genes, health, first, last, d);
		System.out.println(hlth1 + " " + hlth2 + " " + hlth3);
				
	
	}
}

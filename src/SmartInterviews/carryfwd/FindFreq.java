package SmartInterviews.carryfwd;

public class FindFreq {

	public static void main(String[] args) {
		int[] ar = new int[] {1,5,10,3,5,8,1,10,4,3};
		ff(ar);
	}
	
	private static void ff(int[] ar) {
		
		int k = 100;
		int n = ar.length;
		for(int i=0;i<n;i++) {

			ar[ar[i]%k - 1] += k;
			
		}
		
		for(int i=1;i<n;i++) {
			System.out.print(ar[i-1]/k + " ");
			
		}
		
		
	}
}

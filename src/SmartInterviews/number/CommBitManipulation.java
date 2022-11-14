package SmartInterviews.number;

public class CommBitManipulation {
	
	public static void main(String[] args) {
		System.out.println(checkbit(5, 2));
		System.out.println(countBits(7));
		
	}

	private static boolean checkbit(int N, int i) {
		
		boolean is = ((N >> i) % 2 == 0);
		
		return is;
	}
	
	private static int countBits2(int N) {
		int c = 0;
		while(N !=0) {
			N += (N) & (N-1);
			c++;
		}
		
		return c;
	}
	
	private static int countBits(int N) {
		int c = 0;
		while(N !=0) {
			
			if(N % 2 == 1)
				c++;
			
			N = N>>1;
		}
		
		return c;
	}
}

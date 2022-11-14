package Interviewbit.math;

public class ReverseInt {

	public static void main(String[] args) {
		
		int a = -123;
		boolean neg = true;
		
		
		if(neg) {
			a *= -1;
		}
		int res = 0;
		while(a>0) {
			
			int u = a%10;
			res = (res*10) + u;
			a /= 10;
		}
		if(neg)
			res *= -1;
		System.out.println(res);
		
	}
}

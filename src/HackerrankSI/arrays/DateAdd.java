package HackerrankSI.arrays;
import java.util.Scanner;

public class DateAdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int count = sc.nextInt();

		final String[] smon = new String[] { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT",
				"NOV", "DEC" };
		final String[] sday = new String[] { "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday",
				"Wednesday" };

		final int[] mons = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int c = 0; c < count; c++) {
			long sec = sc.nextLong();

			long days = 0;
			
			days += sec / 86400;
			int weekday = (int) days % 7;

			long year = 0;
			
			int i=0;
			System.out.println(days);
			int lp = i+1970;
			while(days >= (isLeap(lp)?366:365)) {
				
				lp = i+1970;
				if(isLeap(lp)) {
					days -= 366;
					System.out.println("y:"+ (1970+i));
				}
				else
					days -= 365;
				
				i++;
			}
		
			year = 1970+i;
			
			System.out.println("fy:"+year);
			if (isLeap(year)) {
				mons[1] = 29;
				System.out.println("leap true");
			}else {
				mons[1] = 28;
			}
			
			i = 0;

			System.out.println("d:" + days);
			while (days >= (mons[i])) {
				System.out.println("m:"+ i + " mm:" + mons[i] + " d:"+days);
				days -= mons[i];
				
				i++;
			}
			
			System.out.println("fi:"+i);
			
			System.out.print(String.format("%02d", (days+1)));
			System.out.print("-" + smon[i] + "-" +  year + " ");
			System.out.println(sday[weekday]);

		}
		sc.close();
	}
	
	private static boolean isLeap(long year) 
    { 
        if (year % 400 == 0) 
            return true; 
      
        else if (year % 100 == 0) 
            return false; 
      
        else if (year % 4 == 0) 
            return true; 
        
        return false; 
    } 
}

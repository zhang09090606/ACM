package isprime;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()) {
			long n=scanner.nextLong();
			if(n==1) {
				System.out.println("Stan wins.");
				continue;
			}
			if(isPrime(n)) {
				System.out.println("Ollie wins.");
			}else {
				System.out.println("Stan wins.");
			}
		}
	}
	
	
	
	  public static boolean isPrime( long num ) 
	 	{
	  	 if(num ==2|| num==3 )
	  	        return  true;
	  	    if(num %6!= 1&&num %6!= 5)
	  	        return false ;
	  	    int tmp =(int)Math.sqrt(num);
	  	    for(int i= 5;i <=tmp; i+=6 )
	  	    if(num %i== 0||num %(i+ 2)==0 )
	  	        return false ;
	  	    return true ;
	  	    }
	 	
	 	
	 	
	 	
}


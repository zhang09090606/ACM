package min_tree;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;



public class Main {
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        long sum=9;
//        for(int i=0;i<20;i++) {
//        	sum*=9;
//        	System.out.println(sum+",");
//        }
        while(sc.hasNext()) {
        	int n=sc.nextInt();
        	int sum=0;
        	while(n>9) {
        		n/=9;
        		sum++;
        	}
        	System.out.println(sum);
        }
}
    

}
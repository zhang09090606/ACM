package max_shangshengzxl;

public class Main {
	static int LIS(int a[],int n)
	//a[]�����Ҫ����������У�n����Ҫ������ַ�����-1  
	    {  
	        int i,j;  
	        int ans=1;  
	        int m=0;  
	        int[] dp=new int[n+1];  
	        dp[1]=1;  
	        for(i=2;i<=n;i++)  
	        {  
	            m=0;  
	            for(j=1;j<i;j++)  
	            {  
	                if(dp[j]>m&&a[j]<a[i])  
	                    m=dp[j];  
	            }  
	            dp[i]=m+1;  
	            if(dp[i]>ans) 	 
	                ans=dp[i];  
	        }  
	        return ans;  
	    }  

	}



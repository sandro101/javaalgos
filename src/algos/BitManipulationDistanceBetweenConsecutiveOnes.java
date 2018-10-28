package algos;

class BitManipulationDistanceBetweenConsecutiveOnes {
	
	public static void main(String[] args) {
		System.out.println(new BitManipulationDistanceBetweenConsecutiveOnes().binaryGap(22));
	}
	
	public int binaryGap(int N)
	{
	    int[]a=new int[32];
	    int k=0,sum=0;
	    while(N>0)
	    {
	        int r=N%2;
	        a[k++]=r;
	        N/=2;
	    }

	    for(int i=0;i<a.length;i++)
	    {
	        if(a[i]==1)
	            for(int j=i+1;j<a.length;j++)
	            {
	                if(a[j]==1)
	                {
	                    if((j-i)>sum)
	                        sum=(j-i);
	                    break;
	                }
	            }
	    }
	    return sum;
	}
}
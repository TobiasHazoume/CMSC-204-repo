
public class ArraySum {

	public int sumOfArray(Integer[] a, int index) {
		// TODO Auto-generated method stub
		
		if(index < 0) 
		{
			return 0;
		}else
		{
			return  a[index] + sumOfArray(a,index-1);
			
		}
	}

}

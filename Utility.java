
interface Utility {
	double Pi= 3.14;
	int sum(int x, int y);
	
	default int sq(int x)
	{
		return x*x;
	}
	
	public static int power(int x, int n){
		int res = 1;
		for (;n>0;n--)
			res *= x;
		return res;
	}
}

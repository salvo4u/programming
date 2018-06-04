package euler;

public class problem14_1 
{
	public static void main(String[] args) 
	{	
		int result = 0;
		int biggest = 0;
		long number = 0;
		int counter = 0;
 
		for( int i=1; i<1000000; i++ )
		{
			number = i;
			counter = 0;
 
			while( number != 1 )
			{
				if( number%2 == 0 )
				{
					number = number/2;
				}
				else
				{
					number = 3*number+1;
				}
				counter++;
			}
 
			if( counter > biggest )
			{
				biggest = counter;
				result = i;
			}
		}
 
		System.out.println( result );
	}
}
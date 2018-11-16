package DynamicProgramming.OneTwoThreePlus;

import java.util.Scanner;

public class Main
{
	int[] memory = new int[11];	// n < 11
	
	public Main()
	{
		/*
		 * Testcase1
		 * - Input :
		 * 3
		 * 4 7 10
		 * - Output :
		 * 7
		 * 44
		 * 274
		 */
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for( int i = 0; i < t; ++i )
		{
			System.out.println(this.solution(in.nextInt()));
			this.memory = new int[11];
		}
	}
	
	public int sum(int[] col)
	{
		int sum = 0;
		
		for( int i = 0; i < col.length; ++i )
			sum += col[i];
		
		return sum;
	}
	
	public int solution(int n)
	{			
		if( n == 1 )
			return 1;
		
		if( this.memory[n] > 0 )
			return this.memory[n];
		
		this.memory[n] = solution(n - 1) + 1;
		
		if( n > 3 )
			this.memory[n] = solution(n - 3) + 1;
		else if( n > 2 )
			this.memory[n] = solution(n - 2) + 1;
		
		return this.memory[n];
	}
	
	public static void main(String[] args)
	{
		long before = System.currentTimeMillis();
		new Main();
		long after = System.currentTimeMillis();
		
		// Erase it
		System.out.println("Running Time : " + (after - before) + "ms");
	}
}
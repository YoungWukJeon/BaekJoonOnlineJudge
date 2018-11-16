package DynamicProgramming.MakeItOne;

import java.util.Scanner;

public class Main
{
	int[] memory = new int[1000001];	// n < 1000000
	
	public Main()
	{
		// Test Input -> Test Output
		// 2->1, 10->3
		
		/*
		 * Testcase1
		 * - Input : 2
		 * - Output : 1
		 * 
		 * Testcase2
		 * - Input : 10
		 * - Output : 3 
		 */
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		System.out.println(this.solution(n));
	}
	
	public int solution(int n)
	{
		if( n == 1 )
			return 0;
		
		if( this.memory[n] > 0 )
			return this.memory[n];
		
		this.memory[n] = solution(n - 1) + 1;
		
		if( n % 3 == 0 )
		{
			int preValue = solution(n / 3) + 1;
			
			if( this.memory[n] > preValue )
				this.memory[n] = preValue;
		}
		else if( n % 2 == 0 )
		{
			int preValue = solution(n / 2) + 1;
			
			if( this.memory[n] > preValue )
				this.memory[n] = preValue;
		}
		
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
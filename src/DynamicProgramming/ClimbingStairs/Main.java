package DynamicProgramming.ClimbingStairs;

import java.util.Scanner;

public class Main
{
	int[] memory = new int[301];	// n < 1000000
	
	public Main()
	{		
		/*
		 * Testcase1
		 * - Input : 
		 * 6
		 * 10
		 * 20
		 * 15
		 * 25
		 * 10
		 * 20
		 * - Output : 75
		 */
		
		// 6 10 20 15 25 10 20
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int stair[] = new int[n];
		
		for( int i = 0; i < n; ++i )
			stair[i] = in.nextInt();
		
		System.out.println(this.solution(n, stair, 1, 1));
	}
	
	public int solution(int n, int[] stair, int current, int stepCnt)
	{
		System.out.println(current + ", " + stepCnt);
		
		if( current > n )
			return 0;
		
		if( current == n )
			return stair[n - 1];
		
		if( memory[current] > 0 )
			return memory[current];
		
		if( (stepCnt == 2 && current + 2 != n) || current == 1 )
			memory[current] = stair[current - 1] + solution(n, stair, current + 1, 1);
		
		memory[current] += stair[current - 1] + solution(n, stair, current + 2, 2);
		
		return memory[n];
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

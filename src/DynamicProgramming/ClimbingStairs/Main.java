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
		
		System.out.println(this.solution(n, stair));
	}
	
	public int solution(int n, int[] stair)
	{
		this.memory[0] = stair[0];
		this.memory[1] = max(stair[0] + stair[1], stair[1]);
		this.memory[2] = max(stair[0] + stair[2], stair[1] + stair[2]);
		
		for( int i = 3; i < n; ++i )
			this.memory[i] = max(this.memory[i - 2] + stair[i], this.memory[i - 3] + stair[i - 1] + stair[i]);
		
		return memory[n - 1];
	}
	
	int max(int a, int b)
	{
		return a > b? a: b;
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
package DynamicProgramming.RGBDistance;

import java.util.Scanner;

public class Main
{
	int[][] memory = new int[1001][3];	// n <= 1000
	
	public Main()
	{		
		/*
		 * Testcase1
		 * - Input : 
		 * 3
		 * 26 40 83
		 * 49 60 57
		 * 13 89 99
		 * - Output : 96
		 */
		
		// 3 26 40 83 49 60 57 13 89 99
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int [][]colorCost = new int[n + 1][3];
		
		for( int i = 1; i <= n; ++i )
		{
			colorCost[i][0] = in.nextInt();	// Red
			colorCost[i][1] = in.nextInt();	// Green
			colorCost[i][2] = in.nextInt();	// Blue
		}
		
		System.out.println(this.solution(n, colorCost));
	}
	
	public int solution(int n, int[][] colorCost)
	{
		for( int i = 1; i <= n; ++i )
		{
			this.memory[i][0] = min(this.memory[i - 1][1], this.memory[i - 1][2]) + colorCost[i][0];
			this.memory[i][1] = min(this.memory[i - 1][0], this.memory[i - 1][2]) + colorCost[i][1];
			this.memory[i][2] = min(this.memory[i - 1][0], this.memory[i - 1][1]) + colorCost[i][2];
		}
		
		return min(this.memory[n][0], min(this.memory[n][1], this.memory[n][2]));
	}

	int min(int a, int b)
	{
		return a < b? a: b;
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
package DynamicProgramming.OneTwoThreePlus;

import java.util.Scanner;

public class Main
{
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
			System.out.println(this.solution(in.nextInt()));
	}
	
	public int solution(int n)
	{			
		/*
		 * solution(n) = 1 + solution(n - 1), 2 + solution(n - 2), solution(n - 3); (n > 3)
		 * solution(7) = {1} + solution(6), {2} + solution(5), {3} + solution(4) = 44
		 * solution(6) = {1} + solution(5), {2} + solution(4), {3} + solution(3) = 24
		 * solution(5) = {1} + solution(4), {2} + solution(3), {3} + solution(2) = 13
		 * solution(4) = {1} + solution(3), {2} + solution(2), {3} + solution(1) = 7
		 * solution(3) = {1} + solution(2), {2} + solution(1), {3} + solution(0) = 4
		 * solution(2) = {1} + solution(1), {2} + solution(0) = 2
		 * solution(1) = {1} + solution(0) = 1
		 */
		
		if( n == 1 )
			return 1;
		
		if( n == 2 )
			return 2;
		
		if( n == 3 )
			return 4;
		
		return solution(n - 3) + solution(n - 2) + solution(n - 1);
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
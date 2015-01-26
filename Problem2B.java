//least round num.
package codeforce;
import java.util.*;
public class CodeForce {

    public static int find_five(int no)
    {
    	int c=0;
    	while(no%5==0)
    	{
    		c++;
    		no = no/5;
    	}
    	return c;

    } 

    public static int find_two(int no)
    {
    	int c=0;
    	while(no%2==0)
    	{
    		c++;
    		no = no/2;
    	}
    	return c;

    }
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//initialize a nxn 2-d array
		int[][] board = new int[n][n];
		//for processing
		int[][] process = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				board[i][j] = in.nextInt();
			}
		}

		/*for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}*/

		System.out.println(find_five(board[0][0]));
	}

}
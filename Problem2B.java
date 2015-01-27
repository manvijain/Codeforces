package codeforce;
import java.util.*;
public class CodeForce
{
	static int n;
	static int[][] board;
	static int[][] two;
	static int[][] five;
	CodeForce()
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		board = new int[n][n];
		two = new int[n][n];
		five = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				board[i][j] = in.nextInt();
			}
		}
	}

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

    public static int return_minimum(int x, int y)
    {
    	if(x<y)
    		return x;
    	else
    		return y;
    }

	public static void board_display()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
	}

	public static void fill_factor_matrices(int row,int column)
	{
		if(row==0 && column==0)
		{
			two[row][column] = find_two(board[row][column]);
			five[row][column] = find_five(board[row][column]);

		}
		else if(row==0 && column!=0)
		{
			two[row][column] = two[row][column-1]+find_two(board[row][column]);
			five[row][column] = five[row][column-1]+find_five(board[row][column]);

		}
		else if(row!=0 && column==0)
		{
			two[row][column] = two[row-1][column]+find_two(board[row][column]);
			five[row][column] = five[row-1][column]+find_five(board[row][column]);

		}
		else
		{
			int two_up = two[row-1][column]+find_two(board[row][column]);
			int five_up = five[row-1][column]+find_five(board[row][column]);
			int  up = return_minimum(two_up,five_up);
			int two_left = two[row][column-1]+find_two(board[row][column]);
			int five_left = five[row][column-1]+find_five(board[row][column]);
			int left = return_minimum(two_left,five_left);
			if(up<left)
			{
				two[row][column] = two_up;
				five[row][column] = five_up;
			}
			else if(up>left)
			{
				two[row][column] = two_left;
				five[row][column] = five_left;
			}
			else if(up==left)
			{
				if(two_up<two_left)
				{
					two[row][column] = two_up;
				    five[row][column] = five_up;
				}
				else if(two_up>two_left)
				{
					two[row][column] = two_left;
				    five[row][column] = five_left;
				}
				else if(five_up<five_left)
				{
					two[row][column] = two_up;
				    five[row][column] = five_up;
				}
				else if(five_up>=five_left)
				{
                    two[row][column] = two_left;
				    five[row][column] = five_left;
				}
			}
		}
	}

	public static String direction_string()
	{
		int row = n-1;
		int column= n-1;
                int two_calc=0;
                int five_calc=0;
		String dir="";
		while(row!=0 || column!=0)
		{
			if(row==0 && column!=0)
			{
				dir = "R"+dir;
				column = column-1;
			}
			else if(row!=0 && column==0)
			{
				dir="D"+dir;
				row = row-1;
			}
			else
			{
				two_calc = two[row][column]-find_two(board[row][column]);
				five_calc = five[row][column]-find_five(board[row][column]);
				if(two_calc==two[row-1][column] && five_calc==five[row-1][column])
				{
					dir = "D"+dir;
					row = row-1;
				}
				else 
				{
					dir = "R"+dir;
					column = column-1;
				}
			}
		}
		return dir;
	} 

	public static int answer()
	{
		return return_minimum(five[n-1][n-1],two[n-1][n-1]);
	}

	public static void main(String args[])
	{
		CodeForce obj = new CodeForce();
		//obj.board_display();
                int row=0;
                int column=0;
		for(int i=0;i<=(n+n-2);i++)
		{
			if(i<n)
			{
				for(int j=0; j<=i;j++)
				{
					row = j;
					column = i-j;
					fill_factor_matrices(row,column);

				}
			}
			else
			{
				for(int j=(i-n+1);j<n;j++)
				{
					row = j;
					column = i-j;
					fill_factor_matrices(row,column);									
		        }
		    }
		}
         int answer = obj.answer();
		System.out.println(answer());
	    System.out.println(direction_string());
	}
}

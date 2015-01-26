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

    public static int return_minimum(int x, int y)
    {
    	if(x<y)
    		return x;
    	else
    		return y;
    }

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//initialize a nxn 2-d array
		int[][] board = new int[n][n];
		//for processing
		int[][] process_two = new int[n][n];
		int[][] process_five = new int[n][n];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				board[i][j] = in.nextInt();
			}
		}

		int row;
		int column;
		int min_two;
		int min_five;

		for(int i=0;i<=(n+n-2);i++)
		{
			if(i<n)
			{
				for(int j=0; j<=i;j++)
				{
					row = j;
					column = i-j;
					if( j==0 && i==0)
					{
						process_two[row][column] = find_two(board[row][column]);
						process_five[row][column] = find_five(board[row][column]); 
					}
					else
					{
						if((row-1)>=0 && (column-1)>=0)
						{
							if(return_minimum(process_two[row-1][column],process_five[row-1][column])>return_minimum(process_two[row][column-1],process_five[row][column-1]))
							{
								min_two = process_two[row][column-1];
								min_five = process_five[row][column-1];
								
							}
							else if(return_minimum(process_two[row-1][column],process_five[row-1][column])<return_minimum(process_two[row][column-1],process_five[row][column-1]))
							{
								min_two = process_two[row-1][column];
								min_five = process_five[row-1][column];
								
							}
							else
							{
								if(process_two[row-1][column]<process_two[row][column-1])
								{
									min_two = process_two[row-1][column];
									min_five = process_five[row-1][column];

								}
								else if(process_two[row-1][column]>process_two[row][column-1])
								{
									min_two = process_two[row][column-1];
									min_five = process_five[row][column-1];

								}
								else
								{
									if(board[row-1][column]<board[row][column-1])
									{
										min_two = process_two[row-1][column];
									    min_five = process_five[row-1][column];
									}
									else
									{
										min_two = process_two[row][column-1];
									    min_five = process_five[row][column-1];
									}
								}
							}
						}
						else if(row-1<0)
						{
							min_two = process_two[row][column-1];
							min_five = process_five[row][column-1];
						}
						else
						{
							min_two = process_two[row-1][column];
							min_five = process_five[row-1][column];
						}
						process_two[row][column] =  min_two+find_two(board[row][column]);
						process_five[row][column] =  min_five+find_five(board[row][column]);
					}
				}
			}
			else
			{
				for(int j=(i-n+1);j<n;j++)
				{
					row = j;
					column = i-j;

					if( j==0 && i==0)
					{
						process_two[row][column] = find_two(board[row][column]);
						process_five[row][column] = find_five(board[row][column]); 
					}
					else
					{
						if((row-1)>=0 && (column-1)>=0)
						{
							if(return_minimum(process_two[row-1][column],process_five[row-1][column])>return_minimum(process_two[row][column-1],process_five[row][column-1]))
							{
								min_two = process_two[row][column-1];
								min_five = process_five[row][column-1];
								
							}
							else if(return_minimum(process_two[row-1][column],process_five[row-1][column])<return_minimum(process_two[row][column-1],process_five[row][column-1]))
							{
								min_two = process_two[row-1][column];
								min_five = process_five[row-1][column];
								
							}
							else
							{
								if(process_two[row-1][column]<process_two[row][column-1])
								{
									min_two = process_two[row-1][column];
									min_five = process_five[row-1][column];

								}
								else if(process_two[row-1][column]>process_two[row][column-1])
								{
									min_two = process_two[row][column-1];
									min_five = process_five[row][column-1];

								}
								else
								{
									if(board[row-1][column]<board[row][column-1])
									{
										min_two = process_two[row-1][column];
									    min_five = process_five[row-1][column];
									}
									else
									{
										min_two = process_two[row][column-1];
									    min_five = process_five[row][column-1];
									}
								}
							}
						}
						else if(row-1<0)
						{
							min_two = process_two[row][column-1];
							min_five = process_five[row][column-1];
						}
						else
						{
							min_two = process_two[row-1][column];
							min_five = process_five[row-1][column];
						}
						process_two[row][column] =  min_two+find_two(board[row][column]);
						process_five[row][column] =  min_five+find_five(board[row][column]);
					}
				}
				
		    }
		}

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(process_two[i][j]+" ");
			}
			System.out.println("");
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(process_five[i][j]+" ");
			}
			System.out.println("");
		}

		
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

		//System.out.println(find_five(board[0][0]));

		
package codeforce;
import java.util.*;
public class CodeForce { 
  
    public static void main(String args[])
    {
     int n;
     Scanner in = new Scanner(System.in);
     n = in.nextInt();
     String s;
     String[] name = new String[n];
     String[] temp_name = new String[n];
     int count =0;
     int[] score = new int[n];
     in.nextLine();
     for(int i=0;i<n;i++)
     {
         
         s = in.nextLine() ;
         String[] splited = s.split("\\s+");
         name[i] = splited[0];
         score[i] = Integer.parseInt(splited[1]);
     }
     int c=0;
     int score_sum=0;
     int max = 0; 
    for(int i=0;i<n;i++)
    {
        c=0;
        for(int j=0;j<i;j++)
        {
            if(name[i].equals(name[j]))
            {
                c=1;
                //System.out.println(name[i]+"="+name[j]);
                break;
            }
        }
        if(c==0)
        {
            score_sum=0;
            for(int k=i;k<n;k++)
            {
                if(name[i].equals(name[k]))
                    score_sum = score_sum+score[k];

            }
            System.out.println("total of "+name[i]+" is- "+score_sum);
            if(score_sum>max)
            {
                max = score_sum;
                System.out.println(name[i]+" has max score");
                count=0;
                temp_name[count] = name[i];
                count++;
                for(int g=1;g<n;g++)
                {
                    temp_name[g] = null;
                }
                //clean reamaining array
            }
            else if(score_sum==max)
            {
                //append in array;
                temp_name[count] = name[i];
                count++;
                System.out.println(name[i]+" has max score");
            }
        }        
    }
    String null_string = null;
        for(int l=0;l<n;l++)
        {
            if(temp_name[l] != null)
                System.out.println("max holder--"+temp_name[l]);

        }

        int first = 0;
        int first_index=0;
        int temp_count =0;
        int temp_score = 0;
        while(temp_name[temp_count]!=null)
        {
            temp_score =0;
            for(int h=0;h<n;h++)
            {
                if(name[h].equals(temp_name[temp_count]))
                {
                    temp_score = temp_score+score[h];
                    if(temp_score>=max && first>h)
                    {
                        first = h;
                        first_index = temp_count;
                        break;
                    }

                }

            }
            temp_count++;
        }
      System.out.println("result: "+temp_name[first_index]);
    }    
}

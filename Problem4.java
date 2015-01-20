import java.util.*;
//import java.text.*;
public class CodeForce { 
  
    public static void main(String args[])
    {
     int n;
     Scanner in = new Scanner(System.in);
     n = in.nextInt();
     String s;
     String[] name = new String[n];
     int[] score = new int[n];
     in.nextLine();
     for(int i=0;i<n;i++)
     {
         
         s = in.nextLine() ;
         String[] splited = s.split("\\s+");
         name[i] = splited[0];
         score[i] = Integer.parseInt(splited[1]);
     }
     for(int i=0;i<n;i++)
     {
         System.out.println("--------"+name[i]+"--"+score[i]+"-------------");
     }
    
    }    
}
import java.util.Scanner;
public class Problem1 
{
    public static void main(String args[])
    {
        int m;
        int n;
        int a;
        Scanner in = new Scanner(System.in);
         m = in.nextInt();
         n = in.nextInt();
         a = in.nextInt();
         //System.out.println("the three numbers input are"+m+", "+n+", "+a);
         long ans=0;
         long l=0;
         long b=0;
         if(m%a==0)
             l = m/a;
         else
             l = m/a+1;
         
         if(n%a==0)
             b = (n/a);
         else
             b = (n/a)+1;
         ans = l*b;
         System.out.println(ans);
         
         
    }
    
}
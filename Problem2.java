import java.util.Scanner;

public class CodeForce { 
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String s ;
        int n;
        n = in.nextInt();
        s = in.nextLine();
        String[] collection = new String[n];
        for(int i=0;i<n;i++)
        {
          s = in.nextLine();
          collection[i] = s;
        }
        int p=0; 
        int offset;
        for(int j=0; j<n;j++)
        {
          p=0;
          offset=0;
          if(collection[j].charAt(0)=='R')
          {
            p=1;
            if((int)collection[j].charAt(1)<65 || (int)collection[j].charAt(1)>97)
            {
              p=1;
              for(int k=2;k<collection[j].length();k++)
              {
                if(collection[j].charAt(k)=='C')
                {
                  p=2;
                  offset=k;
                  break;
                }
              }
            }
            else
              p=0;
          }
          String r;
          if( p==0 || p==1)
             System.out.println(char_to_rc(collection[j]));
          if(p==2)
             System.out.println(rc_to_char(collection[j],offset));
        }
    }
    
    public static String char_to_rc(String s)
    {
        int wl=0;
        for(int i=0; i<s.length();i++)
        {
            if((int)s.charAt(i)<65 || (int)s.charAt(i)>97)
            {
               wl = i-1;
               break;
            }   
        }
        double col_no = 0.0;
        for(int i=0;i<=wl;i++)
        {
           int d = (int)s.charAt(i)-64;
           col_no = col_no+Math.pow(26,wl-i)*d;
        }
        Double g = new Double(col_no);
        int c = g.intValue();
        String column = String.valueOf(c);
        String row = s.substring(wl+1);
        String rown = row.trim();
        String converted = "R";
        converted = converted.concat(rown);
        converted = converted.concat("C");
        converted = converted.concat(column);
        return converted;      
    }
    
    public static String rc_to_char(String s, int offset)
    {
        String column = s.substring(offset+1);
        int col_no = Integer.parseInt(column);
        int next;
        String str="";
        String n="";
        while(col_no !=0)
        {
           next = 64+col_no%26;
           char a;
           if(next == 64)
           {
               a='Z';
               col_no = (col_no/26)-1; 
           }
           else
           {
               a = (char) next;
               col_no = col_no/26; 
           }
           n = String.valueOf(a);
           n = n.concat(str);
           str = n;
                    
        }
        String row = s.substring(1,offset);
        n = n.concat(row);
        return n;
   
    }
}

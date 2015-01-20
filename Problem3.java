//Minimum Area polygon
package codeforce;
import java.util.Scanner;
import java.text.*;
public class CodeForce { 
    public static void main(String args[])
    {
        double x1;
        double y1;
        double x2;
        double y2;
        double x3;
        double y3;
        
        Scanner in = new Scanner(System.in);
        x1 = in.nextDouble();
        y1 = in.nextDouble();
        x2 = in.nextDouble();
        y2 = in.nextDouble();
        x3 = in.nextDouble();
        y3 = in.nextDouble();
        
        DecimalFormat f = new DecimalFormat("##.000000");
        double c1 = (x1*x1)-(x3*x3)+(y1*y1)-(y3*y3);
        double c2 = (y1-y2);
        double c3 = (x1*x1)-(x2*x2)+(y1*y1)-(y2*y2);
        double c4 = y1-y3;
        double c5 = 2*(((x1-x3)*(y1-y2))-((x1-x2)*(y1-y3)));
        double c6 = x1-x2;
        double c7 = x1-x3;
        double x = (c1*c2 - c3*c4)/c5;
        double y = (c1*c6 - c3*c7)/(-1*c5);
        
        x = Math.floor(x * 1000000) / 1000000;
        y = Math.floor(y * 1000000) / 1000000;
        /*System.out.println("calculated value of x:"+x);
        System.out.println("calculated value of y:"+y);*/
        double diff_angle[] = new double[3];
        diff_angle[0] = (Math.toDegrees(Math.atan2(x-x1,y-y1)));
        diff_angle[1] = (Math.toDegrees(Math.atan2(x-x2,y-y2)));
        diff_angle[2] = (Math.toDegrees(Math.atan2(x-x3,y-y3)));
        
        for(int i=0;i<3;i++)
        {
          for(int j=i+1;j<3;j++)
          {
            if(diff_angle[j]>diff_angle[i])
            {
                double temp = diff_angle[i];
                diff_angle[i] = diff_angle[j];
                diff_angle[j] = temp;
            }
          }
        }
        /*
        System.out.println("angle1:"+diff_angle[0]);
        System.out.println("angle2:"+diff_angle[1]);
        System.out.println("angle3:"+diff_angle[2]);
        */
        double angle[] = new double[3];
        angle[0] = diff_angle[0]-diff_angle[1];
        angle[1] = diff_angle[1]-diff_angle[2];
        angle[2] = diff_angle[2]-diff_angle[0];
        
       
        for(int i=0; i<3;i++)
        {
            if(angle[i]<0)
            {
                angle[i] = 360-angle[i];
                //System.out.println("after subtraction::::"+angle[i]);
            }
            if(angle[i]>360)
            {
                double z = Math.ceil(angle[i]/360);
                double full = 360*z;
                angle[i] = full-angle[i];
                //System.out.println("after addition::::"+angle[i]);
            }
        }
     /*  
       System.out.println("angle1:"+angle[0]);
       System.out.println("angle2:"+angle[1]);
       System.out.println("angle3:"+angle[2]);
      */
        
        int c=0;
        double n=3;
        while(c==0)
        {
            
            double temp = 360/n;  
             if(n==78)
                 System.out.println(temp);
            for(int i=0;i<3;i++)
            {
               // if(n==78)
                //System.out.println("mods---"+(angle[i]%temp));
                if((angle[i]%temp)>=0 && (angle[i]%temp)<=0.01 )
                {
                  /*  if(n==78)
                    {
                        System.out.println((angle[i]%temp)+">=0");
                    }*/
                    c++;
                } 
               
                if((temp-(angle[i]%temp))>=0 && (temp-(angle[i]%temp))<=0.01)
                    c++;
                
            }
            /*if(n==78)
                 System.out.println("count:" +c);*/
                   
           if(c==3)
                break;
            n++;
            c=0;
            
        }
       // System.out.println("sides"+n);
        double rad_square = (x-x1)*(x-x1)+(y-y1)*(y-y1);
        //n=98;
        double area = (n*rad_square*Math.sin(Math.toRadians(360/n)))/2;       
        System.out.println(f.format(area));
    }    
}

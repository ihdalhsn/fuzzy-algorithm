/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

/**
 *
 * @author Husnayain
 */
public class procedure {
    public void STG(double x){
        double slow,mid,fast;
        if(x<=0.25){slow = x; System.out.println("slow : "+1);}
        if((0.5<=x)&&(x<=0.75)){mid = x; System.out.println("mid : "+1);}
        if(x>=1){fast = x; System.out.println("fast : "+1);}
        if((0.25<x)&&(x<0.5)){
            slow = -(x-0.5)/(0.5 - 0.25);
            mid = (x-0.25)/(0.5 - 0.25);
            System.out.println("slow : "+slow);
            System.out.println("mid : "+mid);
        }
        if((0.75<x)&&(x<1)){
            mid = -(x-1)/(1 - 0.75);
            fast = (x-0.75)/(1 - 0.75);
            System.out.println("mid : "+mid);
            System.out.println("fast : "+fast);
        }  
    }
    public void SCG(double x){
        double low,mid,high;
        if(x<=0.25){low = x; System.out.println("low : "+1);}
        if((0.5<=x)&&(x<=0.75)){mid = x; System.out.println("mid : "+1);}
        if(x>=1){high = x; System.out.println("high : "+1);}
        if((0.25<x)&&(x<0.5)){
            low = -(x-0.5)/(0.5 - 0.25);
            mid = (x-0.25)/(0.5 - 0.25);
            System.out.println("low : "+low);
            System.out.println("mid : "+mid);
        }
        if((0.75<x)&&(x<1)){
            mid = -(x-1)/(1 - 0.75);
            high= (x-0.75)/(1 - 0.75);
            System.out.println("mid : "+mid);
            System.out.println("high : "+high);
        }  
    }
    public void PEG(double x){
        double low,mid,high;
        if(x<=0.25){low = x; System.out.println("low : "+1);}
        if((0.5<=x)&&(x<=0.75)){mid = x; System.out.println("mid : "+1);}
        if(x>=1){high = x; System.out.println("high : "+1);}
        if((0.25<x)&&(x<0.5)){
            low = -(x-0.5)/(0.5 - 0.25);
            mid = (x-0.25)/(0.5 - 0.25);
            System.out.println("low : "+low);
            System.out.println("mid : "+mid);
        }
        if((0.75<x)&&(x<1)){
            mid = -(x-1)/(1.00 - 0.75);
            high = (x-0.75)/(1.00 - 0.75);
            System.out.println("mid : "+mid);
            System.out.println("high : "+high);
        }  
    }
}

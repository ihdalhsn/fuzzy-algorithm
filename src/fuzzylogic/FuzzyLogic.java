/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

import java.util.ArrayList;
/**
 *
 * @author Husnayain
 */
public class FuzzyLogic {
    //Crisp Input
    public ArrayList inputSTG(double x){
        Input stg = new Input();
        ArrayList stgList = new ArrayList();
        //whiteArea
        if(x<=0.25){stg.low = 1; stgList.add(stg.linguistik="short");}
        if((0.5<=x)&&(x<=0.75)){stg.mid = 1; stgList.add(stg.linguistik="mid");}
        if(x>=1){stg.high = 1; stgList.add(stg.linguistik="long");}
        //greyArea
        if((0.25<x)&&(x<0.5)){
            stg.low = -(x-0.5)/(0.5 - 0.25); stgList.add(stg.linguistik="short");
            stg.mid = (x-0.25)/(0.5 - 0.25); stgList.add(stg.linguistik="mid");   
        }
        if((0.75<x)&&(x<1)){
            stg.mid = -(x-1)/(1 - 0.75); stgList.add(stg.linguistik="mid");
            stg.high = (x-0.75)/(1 - 0.75); stgList.add(stg.linguistik="long");
        }  
        return stgList;    
    }
    
    public ArrayList inputSCG(double x){
        Input scg = new Input();
        ArrayList scgList = new ArrayList();
        //whiteArea
        if(x<=0.25){scg.low = 1; scgList.add(scg.linguistik="low");}
        if((0.5<=x)&&(x<=0.75)){scg.mid = 1; scgList.add(scg.linguistik="mid");}
        if(x>=1){scg.high = 1; scgList.add(scg.linguistik="high");}
        //greyArea
        if((0.25<x)&&(x<0.5)){
            scg.low = -(x-0.5)/(0.5 - 0.25); scgList.add(scg.linguistik="low");
            scg.mid = (x-0.25)/(0.5 - 0.25); scgList.add(scg.linguistik="mid");   
        }
        if((0.75<x)&&(x<1)){
            scg.mid = -(x-1)/(1 - 0.75); scgList.add(scg.linguistik="mid");
            scg.high = (x-0.75)/(1 - 0.75); scgList.add(scg.linguistik="high");
        }  
        return scgList;    
    }
    
    public ArrayList inputPEG(double x){
        Input peg = new Input();
        ArrayList pegList = new ArrayList();
        //whiteArea
        if(x<=0.25){peg.low = 1; pegList.add(peg.linguistik="low");}
        if((0.5<=x)&&(x<=0.75)){peg.mid = 1; pegList.add(peg.linguistik="mid");}
        if(x>=1){peg.high = 1; pegList.add(peg.linguistik="high");}
        //greyArea
        if((0.25<x)&&(x<0.5)){
            peg.low = -(x-0.5)/(0.5 - 0.25); pegList.add(peg.linguistik="low");
            peg.mid = (x-0.25)/(0.5 - 0.25); pegList.add(peg.linguistik="mid");   
        }
        if((0.75<x)&&(x<1)){
            peg.mid = -(x-1)/(1 - 0.75); pegList.add(peg.linguistik="mid");
            peg.high = (x-0.75)/(1 - 0.75); pegList.add(peg.linguistik="high");
        }  
        return pegList;    
    }
    
    public double minimasi(double a, double b, double c){
        double value;
        value = Math.min(a,Math.min(b, c));
        return value;
    }
    
    public double maksimasi(double a, double b, double c){
        double value;
        value = Math.max(a,Math.min(b, c));
        return value;
    }
    
    
    
    //masukan prosedur ini adalah keluaran dari crisp input setelah fuzzification
    //keluaran fuzzy input adalah sekumpulan baris input yang akan diseleksi outputnya pada tahap inference/fuzzyrules
    public void fuzzyInput (ArrayList stgList, ArrayList scgList, ArrayList pegList){
        //prosedur untuk mendefinisikan rule setiap baris input     
        //String[][] input = new String[3][9];
        for(int i=0; i< stgList.size(); i++){
            //System.out.println(stgList.get(i));
            for(int j=0; j< scgList.size(); j++){
                //System.out.println(scgList.get(j));
                for(int k=0; k<pegList.size(); k++){                    
                    System.out.println(stgList.get(i)+"|"+scgList.get(j)+"|"+pegList.get(k));
                    //input[i][j] = stgList.get(i);
                    
                }
            }
        }      
    }
    
    
    //prosedur hanya untuk satu baris input / bisa dilakukan perulangan di dalamnya (jika bisa)
    //masukan fungsi ini adalah keluaran dari prosedur fuzzyInput 
    public Output inference(Input stg, Input scg, Input peg){ 
        //baca dulu satu baris input
        //periksa (dalam rules) masuk ke dalam rule yang mana kah baris input tsb
        //setiap satu baris input telah mendapat rule nya, masukkan output dari rule tsb ke ArrayList Output
        Output out = new Output();
        //outValue ditentukan oleh minimasi input
        //outlingustik berdasarkan rule yang ada
        if((stg.linguistik=="short")&&(scg.linguistik=="low")&&(peg.linguistik=="low")){out.linguistik = "very_low"; out.setValue(minimasi(stg.low,scg.low,peg.low));}
        if((stg.linguistik=="short")&&(scg.linguistik=="low")&&(peg.linguistik=="mid")){out.linguistik = "low"; out.setValue(minimasi(stg.low,scg.low,peg.mid));}            
        if((stg.linguistik=="short")&&(scg.linguistik=="low")&&(peg.linguistik=="high")){out.linguistik = "high"; out.setValue(minimasi(stg.low,scg.low,peg.high));}
        if((stg.linguistik=="short")&&(scg.linguistik=="mid")&&(peg.linguistik=="low")){out.linguistik = "very_low"; out.setValue(minimasi(stg.low,scg.mid,peg.low));}          
        if((stg.linguistik=="short")&&(scg.linguistik=="mid")&&(peg.linguistik=="mid")){out.linguistik = "middle"; out.setValue(minimasi(stg.low,scg.mid,peg.mid));}                            
        if((stg.linguistik=="short")&&(scg.linguistik=="mid")&&(peg.linguistik=="high")){out.linguistik = "high"; out.setValue(minimasi(stg.low,scg.mid,peg.high));}                              
        if((stg.linguistik=="short")&&(scg.linguistik=="high")&&(peg.linguistik=="low")){out.linguistik = "middle"; out.setValue(minimasi(stg.low,scg.high,peg.low));}                             
        if((stg.linguistik=="short")&&(scg.linguistik=="high")&&(peg.linguistik=="mid")){out.linguistik = "middle"; out.setValue(minimasi(stg.low,scg.high,peg.mid));}                             
        if((stg.linguistik=="short")&&(scg.linguistik=="high")&&(peg.linguistik=="high")){out.linguistik = "high"; out.setValue(minimasi(stg.low,scg.high,peg.high));}                     
        
        if((stg.linguistik=="mid")&&(scg.linguistik=="low")&&(peg.linguistik=="low")){out.linguistik = "very_low";}
        if((stg.linguistik=="mid")&&(scg.linguistik=="low")&&(peg.linguistik=="mid")){out.linguistik = "middle";}                               
        if((stg.linguistik=="mid")&&(scg.linguistik=="low")&&(peg.linguistik=="high")){out.linguistik = "high";}                            
        if((stg.linguistik=="mid")&&(scg.linguistik=="mid")&&(peg.linguistik=="low")){out.linguistik = "low";}                               
        if((stg.linguistik=="mid")&&(scg.linguistik=="mid")&&(peg.linguistik=="mid")){out.linguistik = "middle";}                             
        if((stg.linguistik=="mid")&&(scg.linguistik=="mid")&&(peg.linguistik=="high")){out.linguistik = "high";}          
        if((stg.linguistik=="mid")&&(scg.linguistik=="high")&&(peg.linguistik=="low")){out.linguistik = "middle";}              
        if((stg.linguistik=="mid")&&(scg.linguistik=="high")&&(peg.linguistik=="mid")){out.linguistik = "high";}         
        if((stg.linguistik=="mid")&&(scg.linguistik=="high")&&(peg.linguistik=="high")){out.linguistik = "high";}         
        
        if((stg.linguistik=="long")&&(scg.linguistik=="low")&&(peg.linguistik=="low")){out.linguistik = "very_low";}           
        if((stg.linguistik=="long")&&(scg.linguistik=="low")&&(peg.linguistik=="mid")){out.linguistik = "middle";}            
        if((stg.linguistik=="long")&&(scg.linguistik=="low")&&(peg.linguistik=="high")){out.linguistik = "high";}        
        if((stg.linguistik=="long")&&(scg.linguistik=="mid")&&(peg.linguistik=="low")){out.linguistik = "middle";}          
        if((stg.linguistik=="long")&&(scg.linguistik=="mid")&&(peg.linguistik=="mid")){out.linguistik = "middle";}          
        if((stg.linguistik=="long")&&(scg.linguistik=="mid")&&(peg.linguistik=="high")){out.linguistik = "high";}          
        if((stg.linguistik=="long")&&(scg.linguistik=="high")&&(peg.linguistik=="low")){out.linguistik = "high";}          
        if((stg.linguistik=="long")&&(scg.linguistik=="high")&&(peg.linguistik=="mid")){out.linguistik = "high";}        
        if((stg.linguistik=="long")&&(scg.linguistik=="high")&&(peg.linguistik=="high")){out.linguistik = "high";}          
        
        return out;
    }
    
    //masukan prosedur ini adalah sekumpulan Output & rules yg terdefinisi pada inference
    //keluaran prosedur ini adalah semua linguistik output berserta valuenya yang terbesar (jika ada linguistik yang sama)
    public void disjunction (ArrayList Output){
         
        
    }
    
    //menggunakan model sugeno
    //outputnya adalah yang memiliki crisp output paling besar
    public void defuzzification (){
        
    }
     
    public static void main(String[] args) {
        FuzzyLogic f = new FuzzyLogic();
        
        double x = 0.33;
        double y = 0.87;
        double z = 0.28;
        System.out.println("========== STG =========");
        System.out.println(f.inputSTG(x));
        System.out.println("========== SCG =========");
        System.out.println(f.inputSCG(y));
        System.out.println("========== PEG =========");
        System.out.println(f.inputPEG(z));
        System.out.println("===== FUZZY INPUT ======");
        f.fuzzyInput(f.inputSTG(x), f.inputSCG(y),f.inputPEG(z));
   
    }//endOfMain
    
}

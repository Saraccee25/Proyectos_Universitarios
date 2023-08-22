
package Clases;

import javax.swing.JOptionPane;


public class PF2 {
    
//Atrbutos 

private int vcf2[];
private int du,n;

    public PF2(int tam) {
       n = tam;
       du = n-1;
       vcf2 = new int[n];
    }
    
 public int getVcF2(int pos) {
        return vcf2[pos];
    }

    public void setVcF2(int pos, int d) {
         vcf2[pos] = d;
    }

    public int getDu() {
        return du;
    }

    public void setDu(int du) {
        this.du = du;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
     public int[] getVcF2() {
        return vcf2;
    }

    public void setVcF2(int[] vcf2) {
         this.vcf2 = vcf2;
    }



public void Convertir(String[] vec){
    
    int contt = 0, valormayorf2 =  0, j = 1;
    
    for (int i = 0; i < vec.length; i+=2) {
        
        if(vec[i] != null){
            
        
        if (Integer.parseInt(vec[i])!=0) {
            contt++;
        }
            if(Integer.parseInt(vec[i]) > valormayorf2){
                valormayorf2 = Integer.parseInt(vec[i]);
             }
        }
        
     }//Cierre del para que busca el numero mayor y le numero de terminos 
    
    vcf2[0] = contt;
    
    for (int i = 0; i < vec.length; i+=2) {
        if (vec[i]!=null) {
           // if (Integer.parseInt(vec[i+1]) == valormayorf2) {
                vcf2[j+1] = Integer.parseInt(vec[i+1]);
                vcf2[j] = Integer.parseInt(vec[i]);
                j+=2;
                //contt--;
            //}
            /*
            else
            {
            vcf2[j] = 0;
            j++;
            valormayorf2--;
            i-=2;
            }
*/
        }
        
    }//Cierre del para que pone los numeros en el vector nuevo
    
                 for (int i = 0; i <= vec.length; i++) {
                 System.out.print("["+vcf2[i]+"]");
                 
             }
                 
           System.out.println("");
}

public void Reconstruir(){

    for (int i = 1; i < vcf2.length-1; i+=2) {
        
      if(vcf2[i] != 0 ){  
          
        if (vcf2[i+1]==0) {
            if (vcf2[i]<0) {
                
                System.out.print(vcf2[i]);
            }
            else
            {
                System.out.print("+"+vcf2[i]);
            }
        }
        else if(vcf2[i+1] ==1 ){
            
             if (vcf2[i]<0) {
                
                System.out.print(vcf2[i]+"x");
            }
            else
            {
                System.out.print("+"+vcf2[i]+"x");
            }
        }
        else if(vcf2[i+1]<0){
            System.out.print(vcf2[i]+"x"+"^"+vcf2[i+1]);
        }
        else{
            System.out.print("+"+vcf2[i]+"x"+"^"+vcf2[i+1]);
        }
     }
        
        
    }//Cierre del para
}

public void cambiox(){
    
      int num = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite un numero: ","Ingreso",-1));
      int suma=0,e;
      
    for (int i = 1; i < vcf2.length-1; i+=2) {
        e = (int) Math.round(Math.pow(num, vcf2[i+1]));
        suma+= vcf2[i]*e;
        
    }
    System.out.println("");
    System.out.println(suma);
}

}



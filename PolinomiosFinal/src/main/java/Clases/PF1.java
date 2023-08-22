package Clases;

import javax.swing.JOptionPane;


public class PF1 {
    
    static int vcf1[];
    static int du,n;
    static String vecTrans[];
    static int tam;

    public PF1(int tam) {
       n = tam;
       du = n-1;
       vcf1 = new int[n];
      
    }

    public int getVcF1(int pos) {
        return vcf1[pos];
    }

    public void setVcF1(int pos, int d) {
         vcf1[pos] = d;
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
    
     public int[] getVcF1() {
        return vcf1;
    }

    public void setVcF1(int[] vcf1) {
         this.vcf1 = vcf1;
    }
    
    public static void Ajustar(){
        int cont = 0, i=1;
        
        while(1<= du && vcf1[i]==0){
            cont++;
            i++;
            
        }
        while(i<=du){
            vcf1[i-cont]= vcf1[i];
                   i++;
        }
        vcf1[0] -= cont;
        du = vcf1[0]+1;
        
    }
    
    public static void Convertir(String vec[]){
    
        
    int valormayor = 0,j = 0,sw =1;
    
        for (int i = 1; i <= vec.length-1; i+=2) {
            
           if(vec[i] != null){
               
           
            if( Integer.parseInt(vec[i]) > valormayor){
                valormayor = Integer.parseInt(vec[i]);
            }
           }
            
        } //cierre del para que encuentra el grado
        
        vcf1[0] = valormayor;
        
       
        for (int i = 1; i<= vec.length-1;i++){

//	if(vec[i] != null){
		
		j = 0;
                sw = 0;
                while(vec[j] !=null && valormayor != Integer.parseInt(vec[j+1]) ){
                    

			//if(vec[j] == null){
                            
			//	vec[j]="0";
                            //    sw=1;
                          //  }
                        j+=2;
                        }
                
                if(vec[j] == null){
                    vcf1[i] = 0;
                    valormayor--;
                }
                else
                {
                      vcf1[i] = Integer.parseInt(vec[j]);
                         valormayor--;
                }
                
                if(valormayor<0){
                    i = vec.length+3;
                }
              
		//}

		
		
	}//cierre del para 

        
        /*
         for(int i = 0; i <= vec.length-1; i+=2){
             
             if(vec[i] != null){
                 if(Integer.parseInt(vec[i+1]) == valormayor){
                    vcf1[j] = Integer.parseInt(vec[i]);
                     j++;
                     valormayor--;
                }
                  else{
                 vcf1[j] = 0;
                 j++;
                 valormayor--;
                 i-=2;
                }
             }
            
             
           
         }//Cierre del para 
         
         */
             for (int i = 0; i <= vec.length; i++) {
                 
                 if(vcf1[i]==0 && vcf1[0]-(i-1) < 0){
                     i = vec.length +2;
                 }
                 else
                 {
                 System.out.print("["+vcf1[i]+"]");
                 
                 
                 }
             } //cierre del for que muestra los datos de la variable
             
            System.out.println("");
         }//Cierre de la clase  
    
    public void Reconstruir(){
        
        int exp ;
        
        for (int i = 1; i < vcf1.length-1; i++) {
            
            exp = vcf1[0]-(i-1);
            
          if(vcf1[i]!=0){
              
          
            if (exp == 0) {
                
                if(vcf1[i]<0){
                    System.out.print(vcf1[i]);
                }
                else
                {
                  System.out.print("+"+vcf1[i]);                
                }
              
                
            }
            else if(exp == 1){
                if(vcf1[i]<0){
                    System.out.print(vcf1[i]+"x");
                }
                else
                {
                    System.out.print("+"+vcf1[i]+"x");
                }
                
            }
            
            else if(vcf1[i] > 0){
                System.out.print("+"+vcf1[i]+"x"+"^"+exp);
            }

            else
            {
                System.out.print(+vcf1[i]+"x"+"^"+exp);
            }
          
            
        }
      } //cierre del condicional principal

    }//cierre de la clase 
    
    public void cambiox(){
        
       int num = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite un numero: ","Ingreso",-1));
       int pos,e,suma = 0;
        for (int i = 1; i < vcf1.length-1; i++) {
            
            pos = vcf1[0]-(i-1);
            
            e = (int) Math.round(Math.pow(num, pos));
            suma +=  (vcf1[i]*e);
           
            
        }
        System.out.println("");
        System.out.println(suma );
        
 
    } // cierre de la clase
    
    public void sumapol(){
    
        
        
      
      int vecSuma[] = null,i =1,j=1,k=1,posv1,posv2;
      int vec1[]; 
      vec1 = new int[vcf1.length];
      vec1 = vcf1; // aqui paso las variables de vcf1 a otra porque no sé que es lo que está pasando 
        PF1 vcf12 = new PF1(du);
        String polinomioSum = JOptionPane.showInputDialog(null, "Ingrese un nuevo polinomio:","Polinomio Nuevo",-1);
        vcf12.validaciones(polinomioSum);
        
        vcf12.Convertir(vcf12.vecTrans);
        
        if (vec1[0]>= vcf12.vcf1[0]){
            vecSuma = new int[vcf1.length];
            vecSuma[0] = vcf1[0];
        }
        else if(vcf12.vcf1[0] > vec1[0]){
            vecSuma = new int[vcf12.vcf1.length];
            vecSuma[0] = vcf12.vcf1[0];
            
        }
         
        while( i<=vec1[0]+1|| j<=vcf12.vcf1[0]+1){
            posv1 = vec1[0] - (i-1);
            posv2 = vcf12.vcf1[0] -(j-1);
            
            if (posv1 > posv2) {
                vecSuma[k] = vec1[i];
                i++;
                k++;
                             
            }
            else if(posv2 > posv1){
                vecSuma[k] = vcf12.vcf1[j];
                j++;
                k++;
                
            }
            else
            {
                vecSuma[k] = vec1[i] + vcf12.vcf1[j];
                j++;
                k++;
                i++;
            }
            
 //            System.out.println("");
            

        }//cierre del while 
        
                    for (int l = 0; l < vecSuma.length; l++) {
                
                System.out.print("["+vecSuma[l]+"]");
                
            } //cierre del para 
                    System.out.println("");
                    vcf1 = vec1;
        
    } //Cierre de la clase 
    
    public void multipol(){
        
        int vec1[],  expC,vecMul[] = null,i=1,j=1,posC;
        vec1 = new int[vcf1.length];
        vec1 = vcf1; // aqui paso las variables de vcf1 a otra porque no sé que es lo que está pasando 
        PF1 vcf12 = new PF1(du);
        String polinomioSum = JOptionPane.showInputDialog(null, "Ingrese un nuevo polinomio:","Polinomio Nuevo",-1);
        vcf12.validaciones(polinomioSum);
        vcf12.Convertir(vcf12.vecTrans);
        
        expC = (vec1[0])+(vcf12.vcf1[0]);
        
        vecMul = new int [vec1.length + vcf12.vcf1.length];
        
        vecMul[0] = expC;
        
        while(vec1[0]-(i-1)>=0){
            j=1;
            while(vcf12.vcf1[0]- (j-1) >=0){
                
                posC = (vec1[0] -(i-1)+(vcf12.vcf1[0]- (j-1)));
                vecMul[posC+2] += vec1[i] * vcf12.vcf1[j] ;
                j++;
            }
            i++;
        }
        
        
           for (int l = 0; l < vecMul.length; l++) {
                
             System.out.print("["+vecMul[l]+"]");
        
           }//Cierre del para
           
                    System.out.println("");
                    vcf1 = vec1;
           
        
    }//Cierre de la clase
    
    
        public static void validaciones(String pol){
     
      int j = 0; 
///    Scanner leer = new Scanner(System.in);
       String s = "";
      // String cadena = "2x+2";
      char vc[] = pol.toCharArray();
      tam = vc.length;
      String vecString[] = new String[tam]; //----------------> aqui se asigna el valor del tamaño del vector vc (vector cadena ) al vectorString para que tenga el mismo tamaño
      vecTrans = new String[tam];
       
     for (int i = 0; i < vc.length; i++) {
            vecTrans = vecString; //Aquí igualo el String global con el String local
            if(vc[i] == '+' ){
                
            }
            else {
                
                if(vc[i] == '-'){
                    s = "-";
                }
                else{
                    
                    if (i+1 == vc.length && Character.isDigit(vc[i]) && j % 2 == 0) {
                             s+= vc[i];
                        vecString[j] = s;
                        s="";
                        j++;
                        s="0";
                        vecString[j] = s;
                        s = "";
                        j++;
                      
                    }
                    else
                    {
                         if(i+1 == vc.length && Character.isDigit(vc[i]) && j % 2 == 1){
                               s+= vc[i];
                            vecString[j] = s;
                            s="";
                            j++;
                        
                         }
                         else 
                         {
                         
                         if((vc[i+1] == '+' || vc[i+1] == '-') && Character.isDigit(vc[i]) && j % 2 == 0){
                               s += vc[i];
                        vecString[j] = s;
                        s = "0";
                        vecString[j+1] = s;
                        s = "";
                        j+=2;
                        i++;
                         }
                    else
                    {
                        if((vc[i+1] == '+' || vc[i+1] == '-') && Character.isDigit(vc[i]) && j % 2 == 1){
                              s+= vc[i];
                                vecString[j] = s;
                                s = "";
                                j++;
                   
                        }
                        else{
                            if(Character.isDigit(vc[i]) && ( Character.isDigit(vc[i+1]))){
                              s+= vc[i];
                            }
                            else
                            {
                            
                            if(Character.isDigit(vc[i]) && vc[i+1] == 'x'){
                                s+= vc[i];    
                               /* vecString[j] = s;
                                s="";
                                j++;
*/
                            }
                            else{
                                if(vc[i] == 'x' && (vc[i+1] == '+' || vc[i+1] == '-' || Character.isDigit(vc[i+1]) || i+1 == vc.length) && Character.isDigit(vc[i-1])){
                                    vecString[j] = s;
                                    s = "1";
                                    vecString[j+1] = s;
                                    s = "";
                                    j+=2;
                                }
                                else
                                {
                                    
                                    if(vc[i] == 'x' && (vc[i+1] == '+' || vc[i+1] == '-' || Character.isDigit(vc[i+1]) || i+1 == vc.length) && (vc[i-1] == '+' || vc[i-1] == '-')){
                                        
                                     s += "1";   
                                     vecString[j] = s;
                                     s = "1";
                                    vecString[j+1] = s;
                                    s = "";
                                    j+=2;
                                 
                                    }
                                
                                
                                else{
                                    if(vc[i] == 'x' && vc[i+1] == '^'){
                                        vecString[j] = s;
                                        s = "";
                                        i++;
                                        j++;
                                        
                                    }
                                    }//Cierre del else de la x que tiene un numero en la posicion anterior
                                }// Cierre del else de la x que tiene el gorrito en la posicion siguiente
                                    
                            
                            } //Cierre del else del numero que tiene una x en la posicion siguiente
                          } //Cierre del else del numero que tiene un signo en la posicion siguiente (Exponente)  
                        }//Cierre del else del numero que tiene un signo en la posicion siguiente (Constante)
                    
                       }//Cierre del else del numero que está en el final pero es un ------ (Exponente)
                       }//Cierre del else del numero que está en el final pero es una ----- (Constante)
                    }//Cierre del else del numero que tiene un numero en la posicion siguiente  
                }// Cierre del else del signo de la resta
                
            }//Cierre del else del signo de la suma (inicial)
            }//Cierre del para 
     
       for (int i = 0; i < vecString.length; i++) {
            System.out.print("["+ vecString[i]+"]"); 
        }
           System.out.println("");
      
 }//Cierre de la clase 
    
    }


    
    

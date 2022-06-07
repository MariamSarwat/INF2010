package tp2;

import java.util.Random;
import java.util.ArrayList;

public class LinearSpacePerfectHashing<AnyType>
{
   static int p = 46337;
   
   int a, b, n, memorySize;
   QuadraticSpacePerfectHashing<AnyType>[] data;
   Random generator;
   
   LinearSpacePerfectHashing() {
      clear();
   }
   
   LinearSpacePerfectHashing(ArrayList<AnyType> array) {
      allocateMemory(array);
   }
	   
   public void setArray(ArrayList<AnyType> array) {
      allocateMemory(array);
   }
	   
   public int size() {
      return n;
   }

   public void clear() {
      generator = new Random(System.nanoTime());
      a = b = n = memorySize = 0; 
      data = null;
   }

   private int findPos(AnyType x){
	  //Transformer Anytype a int
	  int objet = x.hashCode(); 
	  int pos = (((a * objet) + b) % p) % n;
      
	  //Assurer que pos se retrouve entre 0 et n
      if (pos < 0) 
         pos += n;

      return pos;
   }

   public boolean contains(AnyType x){
	   if(n == 0) 
		   return false; 
	   
	   int index = findPos(x);
	   
	   //Verifie si l'element x en parametre est present dans la structure de donnees
	   return (data[index]!=null && data[index].contains(x));
   }

   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array) {
      clear();
      
      if(array == null || array.size() == 0) return;

      //Generation de a et b
      a = generator.nextInt(p);
      b = generator.nextInt(p);
      n = array.size();
      
      //Allocation de memoire pour data
      data = new QuadraticSpacePerfectHashing[n];
      
      //Creation d'un array temporaire
      ArrayList<AnyType>[] temp = new ArrayList[n];
      
      if (n == 1){
    	  data[0].setArray(array);
	      return;
	  }
      
      //Initialisation de notre array temporaire
      for(int i = 0; i < size(); i++) 
         temp[i]= new ArrayList<AnyType>();
      
      //Allouer le tableau temp en fonction de la position de array 
      for(int i = 0; i < size(); i++){
         int pos = findPos(array.get(i));
         temp[pos].add(array.get(i)); 
      }

      //Calculation de memorysize de data
      for(int i = 0; i < size(); i++){
         data[i] = new QuadraticSpacePerfectHashing<AnyType>(temp[i]);
         memorySize += data[i].memorySize();
      }
   }
   
   public int memorySize() {
	   return memorySize;
   }
   
   public String toString(){
	   if(n == 0) 
		   return "";
	   
	   StringBuilder sb = new StringBuilder();

	   //Convertir data en chaine 
       for(int i = 0; i < size(); i++) {
           if(data != null ) 
        	   sb.append(i + " -> " + data[i].toString() + "\n");
       }
       
       return sb.toString();
   }
}
package tp2;

import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType> {
   static int p = 46337;

   int a, b, m, n;
   AnyType[] items;
   Random generator;

   QuadraticSpacePerfectHashing() {
      clear();
   }

   QuadraticSpacePerfectHashing(ArrayList<AnyType> array) {
      allocateMemory(array);
   }

   public void setArray(ArrayList<AnyType> array) {
      allocateMemory(array);
   }

   public int size() {
      return n;
   }

   public void clear() {
      generator = new Random( System.nanoTime() );
      a = b = m = n = 0; 
      items = null;
   }

   private int findPos(AnyType x) {
	   //Pour transformer Anytype a int
	   int objet = x.hashCode(); 
	   int pos = ((((a*objet) + b) % p) % m);
	   
	   //Assurer que pos se retrouve entre 0 et m
	   if (pos < 0) 
		   pos += m;
	   return pos;
   }
   
   public boolean contains(AnyType x) {
      if(n == 0) 
    	  return false; 

      int index = findPos(x);

      return ((items[index] != null) && (items[index].equals(x)));
   }

   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array) {
      clear();

      if(array == null || array.size() == 0) return;

      n = array.size();
      m = n*n;

      if(n == 1) {
         items = (AnyType[]) new Object[m];
         items[0] = array.get(0);
         return;
      }

      while(unsuccessfulMemoryAllocation(array));
   }

   @SuppressWarnings("unchecked")
   private boolean unsuccessfulMemoryAllocation(ArrayList<AnyType> array) {
	  
	  a = generator.nextInt();
	  b = generator.nextInt();
      items = (AnyType[]) new Object[m];
      
      int pos = 0;
      
      for (int i = 0; i < array.size(); i++) {
    	  pos = findPos(array.get(i));
    	  
    	  //Verifie si une collision est presente
    	  if (items[pos] != null) { 
    		  items = (AnyType[]) new Object[m];
    		  return true;
    	  }
    	  else 
    		  //Insertion d'element
    		  items[pos] = array.get(i);
      }
      //La methode a reussi a inserer l'ensemble des elements (donc aucune collision)
      return false;
   }
   
   public int memorySize() {
      return m;
   }
   
   public String toString(){
      if(n == 0) 
         return "";
      
      StringBuilder sb = new StringBuilder();
      
      for(AnyType item : items) 
         if( item != null ) 
            sb.append(item + ", ");
      
      return sb.toString();
   }
}

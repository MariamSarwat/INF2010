
package tp4;
import java.util.*; 


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType>
{
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType [ ] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications;    // Nombre de modifications apportees a ce monceau
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( boolean min ){
		this.min = min;
		currentSize = 0;
		array = (AnyType[]) new Comparable[DEFAULT_CAPACITY + 1];
    }
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( AnyType[] items, boolean min) {
		this.min = min;
		this.currentSize = items.length;
		array = (AnyType[]) new Comparable[currentSize + 1];
		
		int i = 1;
		for (AnyType item : items)
			array[i++] = item;
		
		//invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min;
		if (min)
			buildMinHeap();
		else 
			buildMaxHeap();	
    }
    
    public boolean offer( AnyType x ){
		if (x == null)
		    throw new NullPointerException("Cannot insert null in a BinaryHeap");
		
		//On verifie la capcite
		if(currentSize + 1 == array.length )
		    doubleArray();
		
		int newElement = ++currentSize;
		
		//placer par rapport a un minHeap
		if (min) {
			for ( ;newElement > 1 && x.compareTo(array[newElement/2]) < 0; newElement /= 2)
				array[newElement] = array[newElement/2];
		}
		// sinon on va placer par rapport a un maxHeap
		else {
			for ( ;newElement > 1 && x.compareTo(array[newElement/2]) > 0; newElement /= 2)
				array[newElement] = array[newElement/2];
		}
		
		array[newElement] = x;
		modifications++;
		return true;
    }
    
    public AnyType peek(){
		if(!isEmpty())
		    return array[1];
		
		return null;
    }
    
    public AnyType poll(){
		AnyType racine = array[1]; //on commence toujours a l'index 1
		array[1] = array[currentSize--]; 
		
		if (min)
			percolateDownMinHeap(1, currentSize);
		else
			percolateDownMaxHeap(1, currentSize);
		
		modifications ++;
		return racine;
    }
    
    public Iterator<AnyType> iterator(){
    	return new HeapIterator();
    }
    
    private void buildMinHeap(){
    	for(int i = currentSize / 2; i > 0; i--) 
    		percolateDownMinHeap(i, array.length);
    }
    private void buildMaxHeap(){
    	for(int i = currentSize / 2; i > 0; i--) 
    		percolateDownMaxHeap(i, array.length);
    }
    
    public boolean isEmpty(){
    	return currentSize == 0;
    }
    
    public int size(){
    	return currentSize;
    }
    
    public void clear() {
		currentSize = 0;
		modifications = 0;
		array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    private static int leftChild( int i, boolean heapIndexing ){
    	return (heapIndexing ? 2*i : 2*i + 1);
    }
    
    private void swapReferences( int index1, int index2 ){
    	swapReferences(array, index1, index2);
    }
    
    private static <AnyType extends Comparable<? super AnyType>>
				    void swapReferences( AnyType[] array, int index1, int index2 ) {
		AnyType tmp = array[ index1 ];
		array[ index1 ] = array[ index2 ];
		array[ index2 ] = tmp;
	}
    
    @SuppressWarnings("unchecked")
	private void doubleArray(){
		AnyType [ ] newArray;
		
		newArray = (AnyType []) new Comparable[ array.length * 2 ];
		for( int i = 0; i < array.length; i++ )
		    newArray[ i ] = array[ i ];
		array = newArray;
    }
    
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMinHeap( int hole, int size ){
    	percolateDownMinHeap(array, hole, size, true);
    }
    
    /**
     * @param array   Tableau d'element
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap(AnyType[] array, int hole, int size, boolean heapIndexing){
    	int child;
		AnyType tmp;
		if(heapIndexing) {
			for(tmp = array[hole]; leftChild(hole, true) < size; hole = child) {
				child = leftChild(hole, true); //trouver l'enfant a gauche de l'index indiquer en parametre
				
				if( child != size - 1 && array[child].compareTo(array[child + 1]) > 0 )
					child++;
				//verifie si l'element actuel est plus grand que son enfant, si oui, on le remplace
				if(tmp.compareTo(array[child]) > 0)
					array[hole] = array[child]; 
				
				else
					break;
			}
			array[hole] = tmp;
		}
    }
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size ){
    	percolateDownMaxHeap(array, hole, size, true);
    }
    
    /**
     * @param array         Tableau d'element
     * @param hole          Position a percoler
     * @param size          Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>> 
				    void percolateDownMaxHeap(AnyType[] array, int hole, int size, boolean heapIndexing){	
    	int child;
		AnyType tmp;
		if(heapIndexing) {
			for(tmp = array[hole]; leftChild(hole, true) < size; hole = child ) {
				child = leftChild(hole, true);
				if( child !=  size - 1 && array[child].compareTo( array[child + 1] ) < 0 )
					child++;
				//verifie si l'element actuel est plus petit que son enfant, si oui, on le remplace
				if( tmp.compareTo( array[ child ] ) < 0 )
					array[ hole ] = array[ child ]; 
				else
					break;
			}
			array[hole] = tmp; 
		}
    }
    
    public static <AnyType extends Comparable<? super AnyType>> void heapSort( AnyType[] a ) {
    	for(int i = a.length/2 - 1; i >= 0; i--) /*buildHeap*/
    		percolateDownMaxHeap(a, i, a.length, true);
        
    	for( int i = a.length - 1; i > 0; i-- ){
            swapReferences(a, 0, i );
            percolateDownMaxHeap(a, 0, i, true );
        }
    }
    
    public static <AnyType extends Comparable<? super AnyType>> void heapSortReverse( AnyType[] a ){
    	for(int i = a.length/2 - 1; i >= 0 ; i--) /*buildHeap*/  
    		percolateDownMinHeap( a, i, a.length, true);
        
    	for( int i = a.length - 1; i > 0; i-- ){
            swapReferences( a, 0, i );
            percolateDownMinHeap( a, 0, i, true );
        }
    }
    
    public String nonRecursivePrintFancyTree() {
    	String outputString = "";
    	String _prefix = "";
    	int index = 1;
		Boolean onTheLeft = false;
		if(array[index] != null){ 
			while (index > 0) {
	            outputString += _prefix + "|__" + array[index] + "\n";
	            if (index == currentSize)
					outputString += _prefix + "|__" + "null\n";
	            
	            // trouver enfant gauchede l'index actuel
	            if (index * 2 <= currentSize) {
	                if (onTheLeft)
	                	_prefix += "|  ";
	                else 
	                	_prefix += "   ";
	                
	                onTheLeft = true;
	                index *= 2;
	            }
	            //Trouver le voisin de la derniere valeur imprimer
	            else if (index + 1 <= currentSize & onTheLeft) {
	                onTheLeft = false;
	                index++;
	            }
	            //Si l'enfant chauche n'existe pas et la derniere valeur == leaf
	            else {
	                //Trouver l'enfant gauche le plus proche
	                do {
	                    index = index /2;
	                    if(index > 0)
	                        _prefix = _prefix.substring(0, _prefix.length() - 3);
	                } while(index % 2 != 0 & index > 0);
	                
	                if(index > 0) 
	                    index +=1; //Trouver l'index du voisin de l'enfant
	                onTheLeft =  false;
	            }
	        }
			
		}
		else
		    outputString += "l'arbre est vide";

		return outputString;
    }
    
    public String printFancyTree() {
    	return printFancyTree(1, "");
    }
    
    private String printFancyTree( int index, String prefix) {
		String outputString = "";
		
		outputString = prefix + "|__";
		
		if(index <= currentSize){
			boolean isLeaf = index > currentSize/2;
			
			outputString += array[ index ] + "\n";
			
			String _prefix = prefix;
			
			if( index % 2 == 0 )
			    _prefix += "|  "; // un | et trois espace
			else
			    _prefix += "   " ; // quatre espaces
			
			if( !isLeaf ) {
			    outputString += printFancyTree( 2*index, _prefix);
			    outputString += printFancyTree( 2*index + 1, _prefix);
			}
		}
		else
		    outputString += "null\n";
		
		return outputString;
    }
    
    private class HeapIterator implements Iterator {
    	private int position = 1;
    	private int numberModification = modifications;
    	
		public boolean hasNext() {
			return (position < currentSize);
		}
	
		public Object next() throws NoSuchElementException, ConcurrentModificationException, UnsupportedOperationException {
			if(!hasNext())
				throw new NoSuchElementException();
			if(numberModification != modifications)
				throw new ConcurrentModificationException();
			else
				return array[position++];
		}
		
		public void remove() {
		    throw new UnsupportedOperationException();
		}
    }
}
package tp4;
import java.util.*; 


public class Main {
   /**
     * Fonction principale
     */
	public static void main(String[] args) {
		// creer un monceau avec 22 elements et un tableau equivalent
		int numItems = 22;
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);
		 
		Integer [] items = new Integer[numItems];
		
		int i, j;
		
		  // en inserant les elements un a un
		for(i = 11, j = 0; j != numItems; i = (i + 37), j++ ){
			heap.offer( i );
			items[ j ] = i;
			i %=  numItems; 
		}
		
		// en construisant le monceau depuis le depart
		System.out.println("Monceau min contruit element par element:");
		System.out.println( heap.printFancyTree() );
		
		heap = new BinaryHeap<Integer>(false);
		// en inserant les elements un a un
		for( Integer item : items)
		heap.offer( item );
		
		// en construisant le monceau depuis le depart
		System.out.println("Monceau max contruit element par element:");
		System.out.println( heap.printFancyTree() );
		
		heap = new BinaryHeap<Integer>(items,false);
		System.out.println("Monceau max contruit a partir d'un tableau:");
		System.out.println( heap.printFancyTree() );
		
		heap = new BinaryHeap<Integer>(items,true);
		System.out.println("Monceau min contruit a partir d'un tableau:");
		System.out.println( heap.printFancyTree() );
		
		System.out.println();
		System.out.println("Affichage recursif:");
		System.out.println( heap.printFancyTree() );
		
		System.out.println("Affichage non recursif:");
		System.out.println( heap.nonRecursivePrintFancyTree() );
		
		System.out.println();
		System.out.println("Tableau d'origine:");
		System.out.println( printArray( items ) );
		 
		BinaryHeap.heapSort( items );
		System.out.println("Tableau ordonne:");
		System.out.println( printArray( items ) );
		
		BinaryHeap.heapSortReverse( items );
		System.out.println("Tableau inversement ordonne:");
		System.out.println( printArray( items ) );
	
		
		/*
		 * Ajouter appels pour repondre a la question
		**/
		BinaryHeap<Integer> testMinHeap = new BinaryHeap<Integer>(items, true);
		BinaryHeap<Integer> testMaxHeap = new BinaryHeap<Integer>(items, false);
		
		System.out.println("\n---------- Start of tests ----------");
		testOffer(items, testMinHeap, testMaxHeap);
		testPoll(items, testMinHeap, testMaxHeap);
		testPollIt(items, testMinHeap);
		testItRemove(items, testMinHeap);
		
		testArray(items, testMinHeap);
		testNonRecursiveTree(testMinHeap);
	}

	private static void testOffer(Integer[] items, BinaryHeap<Integer> testMinHeap, BinaryHeap<Integer> testMaxHeap) {
		System.out.print("\nTest 1 : offer() => \n");
		System.out.print("\t Avec minHeap :  ");
		int insertMin = Integer.MIN_VALUE;
		testMinHeap.offer(insertMin); 
		int minPoll = testMinHeap.poll();
		System.out.println((minPoll == insertMin) ? "OK!" : "Erreur \n" );
		
		System.out.print("\t Avec maxHeap :  ");
		int insertMax = Integer.MAX_VALUE;
		testMaxHeap.offer(insertMax);
		int maxPoll = testMaxHeap.poll();
		System.out.println((maxPoll == insertMax) ? "OK!" : "Erreur \n" );
	};
	
	private static void testPoll(Integer[] items, BinaryHeap<Integer> testMinHeap, BinaryHeap<Integer> testMaxHeap) {
		System.out.print("\nTest 2 : poll() => \n");
		System.out.print("\t Avec minHeap :  ");
		
		int min = items[0];
		int max = -100;
		
		for (int tmp : items) {
			if (tmp < min)
				min = tmp;
			if (tmp > max)
				max = tmp;
		}
		
		int minPoll = testMinHeap.poll();
		System.out.println((minPoll == min) ? "OK!" : "Erreur \n" );
	
		System.out.print("\t Avec maxHeap :  ");
		int maxPoll = testMaxHeap.poll();
		System.out.println((maxPoll == max) ? "OK!" : "Erreur \n" );
	};
	
	private static void testPollIt(Integer[] items, BinaryHeap<Integer> testHeap ) {
		System.out.print("\nTest 3 : poll() avec iterateur => ");
		try {
			Iterator<Integer> it = testHeap.iterator();
			testHeap.poll();
			it.next();
			System.out.print("Erreur");
		}
		catch(Exception e) {System.out.print("OK! \n");}
	}

	private static void testItRemove(Integer[] items, BinaryHeap<Integer> testHeap ) {
		System.out.print("\nTest 4 : remove() avec iterateur => ");
		try {
			Iterator<Integer> it = testHeap.iterator();
			it.remove();
			System.out.print("Erreur");
		}
		catch(Exception e) {System.out.print("OK!\n");}
	};

	private static <AnyType> String printArray(AnyType[] a){
		String outputString = "";
		for(AnyType item : a) {
			outputString += item;
			outputString += ", ";
		}
		return outputString.substring(0,outputString.length()-2);
	}
	
	private static void testArray(Integer[] itemATrier, BinaryHeap<Integer> testHeap) {
		Integer [] reverseSort = new Integer[] {58, 57, 56, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 11};
		Integer [] sort = new Integer[] {11, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 56, 57, 58};
	
		System.out.print("\nTest 5 : heapSortReverse() avec minheap => ");
		testHeap.heapSortReverse(itemATrier);
		for(int i = 0; i < reverseSort.length; i++) {
			if(itemATrier[i] != reverseSort[i]) {
				System.out.println("Erreur");
				System.out.println("\tA l'index " + i + "on retrouve une valeur errone");
				return;
			}
		}
		System.out.println("OK!");
		
		System.out.print("\nTest 6 : heapSort() avec minHeap => ");
		testHeap.heapSort(itemATrier);
		for(int i = 0; i < reverseSort.length; i++) {
			if(itemATrier[i] != sort[i]) {
				System.out.println("Erreur");
				System.out.println("\tA l'index " + i + "on retrouve une valeur errone");
				return;
			}
		}
		System.out.println("OK!");
	};
	
	private static void testNonRecursiveTree(BinaryHeap<Integer> testHeap) {
		System.out.print("\nTest 7 : nonRecursivePrintFancyTree() avec minHeap  => ");
		boolean succes = true;
		
		String[]  reponse = new String[] {
				"|__11\n" + 
				"   |__38\n" + 
				"   |  |__39\n" + 
				"   |  |  |__50\n" + 
				"   |  |  |  |__56\n" + 
				"   |  |  |  |__53\n" + 
				"   |  |  |__43\n" + 
				"   |  |     |__46\n" + 
				"   |  |     |__48\n" + 
				"   |  |__40\n" + 
				"   |     |__47\n" + 
				"   |     |  |__54\n" + 
				"   |     |  |__58\n" + 
				"   |     |__49\n" + 
				"   |        |__51\n" + 
				"   |        |__null\n" + 
				"   |__37\n" + 
				"      |__41\n" + 
				"      |  |__44\n" + 
				"      |  |__42\n" + 
				"      |__45\n" + 
				"         |__52\n" + 
				"         |__57\n"};
	
		String [] outputString = new String[] {testHeap.nonRecursivePrintFancyTree()};

		for(int i = 1; i < outputString.length; i++) {
			if(outputString[i].compareTo(reponse[i]) != 0) 
				succes = false;
		}
		System.out.println((succes)? "OK!" : "Erreur");
	};
}
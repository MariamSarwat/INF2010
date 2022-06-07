package ITEMS;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class File<Item> implements Iterable<Item>{
	private Node<Item> first;
	private Node<Item> last;
	private static int nElements;
	
	 private static class Node<Item> {
		 public Node(Item item) {
			 this.item = item;
			 next = null;
		 }
	        private Item item;
	        private Node<Item> next;
	 }
	 
	//On initialise une file vide
	 public File() {
	        first = null;
	        last = first;
	        nElements = 0;
	 }
	
	//Fonction qui retourne le premier item qui est entree dans la file
	 public Item firstElement(){ 
	    return first.item;
	 }
	 
	//Fonction qui retourne le dernier item qui est entree dans la file
	 public Item lastElement(){ 
		 return last.item;
	 }
	 
	//Fonction qui retourne un boolean qui indique si le sac est vide ou non
	 public boolean estVide() {
		 return first==null;
	 }
	 
	 //Verifie si l'element passe en parametre est contenue dans la file
	 public boolean chercherElement(File <Item> file,Item x){
		 Node<Item> itr = file.first;
		 for(int i=0; i<File.size(); i++) {
			 if((itr.item).equals(x)) 
				 return true;
			 itr = itr.next;
		 }
		 return false;
	 }
	 
	//Fonction qui retourne le nombre d'elements dans la file
	 public static int size() {
		 return nElements;
	 }

	 //Fonction qui permet d'ajouter un item dans la file
	 public void enfile(Item item) {
		 if(estVide()) {
			 first = new Node<Item>(item);
			 last = first;
		 }else {
			 Node<Item> newNode = new Node<Item>(item);
			 last.next = newNode;
			 last = newNode;
		 }
		 nElements++;
	 }
	 
	 //Fonction qui permet de retirer un Item dans la file en respectant FIFO
	 public Item defile() {
	      if (first == null) {
	            throw new NoSuchElementException("rien a defiler");
	      }
	      Item oldItem = first.item;
	      first = first.next;
	      nElements--;
	      return oldItem;
	 }

	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}
	
	//Implementation de la class Iterator
	@SuppressWarnings("hiding")
	private class ListIterator<Item> implements Iterator<Item>{
		private Node<Item> courrant;
			
		public ListIterator(Node<Item> first) {
			courrant = first;
		}
			
		public boolean hasNext() {
			return courrant != null;
		}
			
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
			if(!hasNext())
				throw new NoSuchElementException();
			Item item = courrant.item;
			courrant = courrant.next;
			return item;
		}
	}
}
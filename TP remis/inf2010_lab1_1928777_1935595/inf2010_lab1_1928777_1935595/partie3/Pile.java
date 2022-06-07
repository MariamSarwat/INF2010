package ITEMS;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pile<Item> implements Iterable<Item>{
	private Node<Item> last;
	private static int nElements;
	
	 private static class Node<Item> {
		 public Node(Item item, Node<Item> next ) {
			 this.item = item;
			 this.next = next;
		 }
	        private Item item;
	        private Node<Item> next;
	 }
	 
	//On initialise une pile vide
	 public Pile() {
		 last = null;
		 nElements = 0;
	 }
	 
	//Fonction qui retourne le dernier item qui est entree dans la file
	 public Item lastElement(){
		    return last.item;
	 }
	 
	//Fonction qui retourne un boolean qui indique si le sac est vide ou non
	 public boolean estVide() {
		 return last==null;
	 }
	 
	//Verifie si l'element passe en parametre est contenue dans la pile
	 public boolean chercherElement(Pile <Item> pile,Item x){
		 Node<Item> itr = pile.last;
		 for(int i=Pile.size(); i>0; i--) {
			 if((itr.item).equals(x)) 
				 return true;
			 itr = itr.next;
		 }
		 return false;
	 }
	 
	//Fonction qui retourne le nombre d'elements dans la pile
	 public static int size() {
		 return nElements;
	 }
	 
	 //Fonction qui permet d'ajouter un item dans la pile
	 public void enpile(Item item) {
		 last = new Node<Item>(item, last);  //On empile toujours sur le dernier element
		 nElements++;
	 }
	 
	 //Fonction qui permet de retirer un Item dans la pile en respectant LIFO
	 public Item depile() {
	      if (last == null) {
	            throw new NoSuchElementException("rien a depiler");
	      }
	      Item oldItem = last.item;
	      last = last.next;
	      nElements--;
	      return oldItem;
	 }

	public Iterator<Item> iterator() {
		return new ListIterator<Item>(last);
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
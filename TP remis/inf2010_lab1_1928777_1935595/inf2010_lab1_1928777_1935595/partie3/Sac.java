package ITEMS;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Sac<Item> implements Iterable<Item>{
	private Node<Item> first; //debut du sac
	private static int nElements;
	
	private static class Node<Item> {
	        private Item item;
	        private Node<Item> next;
	 }

	//On initialise un sac vide
	public Sac(){
		first = null;
		nElements = 0;
	}
	 
	//Fonction qui retourne le premier item
	public Item firstElement(){
		return first.item;
	}

	//fonction qui retourne un boolean qui indique si le sac est vide ou non
	public boolean estVide() {
		return first == null;
	}
	 
	//Fonction qui verifie si l'element passe en parametre est contenue dans la liste chainee
	public boolean chercherElement(Sac <Item> list,Item x){
		Node<Item> itr = list.first;
		for(int i=0; i<Sac.size(); i++) {
			if((itr.item).equals(x)) 
				return true;
			itr = itr.next;
		}
		return false;
	}
	
	//Fonction qui retourne le nombre d'elements dans le sac
	public static int size() {
		 return nElements;
	}

	//Fonction qui permet d'ajouter un item dans le sac 
	public void add(Item item) {
		Node<Item> ancienFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = ancienFirst;
		nElements++;
	}

	public Iterator<Item> iterator() {
		return new ListIterator<Item> (first);
	}
	
	//Implementation de la classe Iterator
	@SuppressWarnings("hiding")
	private class ListIterator<Item> implements Iterator<Item>{
		private Node<Item> courrant;
		
		public ListIterator(Node<Item> first) {
			courrant = first;
		}
		
		public boolean hasNext() {
			return courrant != null;
		}
		
		//Un iterateur ne peut pas supprimer un item
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

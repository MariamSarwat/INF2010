package tp3;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<? super T> > {

    private BinaryNode<T> root;

    public BinarySearchTree() { }

    //initialisation
    public BinarySearchTree(T item) {
    	root = new BinaryNode<T>(item);
    }

    //on insere un nouvel item a partir de la racine O(log(n))
    public void insert(T item) {
    	root.insert(item);
    }

    //est-ce qu'un item fais partie de l'arbre O(log(n))
    public boolean contains(T item) {
    	//S'il n'existe pas de racine, la fonction retourne faux.
    	if(root == null)
            return false;
    	
    	//Sinon, on fait une appelle recursive de contains
    	return root.contains(item); 					
    }

    //trouver la hauteur de l'arbre O(n)
    public int getHeight() {
        return root.getHeight(); 
    }

    //placer dans une liste les items de l'arbre en ordre O(n)
    public List<BinaryNode<T>> getItemsInOrder() {
    	//S'il n'existe pas de racine, la fonction retourne null.
    	if(root == null)
            return null;
        
    	//Sinon, elle utilise la fonction fillListInOrder()
    	List<BinaryNode<T>> list = new ArrayList<BinaryNode<T>>();
        root.fillListInOrder(list);
        return list;
    }

    //retourner la liste d'item en String selon le bon format O(n)
    public String toStringInOrder() {
    	//Initialsation d'une list qui contient les items places en ordre
    	List<BinaryNode<T>> list = getItemsInOrder();
    	StringBuilder format = new StringBuilder("[");
    	
    	//Parcours de la list pour ajouter les items a la chaine de sortie.
    	for(int i=0 ; i < list.size(); i++) {
    		format.append(list.get(i).getData());
    	
    		//pour ne pas ajouter une virgule apres la derniere donnee
    		if(i != list.size()-1)
    			format.append(", ");
    	}
    	return format.append("]").toString();
    }
}
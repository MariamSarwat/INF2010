package tp3;
import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    //initialisation O(1)
    public BinaryNode(T data) {
    	this.data = data;
    	right = null;
    	left = null;
    }

    //on retourne la donnee voulue O(1)
    public T getData() {
        return data;
    }

    //on ajoute une nouvelle donnee au bon endroit O(log(n))
    public void insert(T item) {
    	if(data!=null) {
    		int compare = item.compareTo(data);
    		
    		//item devient fils gauche car inferieure ou egale(doublon) a la valeur du noeud courant
    		if (compare <= 0) {
	    		if (left == null) 		
	    			//Item inserer comme nouvelle BinaryNode si la position courante est une feuille
	    			left = new BinaryNode<T>(item);
	    		else
	    			//Item inserer a la position courante
	    			left.insert(item); 
	    	} 
    		//Item devient fils droit
    		else {
	    		if(right == null) 
	    			right = new BinaryNode<T>(item);
	    		else
	    			right.insert(item);
	    	}
    	} else
    		data = item;
    }
    
    //est-ce que l'item fais partie du noeuds courant O(log(n))
    public boolean contains(T item) {
    	//Verification que l'abre n'est pas vide
    	if(data != null) {
	    	int compare = item.compareTo(data);
	   
	    	if(compare < 0) {
	    		if(left != null)
	    			return left.contains(item);
	    	} 
	    	else if (compare > 0) {
	    		if(right != null)
	    			return right.contains(item);
	    	}
	    	else if(compare == 0) //l'item est le data
	    		return true;
	    }
    	return false;
    }
    
    //on retourne la maximale de l'arbre en utilisant une traverse postorder O(n)
    public int getHeight() {
    	//Initialisation des variables
    	int left_height = -1;
    	int right_height = -1;
    	
	    if(left != null)
	    	left_height = left.getHeight();
	    
	    if(right != null)
	    	right_height = right.getHeight();
	    
	    //Le maximum entre left_height et right_height sera retrouve et 1 
	    //sera rajoute pour la racine. La somme sera retourne
	    return (1 + Math.max(left_height, right_height));   	
    }
    
    //ordre d'insertion ajoutant les elements 
    //en ordre logique, donc gauche, centre et puis droite. O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) { 
    	//fillListInOrder() sera appele en premier sur left, si presence de fils gauche.
    	if(left != null)
    		left.fillListInOrder(result); 
    	
    	//Le noeud courant est ajoute a la list pris en parametre.
	    result.add(this); 

    	//fillListInOrder() sera appele en premier sur right si le noeud possede un fils droit.
	    if(right != null)
	    	right.fillListInOrder(result);
    }
}

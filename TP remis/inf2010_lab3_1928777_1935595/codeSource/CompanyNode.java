package tp3;
import java.util.List;

public class CompanyNode implements Comparable<CompanyNode> {
    private Integer money;
    private BinarySearchTree<CompanyNode> childs;
    public CompanyNode worstChild;

    //initialisation O(1)
    public CompanyNode(Integer data) {
    	money = data;
    	childs = null;
    	worstChild = this;
    }

    //la compagnie courante achete une autre compagnie O(log(n))
    public void buy(CompanyNode item) {
    	//Mise-a-jour de la valeur de la compagnie courante
    	this.money += item.getMoney();
    	
    	//Si la compagnie courant possede pas d'enfants, un nouveau BinarySearchTree est cree avec item
    	if(childs == null)
    		childs = new BinarySearchTree<CompanyNode>(item);
    	
    	//Sinon, la fonction insert() sera utilise en prenant item en parametre
    	else
    		childs.insert(item);
    	
    	//worstChild sera mis-a-jour si la valeur du worstChild de la company pris
    	//en parametre est plus petite que celui de la compagnie courante.
    	if(worstChild.money > item.worstChild.money)
    		this.worstChild = item.worstChild;
    }

    //on retourne le montant en banque de la compagnie O(1)
    public Integer getMoney() {
        return money;
    }

    //on rempli le builder de la compagnie et de ses enfants avec le format
    //A
    // > A1
    // > A2
    // >  > A21...
    // les enfants sont afficher du plus grand au plus petit (voir TestCompany.testPrint) O(n)
    public void fillStringBuilderInOrder(StringBuilder builder, String prefix) {
    	builder.append(prefix);
    	builder.append(money);
    	builder.append("\n");
    	
    	//Si la compagnie courante possede des enfants, la fonction fillStringBuilderInOrder 
    	//sera appele sur une liste qui contient les enfants trier en ordre
    	if(childs != null){
	    	List<BinaryNode<CompanyNode>> list = childs.getItemsInOrder();
	    	for(int i = list.size() - 1; i >= 0; i--) 
	    		list.get(i).getData().fillStringBuilderInOrder(builder, prefix + " > ");
    	}	
    }

    //on override le comparateur pour defenir l'ordre
    @Override
    public int compareTo(CompanyNode item) {
        return (this.money - item.money);
    }
}
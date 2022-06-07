package tp3;

public class CompanyTree {

    private CompanyNode root;

    public CompanyTree() {}

    //initialisation
    public CompanyTree(CompanyNode item) {
    	root = item;
    }

    //une compagnie mere achete une autre compagnie O(n)
    public void buy(CompanyNode item) {
    	root.buy(item);
    }

    //on retourne le montant en banque de la compagnie mere O(1)
    public Integer getMoney() {
        return root.getMoney();
    }

    //si on avait a laisser tomber un enfant, ca serait lui
    // Ceci est le pire de tous les enfants et les sous-enfants O(1)
    public Integer getWorstChildMoney() {
        return root.worstChild.getMoney();
    }

    //on retourne en string un presentation en ordre inverse
    // de la compagnie mere et de ses enfants O(1)
    public String getTreeInOrder() {
    	StringBuilder format = new StringBuilder();
    
    	root.fillStringBuilderInOrder(format, ""); //pour remplir la chaine en ordre
    	
        return format.toString();
    }
}

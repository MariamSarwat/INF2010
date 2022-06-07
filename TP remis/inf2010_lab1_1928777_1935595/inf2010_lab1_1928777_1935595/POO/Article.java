package POO;

public class Article {	
	private final String NumProduit; 
	private String nom;
	private double Prix_net;


    public Article(String NumProduit, String nom){
    	this.NumProduit=NumProduit;
    	this.nom=nom;
    	this.Prix_net=0; //mettre le prix a 0 par defaut
	}
	
	public Article(String np, String nom, double prix){		
		this.NumProduit=np;
		this.nom=nom;
		this.Prix_net=prix;
	}

	public String getNumProduit() {
		return NumProduit;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public double getPrixNet() {
		return Prix_net;
	}
	
	public void setPrixNet(double prix_net) {
		this.Prix_net=prix_net;	
	}
	
	public double getVAT(){
		return 0.15;	//valeur de VAT
	}
	
	public double getPrix(int count){
		double tax=getVAT()*(((double)count)*this.getPrixNet());
		
		return tax+((double)count)*this.getPrixNet(); //le prix total avec les taxes	
	}
	
	public String getArticleType(){
		return this.getClass().getName();
	}
	
	public String toString() {
		return 	"Nom: "+ this.getNom() + ", NumProduit: " + this.getNumProduit() + ", PrixNet: " + this.getPrixNet();
	}
}

package POO;

public class CadreDiplome extends Article {
	private String categorie;
	private String couleur;
	
    public CadreDiplome(String NumProduit, String nom, double prix, String couleur,String categorie){
        super(NumProduit,nom,prix);
        this.couleur = couleur;
        this.categorie = categorie;
    }

    public CadreDiplome(String NumProduit, String nom, double prix,String categorie){
        super(NumProduit,nom,prix);
        this.categorie = categorie;
    }

    @Override
    public String getArticleType() {
    	return this.getClass().getName();
    }

    public String getCategorie() {
        return categorie;
    }
    
    //Getter ajouter pour eviter des warnings
    public String getCouleur() {
        return couleur;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
	
    //Setter ajouter pour eviter des warnings
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}

package POO;

public class Livre extends Article {
	private String format;   // pdf, epub ou papier
	public Livre(String NumProduit, String nom, String format){
		super(NumProduit, nom); //on fait appel au constructeur de la classe article
		this.format=format;
	}
	
	public Livre(String NumProduit, String nom, double prix, String format){
		super(NumProduit,nom,prix); //on fait appel au constructeur de la classe article
		this.format=format;
	}
	
	@Override
	public String getArticleType() {
		return this.getClass().getName();
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format=format;
	}
	
}

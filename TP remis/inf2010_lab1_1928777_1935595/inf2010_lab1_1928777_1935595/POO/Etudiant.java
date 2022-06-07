package POO;

public class Etudiant {
	final int N = 10;
	private String Matr;
	private String nom;
	private String prenom;	
	private String email; 
	private int section; 
	
	private int n_des_notes;
	private NoteCours [] notes;
	
	public Etudiant(String Matr,String name, int section) {
        this.Matr = Matr;
		this.nom = name;
		this.section = section;
		notes = new NoteCours [N];
	}
	
	public Etudiant(String name, int section) {
		this.nom = name;
		this.section = section;
		notes = new NoteCours [N];
	}
	
	public void AjouterNote(String sigle, String titre, int note){ 
		NoteCours nouvelleNote = new NoteCours();
			nouvelleNote.sigle = sigle;
			nouvelleNote.titre = titre;
			nouvelleNote.note = note;
			notes[n_des_notes] = nouvelleNote;
			n_des_notes ++;	
	}
	
	public double NoteMoyenne(){
		double somme = 0.0;
		
		if (n_des_notes == 0) 
			return 0;
		
		for (int i = 0; i <  n_des_notes ; i++)
			somme += notes[i].note;
		
		return somme/n_des_notes;
	}

	public String getMatr() {
		return Matr;
	}

	public void setMatr(String matr) {
		this.Matr = matr;
	}

    public String getEmail() {
        return email;
	}

	public void setEmail(String matr) {
    	this.email = matr;
	}

	public String getNom() {
		return nom;
	}
    
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getSection() {
		return section;
	}
	
    public String toString() {
        return 	"Matricule: " +this.Matr + ", Nom: " + this.nom + ", Prenom: " + this.prenom + ", Email: " + this.email + ", Section: " + this.section;
    }
    
    public boolean equals(Object etudiant_x) {    
		if (etudiant_x == this) // meme case de reference, donc meme object
			return true;

		/*Si l'objet est null ou on compare a un autre objet d'une classe differente,
		 *l'objet passe en parametre n'est pas egal  
		 */
		if (etudiant_x == null || etudiant_x.getClass()!= this.getClass())
			return false;

		Etudiant etudiant=(Etudiant) etudiant_x; //casting

		//On verifie si chaque element est pareil pour affirmer que les deux objets sont egaux
		if( (this.getMatr() == etudiant.getMatr()) && (this.getNom() == etudiant.getNom()) && (this.getPrenom() == etudiant.getPrenom()) && (this.getEmail() == etudiant.getEmail()) && (this.getSection() == etudiant.getSection())) 
			return true;

		return false;
    }

}

package ADT;

import java.util.Random;

public class Compteur implements Comparable<Compteur> {

    private final String nom;        // nom du compteur
    private int compteur = 0;        // initialisation la valeur courant est 0

    
    public Compteur(String id) {
    	this.nom = id;
    } 

    public void increment() {
    	this.compteur++;
    } 

    public int score() {
    	return compteur;
    } 

    public String toString() {
    	return "Nom: "+ this.nom + ", Score:" + this.score();
    } 

    public int compareTo(Compteur x) {
    	return this.score() - x.score();
    }
    
    private static Random random=new Random(10000);
    
    //Retourne un nombre entier aléatoire uniformément dans [0,n[
	public static int uniform(int n) {
		return random.nextInt(n);
	 }

    public static void main(String[] args) { 
        int n = 6;
        int essais = 60000;

        // Creation n compteurs
        Compteur [] compteurs = new Compteur[n];
        for (int i = 0; i < n; i++) {
            compteurs[i] = new Compteur(i + "");
        }

        // incrémente les compteurs d'essais au hasard
        for (int t = 0; t < essais; t++) {
            compteurs[uniform(n)].increment();
        }

        // Affichage des resultat
        for (int i = 0; i < n; i++) {
            System.out.println(compteurs[i]);
        }
        
    }
} 

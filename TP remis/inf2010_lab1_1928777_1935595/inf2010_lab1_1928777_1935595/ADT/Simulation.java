package ADT;

import java.util.Random;

public class Simulation {
	 private static Random random = new Random();  

	 //Retourne un nombre réel aléatoire uniformément dans [0,1[
	 public static double uniform() {
		return random.nextDouble();
	 }

	 //Retourne un nombre entier aléatoire uniformément dans [0,n[
	 public static int uniform(int n) {
		return random.nextInt(n);
	 }

	//Retourne un entier long aléatoire uniformément dans [0, n[.
    // Vous pouviez trouver le code https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#longs-long-long-long-
    public static long uniform(long n) {
        if (n <= 0L) 
			throw new IllegalArgumentException("Argument doit etre positive: " + n);

        long r = random.nextLong();
        long m = n - 1;

        if ((n & m) == 0L)
            return r & m;

        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L)
            u = random.nextLong() >>> 1;
        
		return r;
    }
    
    //Retourne avec succès un booléen true si p suit d'une distribution de Bernoulli
    public static boolean bernoulli(double p) {
		if (p < 0.0 || p > 1.0)
           throw new IllegalArgumentException("Probability must be between 0.0 and 1.0");
        return (uniform() > p);
    }
    
    public static Compteur max(Compteur x, Compteur y) {
		if (x.score() > y.score())
			return x;
		else 
			return y;
    }
	
	public static void main(String[] args) {
		int n = 10;
		Compteur pile = new Compteur("pile");
		Compteur face = new Compteur("face");

		//Les instructions de la simulation
		for (int i = 0; i < n; i++) {
			if (bernoulli(0.5)) //probabilite de 0.5 d'obtenir pile
				pile.increment();
			else
				face.increment();
	    }
		//Afficher la différence entre les score des compteur
		System.out.println("Difference entre les scores: " + Math.abs(face.score() - pile.score()));
	        
		Compteur pile_c = new Compteur("pile");
		Compteur face_c = new Compteur("face");
		        
	    //Les instructions du simulation
		for (int i = 0; i < n; i++) {
			if (bernoulli(0.5)) { //probabilite de 0.5 d'obtenir pile
				pile_c.increment();
	        }
			else
				face_c.increment();
	    }
        //afficher le maximum entre les score des compteur
		System.out.println("Maximum entre les scores: " + max(pile_c, face_c).score());
	}
}

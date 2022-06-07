package POO;

import java.util.Arrays;
import java.util.Comparator;

public class Trieuse {
   
    public static final Comparator<Etudiant> Par_nom    = new NomOrdre();
    public static final Comparator<Etudiant> Par_section = new SectionOrdre();

    private static class NomOrdre implements Comparator<Etudiant> {
        public int compare(Etudiant x, Etudiant y) {
        	return x.getNom().compareTo(y.getNom());
        }
    }

    private static class SectionOrdre implements Comparator<Etudiant> {
        public int compare(Etudiant x, Etudiant y) {
        	return x.getSection() - y.getSection();
        }
    }
          
    //Fonction pour trier par nom
    public static void ParNom(Etudiant[] arr) {
    	Arrays.sort(arr , Par_nom);
    }
    
  //Fonction pour trier par section
    public static void ParSection(Etudiant[] arr) {
    	Arrays.sort(arr , Par_section);
    }

    public static void main(String[] args) {
    
        Etudiant e = new Etudiant("1897453","John",3);
	
        e.AjouterNote("INF2010", "Structures de données et algorithmes", 4);		
        e.AjouterNote("LOG2810", "Structures discrètes", 5);
        e.AjouterNote("INF2610", "Noyau d'un système d'exploitation", 3);
        System.out.println(e.NoteMoyenne());

        Etudiant john = new Etudiant("John", 2);
        Etudiant Caroline = new Etudiant("Caroline", 1);
        Etudiant Antoine = new Etudiant("Antoine", 2);
        Etudiant Karl = new Etudiant("Karl", 1);
        Etudiant Ahmed = new Etudiant("Ahmed", 2);
        Etudiant Sam = new Etudiant("Sam", 3);
       
        Etudiant[] etudiants = {
            john, Caroline, Karl, Ahmed, Sam, Antoine
        };

        ParNom(etudiants);
        System.out.println("Par le nom ");
        System.out.println("----------");
        for(int i=0;i<etudiants.length;i++) {
        	System.out.println(etudiants[i].toString());
        }
        System.out.println("----------");
        


        ParSection(etudiants);
        System.out.println("Par section");
        System.out.println("----------");
        for(int i=0;i<etudiants.length;i++) {
        	System.out.println(etudiants[i].toString());
        }
        System.out.println("----------");

       
        Etudiant carlos = new Etudiant("carlos",3);
        Etudiant Ines = new Etudiant("Ines",2);


        System.out.println("carlos == Ines:        " + (carlos == Ines));
        System.out.println("carlos.equals(Ines):   " + (carlos.equals(Ines)));  

    }

}


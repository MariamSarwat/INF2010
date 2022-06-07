package ITEMS;

import java.util.Iterator;

public class Main{
	public static void main(String[] args) {
		System.out.println("\n-->TESTS POUR SAC.JAVA<--");
		Sac <String> list = new Sac <String>();
		list.add("m");
		list.add("a");
		list.add("i");
		list.add("r");
		list.add("a");
		list.add("m");
		System.out.println("La taille du sac est: " + Sac.size());
		System.out.println("Premier element est: " + list.firstElement());
		System.out.println("Le sac contient a? " + (list.chercherElement(list, "a")));
		System.out.println("Le sac est vide? " + list.estVide());
		Iterator<String> itr = list.iterator();
		System.out.print("Le sac contient: ");
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		System.out.println("\n-->TESTS POUR FILE.JAVA<--");
		File<Integer> file = new File<Integer>();
		System.out.println("La file est vide?" + file.estVide());
		file.enfile(23);
		file.enfile(2);
		file.enfile(-8);
		file.enfile(35);
		System.out.println("On defile 23? " + (file.defile()==23));
		System.out.println("La file contient 2? " + (file.chercherElement(file, 2)));
		System.out.println("On defile 2? " + (file.defile()==2));
		System.out.println("La file contient 2? " + (file.chercherElement(file, 2)));
		System.out.println("On defile -8? " + (file.defile()==-8));
		if(!file.estVide()) {
			System.out.println("Taille: " + File.size());
			System.out.println("Premier element: " + file.firstElement());
		}else {
			System.out.println("Le file est vide!");
		}
			
		System.out.println("\n-->TESTS POUR PILE.JAVA<--");
		Pile<Integer> pile = new Pile<Integer>();
		System.out.println("La pile est vide?  " + pile.estVide());
		pile.enpile(23);
		pile.enpile(2);
		pile.enpile(-8);
		System.out.println("On depile -8? " + (pile.depile()==-8));
		System.out.println("La file contient 2? " + (pile.chercherElement(pile, 2)));
		System.out.println("On depile 2? " + (pile.depile()==2));
		System.out.println("La file contient 2? " + (pile.chercherElement(pile, 2)));
		System.out.println("On defile 23? " + (pile.depile()==23));
		if(!pile.estVide()) {
			System.out.println("Taille: " + Pile.size());
			System.out.println("Dernier element: " + pile.lastElement());
		}else {
			System.out.println("La Pile est vide!");
		}
	}
}
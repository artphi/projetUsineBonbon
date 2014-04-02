package projetUsineBonbon;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import projetUsineBonbon.Matrice;

/**
 * Exercice sur les r��seaux de P��tri.
 * HEIG-VD 2014 : Prof. Ethan Zysman
 *
 * Travail demand��:
 * Cr��er et remplir manuellement les matrices (2) et vecteurs de marquage (2)
 *
 * Scheduler sous forme d���analyseur d�����tat des transition
 * v��rifier pour le marquage courant, quelles sont les transitions sensibilis��es)
 * g��rer une liste de transition sensibilis��es
 *
 * Cr��er un g��n��rateur de nombres al��atoires
 * Si les transitions sont nomm��es de 1 �� 10, l�����v��nement attendu doit valoir de 1 �� 10
 *
 * Le scheduler v��rifie si l�����v��nement al��atoire correspond �� l���une des transitions sensibilis��es
 *
 * Cr��er le moteur de calcul qui re��oit en param��tre le num��ro de la transition �� franchir
 *
 *
 * @author FRANCILLON Olivier
 * @author PIGUET Aude
 * @author SANTOS Rapha��l
 * @version 1.0
 */

public class StartUsine {

	static //						T1 T2 T3 T4 T5 T6 T7 T8 T9
	long[][] matPre = { 	/*P1*/ { 0, 0, 0, 0,50, 0, 0, 0, 0},
							/*P2*/ { 0, 1, 0, 0, 0, 0, 0, 0, 0},
							/*P3*/ { 0, 0, 0, 0,50, 0, 0, 0, 0},
							/*P4*/ { 0, 0, 0, 1, 0, 0, 0, 0, 0},
							/*P5*/ { 0, 0, 0, 0, 0,50, 0, 0, 0},
							/*P6*/ { 0, 0, 0, 0, 0, 0,10, 0, 0},
							/*P7*/ { 0, 0, 0, 0, 0, 0, 0,10, 0},
							/*P8*/ { 0, 0, 0, 0, 0, 0, 0, 0, 1},
							/*P9*/ { 0, 0, 0, 0, 0, 0, 0, 1, 0},
	};
	static //        				T1 T2 T3 T4 T5 T6 T7 T8 T9
	long[][] matPost = { 	/*P1*/ { 0,50, 0, 0, 0, 0, 0, 0, 0},
							/*P2*/ { 1, 0, 0, 0, 0, 0, 0, 0, 0},
							/*P3*/ { 0, 0, 0,50, 0, 0, 0, 0, 0},
							/*P4*/ { 0, 0, 1, 0, 0, 0, 0, 0, 0},
							/*P5*/ { 0, 0, 0, 0,50, 0, 0, 0, 0},
							/*P6*/ { 0, 0, 0, 0, 0, 1, 0, 0, 0},
							/*P7*/ { 0, 0, 0, 0, 0, 0, 1, 0, 0},
							/*P8*/ { 0, 0, 0, 0, 0, 0, 0, 1, 0},
							/*P9*/ { 0, 0, 0, 0, 0, 0, 0, 0, 1},
	};

	static long[][] marquagePrecedent = {{0,0,0,0,0,0,0,0,1}};
	static long[][] marquageActuel = {{0,0,0,0,0,0,0,0,0}};

	public static void main(String[] args) {
		// TODO Auto-generated method stub




		Matrice pre = new Matrice(matPre);
		Matrice post = new Matrice(matPost);
		Matrice m0 = new Matrice(marquagePrecedent);
		Matrice mc = new Matrice(marquageActuel);
		startActivity();
	}

	public static void startActivity(){

		boolean running = true;
		List<Fabrication> fabrications = new LinkedList<Fabrication>();
		List<Thread> threads = new LinkedList<Thread>();

		while (running){
			// Pour chaque col
			for (int i = 0; i < matPre.length; i++) {
				// Check Sensi
				boolean sensi = true;
				for (int j = 0; j < matPre.length; j++) {
					if (marquageActuel[0][j] < matPre[j][i]) {
						sensi = false;
						break;
					}
				} 
				if (sensi) {
					System.out.println("Col " + i + " sensi");
					// Nouveau thread > calcul (passer la colonne)
					// Nouveau marquage (soustraction consommation)
					Fabrication fab = new Fabrication(i, matPre, marquageActuel);
					Thread thread = new Thread(fab);
					fab.run();
					threads.add(thread);
					fabrications.add(fab);
					marquagePrecedent = marquageActuel;
					for (int j = 0; j < marquageActuel.length; j++) {
						marquageActuel[0][j] = marquagePrecedent[0][j] - matPre[j][i];
					}
					System.out.println(marquageActuel);
				}
			}
			// Check retour tread ?
			for (int i = 0; i < threads.size(); i++) {
				if (threads.get(i).getState() == Thread.State.TERMINATED) {
					Fabrication fab = fabrications.get(i);
					// Nouveau marquage (addition production)
					marquagePrecedent = marquageActuel;
					for (int j = 0; j < marquageActuel[0].length; j++) {
						marquageActuel[0][j] = marquagePrecedent[0][j] + matPost[j][fab.getColonne()];
					}
					threads.remove(i);
					fabrications.remove(i);
				}
			}
		}

	}

}

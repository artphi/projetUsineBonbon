package projetUsineBonbon;
import projetUsineBonbon.Matrice;

/** 
 * Exercice sur les réseaux de Pétri.
 * HEIG-VD 2014 : Prof. Ethan Zysman
 * 
 * Travail demandé:
 * Créer et remplir manuellement les matrices (2) et vecteurs de marquage (2)
 *
 * Scheduler sous forme d’analyseur d’état des transition
 * vérifier pour le marquage courant, quelles sont les transitions sensibilisées)
 * gérer une liste de transition sensibilisées
 *
 * Créer un générateur de nombres aléatoires
 * Si les transitions sont nommées de 1 à 10, l’évènement attendu doit valoir de 1 à 10
 * 
 * Le scheduler vérifie si l’évènement aléatoire correspond à l’une des transitions sensibilisées
 * 
 * Créer le moteur de calcul qui reçoit en paramètre le numéro de la transition à franchir
 * 
 * 
 * @author FRANCILLON Olivier
 * @author PIGUET Aude
 * @author SANTOS Raphaël
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
		
	}

}

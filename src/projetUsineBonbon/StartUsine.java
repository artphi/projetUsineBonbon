package projetUsineBonbon;
import projetUsineBonbon.Matrice;
public class StartUsine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//						        T1 T2 T3 T4 T5 T6 T7 T8 T9
		long[][] matPre = { 	/*P1*/ { 1, 0, 0, 0, 1, 0, 0, 0, 0}, 
								/*P2*/ { 0, 1, 0, 0, 0, 0, 0, 0, 0},
								/*P3*/ { 0, 0, 1, 0, 1, 0, 0, 0, 0},
								/*P4*/ { 0, 0, 0, 1, 0, 0, 0, 0, 0},
								/*P5*/ { 0, 0, 0, 0, 0, 1, 0, 0, 0},
								/*P6*/ { 0, 0, 0, 0, 0, 0, 1, 0, 0},
								/*P7*/ { 0, 0, 0, 0, 0, 0, 0, 1, 0},
								/*P8*/ { 0, 0, 0, 0, 0, 0, 0, 0, 1},
								/*P9*/ { 0, 0, 0, 0, 0, 0, 0, 1, 0},
		};
		//        						T1 T2 T3 T4 T5 T6 T7 T8 T9
		long[][] matPost = { 	/*P1*/ { 0, 1, 0, 0, 0, 0, 0, 0, 0}, 
								/*P2*/ { 1, 0, 0, 0, 0, 0, 0, 0, 0},
								/*P3*/ { 0, 0, 0, 1, 0, 0, 0, 0, 0},
								/*P4*/ { 0, 0, 1, 0, 0, 0, 0, 0, 0},
								/*P5*/ { 0, 0, 0, 0, 1, 0, 0, 0, 0},
								/*P6*/ { 0, 0, 0, 0, 0, 1, 0, 0, 0},
								/*P7*/ { 0, 0, 0, 0, 0, 0, 1, 0, 0},
								/*P8*/ { 0, 0, 0, 0, 0, 0, 0, 1, 0},
								/*P9*/ { 0, 0, 0, 0, 0, 0, 0, 0, 1},
		};
		
		long[][] marquagePrecedent = {{0,0,0,0,0,0,0,0,0}};
		long[][] marquageActuel = {{0,0,0,0,0,0,0,0,0}};
		
		
		
		Matrice pre = new Matrice(matPre);
		Matrice post = new Matrice(matPost);
		Matrice marqPre = new Matrice(marquagePrecedent);
		Matrice marqAct = new Matrice(marquageActuel);
		
	}

}

package UsineBobons;

public class DataUsine {
	static //						T1 T2 T3 T4 T5 T6 T7 T8 T9
	int[][] matPre = {		/*P1*/ { 0, 0, 0, 0,50, 0, 0, 0, 0},
							/*P2*/ { 0, 1, 0, 0, 0, 0, 0, 0, 0},
							/*P3*/ { 0, 0, 0, 0,50, 0, 0, 0, 0},
							/*P4*/ { 0, 0, 0, 1, 0, 0, 0, 0, 0},
							/*P5*/ { 0, 0, 0, 0, 0,50, 0, 0, 0},
							/*P6*/ { 0, 0, 0, 0, 0, 0,10, 0, 0},
							/*P7*/ { 0, 0, 0, 0, 0, 0, 0,10, 0},
							/*P8*/ { 0, 0, 0, 0, 0, 0, 0, 0, 1},
							/*P9*/ { 0, 0, 0, 0, 0, 0, 0, 1, 0},
	};
	static //        					T1 T2 T3 T4 T5 T6 T7 T8 T9
	int[][] matPost = { 		/*P1*/ { 0,50, 0, 0, 0, 0, 0, 0, 0},
							    /*P2*/ { 1, 0, 0, 0, 0, 0, 0, 0, 0},
							    /*P3*/ { 0, 0, 0,50, 0, 0, 0, 0, 0},
							    /*P4*/ { 0, 0, 1, 0, 0, 0, 0, 0, 0},
							    /*P5*/ { 0, 0, 0, 0,50, 0, 0, 0, 0},
							    /*P6*/ { 0, 0, 0, 0, 0, 1, 0, 0, 0},
							    /*P7*/ { 0, 0, 0, 0, 0, 0, 1, 0, 0},
							    /*P8*/ { 0, 0, 0, 0, 0, 0, 0, 1, 0},
							    /*P9*/ { 0, 0, 0, 0, 0, 0, 0, 0, 1},
	};

	static int[] marquagePrecedent = {0,0,0,0,0,0,0,0,1};
	static int[] marquageActuel = {0,0,0,0,0,0,0,0,0};
	static int[] etatActivite={0,0,0,0,0,0,0,0,0};
	static int[] transSensibilisee={0,0,0,0,0,0,0,0,0};
	
	

	synchronized public static int getTransSensibilisee(int i) {
		return transSensibilisee[i];
	}

	synchronized public static void setTransSensibilisee() {
		
		for (int c=0; c<9; c++){
			int sensibilisation = 1;
			for (int l=0; l<9; l++){
				if (marquageActuel[l] < matPre[l][c]){
					sensibilisation = 0;
				}
			}
			transSensibilisee[c]= sensibilisation;
		}
		
				
	}

 synchronized public static void setActivite(int i, int etat){
	 etatActivite[i] = etat;
 }
 
 synchronized public static int getActivite(int i){
	 return etatActivite[i];
 }
	
	synchronized public static  void nouveauMarquage(int i){
		
		for (int j=0; j<9; j++){
			marquageActuel[j]=marquagePrecedent[j] - matPre[j][i] + matPost[j][i];
			System.out.print(marquageActuel[j] + " ");
		}
		System.out.println("");
		marquagePrecedent = marquageActuel;
		
	}
	
	
}

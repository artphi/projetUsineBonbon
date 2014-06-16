package UsineBobons;

public class DataUsine {
	static //						T01 T02 T03 T04 T05 T06 T07 T08 T09 T10 T11 T12
	int[][] matPre = {		/*P1*/ {  0,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
							/*P2*/ {  0,  0,  0,  0, 50,  0,  0,  0,  0,  0,  0,  0},
							/*P3*/ {  0,  0,  0,  1,  0,  0,  0,  0,  0,  0,  0,  0},
							/*P4*/ {  0,  0,  0,  0, 50,  0,  0,  0,  0,  0,  0,  0},
							/*P5*/ {  0,  0,  0,  0,  0, 50,  0,  0,  0,  0,  0,  0},
							/*P6*/ {  0,  0,  0,  0,  0,  0, 10,  0,  0,  0,  0,  0},
							/*P7*/ {  0,  0,  0,  0,  0,  0,  0, 10,  0,  0,  0,  0},
							/*P8*/ {  0,  0,  0,  0,  0,  0,  0,  0,  1,  0,  0,  0},
							/*P9*/ {  0,  0,  0,  0,  0,  0,  0,  1,  0,  0,  1,  0},
							/*P10*/{  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  0},
							/*P11*/{  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1},
	};
	static //        					T01 T02 T03 T04 T05 T06 T07 T08 T09 T10 T11 T12
	int[][] matPost = { 		/*P1*/ {  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
							    /*P2*/ {  0, 50,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
							    /*P3*/ {  0,  0,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0},
							    /*P4*/ {  0,  0,  0, 50,  0,  0,  0,  0,  0,  0,  0,  0},
							    /*P5*/ {  0,  0,  0,  0, 50,  0,  0,  0,  0,  0,  0,  0},
							    /*P6*/ {  0,  0,  0,  0,  0,  1,  0,  0,  0,  0,  0,  0},
							    /*P7*/ {  0,  0,  0,  0,  0,  0,  1,  0,  0,  0,  0,  0},
							    /*P8*/ {  0,  0,  0,  0,  0,  0,  0,  1,  0,  0,  0,  0},
							    /*P9*/ {  0,  0,  0,  0,  0,  0,  0,  0,  1,  0,  0,  1},
							    /*P10*/{  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  0,  0},
								/*P11*/{  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  0},
	};

	static int[] marquagePrecedent = {0,0,0,0,0,0,0,0,1,0,0};
	static int[] marquageActuel = {0,0,0,0,0,0,0,0,0,0,0};
	static int[] preMarquage = {0,0,0,0,0,0,0,0,0,0,0};
	static int[] etatActivite={0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] transSensibilisee={0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] vecteurMax={10,200,10,200,200,50,20,1,1,20,1,1};
	static int[] threadMax={5,5,5,5,5,5,5,5,1,1,1,1};
	static int nbT = 12;
	static int nbP = 11;
	static int nbDeThreadsLance = 0;
	static int nbDeBonbonsProduits = 0;
	static int nbdeTransactionsEffectuee = 0;
	
	
	
	
	

	synchronized public static int getVecteurMax(int i) {
		return vecteurMax[i];
	}


	synchronized public static int getTransSensibilisee(int i) {
		return transSensibilisee[i];
	}

	synchronized public static void setTransSensibilisee() {
		
		for (int c=0; c<nbT; c++){
			int sensibilisation = 1;
			for (int l=0; l<nbP; l++){
				if (marquageActuel[l] < matPre[l][c] ){
					
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
		
		
		for (int j=0; j<nbP; j++){
			preMarquage[j]=marquagePrecedent[j] - matPre[j][i] + matPost[j][i];	
			if (preMarquage[j]> vecteurMax[j] ){
				preMarquage[j] = marquagePrecedent[j];
			}else{
				marquageActuel[j]=marquagePrecedent[j] - matPre[j][i] + matPost[j][i];
				System.out.print(marquageActuel[j] + " ");
				nbdeTransactionsEffectuee++;
			}
			
		}
		System.out.println("");
		marquagePrecedent = marquageActuel;
		
	}
	
	
}

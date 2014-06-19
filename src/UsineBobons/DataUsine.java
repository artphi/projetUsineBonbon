package UsineBobons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DataUsine {
	//Matrice de pré-incidence
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
							/*P10*/{  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  2,  0},
							/*P11*/{  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1},
	};
	//Matrice de post-incidence
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
	
	static int[] nbJetonsDispo = {0,0,0,0,0,0,0,0,0,0,0};
	static int[] transSensibilisee={0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] postSensibilisee={0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] vecteurMax=    {100,200,100,200,200,50,20,1,1,20,1};
	
	static int[] threadsLance= {0,0,0,0,0,0,0,0,0,0,0,0};
	static int[] threadMax=   {20,20,20,20,20,20,20,20,1,20,1,1};
	//static int[] threadMax=     {1,1,1,1,1,1,1,1,1,1,1,1};
	
	//Gestion des priorités
		static HashMap<Integer, List<Integer>> priorites = new HashMap<Integer, List<Integer>>();
		static
		{
			//	Index=Transition Liste=Noeuds prioritaires sur cette transition
			priorites.put(10,Arrays.asList(7));
		}
	
	static int nbT = 12; //Nombre de transitions
	static int nbP = 11; //Nombre de Noeuds
	
	//Variables utilisées pour les logs
	static int nbDeThreadsLance = 0;
	static int nbDeBonbonsProduits = 0;
	static int nbdeTransactionsEffectuee = 0;
	static int nbDePrioritesAccordees = 0;
	static int nbDePaquetsALivrer = 3;
	static int nbDePaquetsLivre = 0;
	static int nbDeLettresLivree = 0;
	static int nbMatPremSucreProduit = 0;
	static int nbMatPremColorantProduit = 0;
	static int nbSucreProduit = 0;
	static int nbColorantProduit = 0;
	
	

	synchronized public static int getVecteurMax(int i) {
		return vecteurMax[i];
	}

	synchronized public static List<Integer> getPrioritaire(Integer i) {
		
		return priorites.get(i);
		
	}
	synchronized public static int getTransSensibilisee(int i) {
		return transSensibilisee[i];
	}
	

	synchronized public static void setTransSensibilisee() {
		
		for (int c=0; c<nbT; c++){
			int sensibilisation = 1;
			int postSensi = 0;

			for (int l=0; l<nbP; l++){
				nbJetonsDispo[l] = marquageActuel[l] - (matPre[l][c] * DataUsine.threadsLance[l]);
				if (marquageActuel[l] < matPre[l][c] ){
					sensibilisation = 0;
					//postSensi = 0;
			
				}else if (DataUsine.nbJetonsDispo[l] >= matPre[l][c]){
					postSensi = 1;
				}
			}
			
			

			
			transSensibilisee[c]= sensibilisation;
			postSensibilisee[c]= postSensi;
		}
		
		
		
		
		if(!DataUsine.priorites.isEmpty()){
		for(int c=0; c<nbT; c++){
			if(DataUsine.priorites.get(c) != null){
				for (Integer i : DataUsine.priorites.get(c)){
					//Si le marquage actuel du noeud prioritaire mêne à une sensibilisation, alors on passe
					//la sensibilisation du noeud courant à 0
					if (transSensibilisee[i] == 1){
						transSensibilisee[c] = 0;
						postSensibilisee[c] = 0;
						nbDePrioritesAccordees++;
					}
				}
			}
		}
	}
		
				
	}

	
	synchronized public static  void nouveauMarquage(int i){
		
		
		for (int j=0; j<nbP; j++){
			preMarquage[j]=marquagePrecedent[j] - matPre[j][i] + matPost[j][i];	
			if (preMarquage[j] > vecteurMax[j]){
				marquageActuel[j] = marquagePrecedent[j];
				System.out.print(marquageActuel[j] + " ");
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

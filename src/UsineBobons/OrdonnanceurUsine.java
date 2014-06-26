package UsineBobons;



public class OrdonnanceurUsine extends Thread{

	InterfaceUsine interfaceU;
	MoteurUsine moteur;
	int etatCourant;
	
	public OrdonnanceurUsine(InterfaceUsine interfaceU, MoteurUsine moteur){
		this.interfaceU = interfaceU;
		this.moteur = moteur;
	}
	
	
	public void run(){
		long time = System.currentTimeMillis(); 
		while(interfaceU.fabriquerBonbons()){
			//Vérification des transactions sensibilisées
			checkSensibilisations();
			
			//Lancement des activités en attentes
			lancerActivite();
			
			effectuerTransitions();
			
		}
		try {
			Thread.sleep( 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		time = System.currentTimeMillis() - time;
		System.out.println("Production terminée");
		System.out.println("");
		System.out.println("##############");
		System.out.println("#   RESUME   #");
		System.out.println("##############");
		System.out.println();
		System.out.println("****** Statistiques ******");
		System.out.println("Nombre de matière première de sucre récoltées: " + DataUsine.nbMatPremSucreProduit);
		System.out.println("Nombre de matière première de colorant récoltées: " + DataUsine.nbMatPremColorantProduit);
		System.out.println("Nombre de sucre produits: " + DataUsine.nbSucreProduit);
		System.out.println("Nombre de colorant produits: " + DataUsine.nbColorantProduit);
		System.out.println("Nombre de bonbons produits: " + DataUsine.nbDeBonbonsProduits);
		System.out.println("Nombre de paquets livrés: " + DataUsine.nbDePaquetsLivre);
		System.out.println("Nombre de lettres livrées: " + DataUsine.nbDeLettresLivree);
		System.out.println();
		System.out.println("****** Performances ******");
		System.out.println("Nombre de priorités accordées: " + DataUsine.nbDePrioritesAccordees);
		System.out.println("Nombre de threads (activités) lancés: " + DataUsine.nbDeThreadsLance);
		System.out.println("Temps écoulé: " + time + " milisec");
		
	
	}


	synchronized private void effectuerTransitions() {
		for (int i=0; i<DataUsine.nbT; i++){
			if(DataUsine.getTransSensibilisee(i)==1){ //Si la transition est sensibilisée
				if (interfaceU.getEvent(i)==1 ){			
					DataUsine.nouveauMarquage(i); //On fait un nouveau marquage
					interfaceU.resetEvent(i); //On reset les evenements
					DataUsine.threadsLance[i]--;
					
					
				}
			}
		}
		
	}


	synchronized private void lancerActivite() {
		for (int i=0; i<DataUsine.nbT; i++){	
			//active les Threads associés aux jetons si il n'a pas déjas atteind son max de threads
			
			if (DataUsine.threadsLance[i] < DataUsine.threadMax[i] && 
					DataUsine.postSensibilisee[i]==1 
					){
				interfaceU.lancerActivite(i);
				DataUsine.threadsLance[i]++;
				
			}
			
		}
		
	}


	synchronized private void checkSensibilisations() {
		moteur.rechercheSensibilisations();
		
	}
	
}

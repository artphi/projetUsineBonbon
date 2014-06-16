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
			
			effectuerTransactions();
			
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
		System.out.println("Nombre de bonbons produits: " + DataUsine.nbDeBonbonsProduits);
		System.out.println("Nombre de threads lancés: " + DataUsine.nbDeThreadsLance);
		System.out.println("Nombre de transitions effectuées: " + DataUsine.nbdeTransactionsEffectuee);
		System.out.println("Temps écoulé: " + time + " milisec");
	
	}


	synchronized private void effectuerTransactions() {
		for (int i=0; i<DataUsine.nbT; i++){
			if(DataUsine.getTransSensibilisee(i)==1){ //Si la transaction est sensibilisée
				if (interfaceU.getEvent(i)==1 /*&& (DataUsine.marquageActuel[i] < DataUsine.getVecteurMax(i))*/){ //Si on a recu l'evenement et qu'il y a de la place				
					DataUsine.nouveauMarquage(i); //On fait un nouveau marquage
					interfaceU.resetEvent(i); //On reset les evenements
					moteur.setActivite(i, 0);// on met à 0 l'activité
					
					
				}
			}
		}
		
	}


	synchronized private void lancerActivite() {
		for (int i=0; i<DataUsine.nbT; i++){	
			//active les Threads associés aux jetons si l'état montre que ce n'était pas encore fait
			etatCourant = DataUsine.getActivite(i);
			
			if (etatCourant<DataUsine.threadMax[i] && DataUsine.getTransSensibilisee(i)==1){
				interfaceU.lancerActivite(i);
				moteur.setActivite(i, 1);	
				
			}
		}
		
	}


	synchronized private void checkSensibilisations() {
		moteur.rechercheSensibilisations();
		
	}
	
}

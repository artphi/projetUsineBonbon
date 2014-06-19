package UsineBobons;

public class InterfaceUsine {
	boolean fabriquerBonbons = true;
	static int[] etatEvents={0,0,0,0,0,0,0,0,0,0,0,0};
	
	synchronized public void lancerActivite(int i){
		
		switch(i){
		
		case 0: ProduitMatPremSucre p1 = new ProduitMatPremSucre(this);
			p1.start();
			break;
			
		case 1: p2_ProduitSucre p2 = new p2_ProduitSucre(this);
			p2.start();
			break;
			
		case 2: ProduitMatPremColorant p3 = new ProduitMatPremColorant(this);
		p3.start();
		break;
		
		case 3: p4_ProduitColorant p4 = new p4_ProduitColorant(this);
		p4.start();
		break;
		
		case 4: p5_ProduitBonbons p5 = new p5_ProduitBonbons(this);
		p5.start();
		break;
		
		case 5: p6_ProduitPaquet p6 = new p6_ProduitPaquet(this);
		p6.start();
		break;
		
		case 6: p7_ProduitColis p7 = new p7_ProduitColis(this);
		p7.start();
		break;
		
		case 7: p8_ExpedieColis p8 = new p8_ExpedieColis(this);
		p8.start();
		break;
		
		case 8: p9_RetourVehicule p9 = new p9_RetourVehicule(this);
		p9.start();
		break;
		
		case 9: p10_GenLettres p10 = new p10_GenLettres(this);
		p10.start();
		break;
		
		case 10: p11_ExpedieLettre p11 = new p11_ExpedieLettre(this);
		p11.start();
		break;
		
		case 11: p12_RetourVehicule p12 = new p12_RetourVehicule(this);
		p12.start();
		break;
		}
		DataUsine.nbDeThreadsLance++;
	}
	


	synchronized public boolean fabriquerBonbons(){
		return fabriquerBonbons;
	}
	
	synchronized public void setFabriquerBonbons(boolean set){
		fabriquerBonbons = set;
	}

	synchronized public void catchEvent(int i) {
		etatEvents[i]=1;		
	}
	
	synchronized public void resetEvent(int i){
		etatEvents[i]=0;		
	}
	
	synchronized public int getEvent(int i){
		return etatEvents[i];
	}
}

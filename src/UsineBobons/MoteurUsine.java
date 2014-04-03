package UsineBobons;

public class MoteurUsine {
	
	
	synchronized public void rechercheSensibilisations(){
		DataUsine.setTransSensibilisee();
	}
	
	synchronized public void setActivite(int i, int etat){
	 DataUsine.setActivite(i, etat);
		
	}
	
	synchronized public void nouveauMarquage(int i){
		DataUsine.nouveauMarquage(i);
	}
	

}

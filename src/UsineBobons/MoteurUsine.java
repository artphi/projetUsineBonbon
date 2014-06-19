package UsineBobons;

public class MoteurUsine {
	
	
	synchronized public void rechercheSensibilisations(){
		DataUsine.setTransSensibilisee();
	}
	
	
	synchronized public void nouveauMarquage(int i){
		DataUsine.nouveauMarquage(i);
	}
	

}

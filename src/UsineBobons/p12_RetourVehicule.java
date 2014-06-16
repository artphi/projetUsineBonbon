package UsineBobons;

public class p12_RetourVehicule extends Thread {
	
	InterfaceUsine intefaceU;
	
	public p12_RetourVehicule(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("Le véhicule est entrain de revenir");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Le véhicule est de retour et prêt à charger ");
		intefaceU.catchEvent(11);
		
	}
}

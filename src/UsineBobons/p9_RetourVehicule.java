package UsineBobons;

public class p9_RetourVehicule extends Thread {
	
	InterfaceUsine intefaceU;
	
	public p9_RetourVehicule(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("Le véhicule à commencé son trajet de retour");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Le véhicule est de retour et près à charger ");
		intefaceU.catchEvent(8);
		intefaceU.setFabriquerBonbons(false);
	}
}

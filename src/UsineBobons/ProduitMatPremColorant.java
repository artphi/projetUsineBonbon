package UsineBobons;

public class ProduitMatPremColorant  extends Thread {
InterfaceUsine intefaceU;
	
	public ProduitMatPremColorant(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("La récolte de matière première de colorants à commencé");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de la récolte de matière première de colorants");
		intefaceU.catchEvent(2);
	}
}

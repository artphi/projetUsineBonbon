package UsineBobons;

public class ProduitMatPremSucre extends Thread {
InterfaceUsine intefaceU;
	
	public ProduitMatPremSucre(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("La récolte de matière première de sucre à commencé");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de la récolte de matière première de sucre");
		intefaceU.catchEvent(0);
	}
}

package UsineBobons;

public class p6_ProduitPaquet extends Thread {
	
	InterfaceUsine intefaceU;
	
	public p6_ProduitPaquet(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("La production de 1 paquet à commencé");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de la production de 1 paquet ");
		intefaceU.catchEvent(5);
	}
}

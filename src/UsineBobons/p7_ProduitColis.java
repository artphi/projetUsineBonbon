package UsineBobons;

public class p7_ProduitColis extends Thread {
	
	InterfaceUsine intefaceU;
	
	public p7_ProduitColis(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("La production de 1 colis à commencé");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de la production de 1 colis ");
		intefaceU.catchEvent(6);
	}
}

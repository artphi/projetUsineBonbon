package UsineBobons;

public class p4_ProduitColorant extends Thread {
	
	InterfaceUsine intefaceU;
	
	public p4_ProduitColorant(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("La production de 1l de colorant à commencé");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de la production de 1l de colorant ");
		intefaceU.catchEvent(3);
	}
}

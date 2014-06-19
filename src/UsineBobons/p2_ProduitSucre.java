package UsineBobons;

public class p2_ProduitSucre extends Thread {
	
	InterfaceUsine intefaceU;
	
	public p2_ProduitSucre(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("La production de 1kg de sucre à commencé");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de la production de 1kg de sucre ");
		DataUsine.nbSucreProduit++;
		intefaceU.catchEvent(1);
	}

}

package UsineBobons;

public class p5_ProduitBonbons extends Thread {
	
	InterfaceUsine intefaceU;
	
	public p5_ProduitBonbons(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("La production de 50 bonbons à commencé");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de la production de 50 bonbons ");
		DataUsine.nbDeBonbonsProduits++;
		intefaceU.catchEvent(4);
	}
}

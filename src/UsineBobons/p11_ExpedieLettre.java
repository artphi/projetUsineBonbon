package UsineBobons;

public class p11_ExpedieLettre extends Thread {
	
	InterfaceUsine intefaceU;
	
	public p11_ExpedieLettre(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("5 lettres vont êtres préparées pour l'expédition");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("les 5 letres sont expédiées ");
		intefaceU.catchEvent(10);
		
	}
}

package UsineBobons;

public class p10_GenLettres extends Thread {
	
	InterfaceUsine intefaceU;
	
	public p10_GenLettres(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println("Une lettre est entrain de se générer");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Une lettre à été générée");
		intefaceU.catchEvent(9);
		
	}
}

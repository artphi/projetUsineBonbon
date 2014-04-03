package UsineBobons;

public class p8_ExpedieColis extends Thread {
	
	InterfaceUsine intefaceU;
	
	public p8_ExpedieColis(InterfaceUsine inteUsine){
		this.intefaceU = inteUsine;
	}
	
	public void run(){
		System.out.println(" 10 colis ont été expédiés");
		try {
			Thread.sleep((long) Math.ceil(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("10 colis ont été livrés ");
		intefaceU.catchEvent(7);
	}
}

package UsineBobons;

public class startProd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterfaceUsine interfaceU= new InterfaceUsine();
		MoteurUsine RDP = new MoteurUsine();
		OrdonnanceurUsine OU = new OrdonnanceurUsine(interfaceU, RDP);
		
		OU.start();
		
		

	}

}

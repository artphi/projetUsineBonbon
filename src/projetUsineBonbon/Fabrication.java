package projetUsineBonbon;

public class Fabrication implements Runnable {
	private int colonne;
	private long[][] matPre, marquagePrecedent;
	
	public Fabrication(int colonne, long[][] matPre, long[][] marquagePrecedent) {
		this.colonne = colonne;
		this.matPre = matPre;
		this.marquagePrecedent = marquagePrecedent;
	}
	
	public int getColonne() {
		return this.colonne;
	}
	
	@Override
	public void run() {
		
	}

}

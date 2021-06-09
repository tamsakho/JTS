package mantic.banque.gestioncompte;

public class Banque {
	private Compte compte;
	protected void init(){
		compte= new CompteImpl();
	}
	
	public double getSolde(){
		return compte.getSolde();
	}

}

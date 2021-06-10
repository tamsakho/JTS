package mantic.banque.gestioncompte;

import java.util.HashMap;
import java.util.Map;

public class Banque {
	  private static Map<String,Compte> lesComptes; 

	  static { 
	    lesComptes = new HashMap<String,Compte>(); 
	    lesComptes.put("112222554485", new CompteImpl(new Personne("Dupond","Tafsir","0238000000"))); 
	    lesComptes.put("193333P", new CompteImpl(new Personne("Sauger","matthieu","0238000000"))); 
	  }; 
	
	public double getSolde(String numero){
		Compte compte = lesComptes.get(numero);
		return compte.getSolde();
	}
	
	public void ajouterCompte(String numero, Personne titulaire) {		
		this.lesComptes.put(numero, new CompteImpl(titulaire));
		
	}

}

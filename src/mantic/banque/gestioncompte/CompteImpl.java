package mantic.banque.gestioncompte;

import java.util.ArrayList;
import java.util.List;

import mantic.banque.utils.BanqueUtils;

public class CompteImpl implements Compte{
	private List<Double> credits;
	private List<Double> debits;
	private double decouvert;
	
	
	public CompteImpl() {
		super();
		credits = new ArrayList<>();
		debits= new ArrayList<>();
	}
	
	public CompteImpl(double decouvert) {
		this();
		this.decouvert = decouvert;
	}
	public double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	private boolean verifDecouvert(double montant) {  
		return (getSolde() - montant >= -getDecouvert());
	}
	
	public void crediter(double montant){
		if(montant > 0){
			credits.add(montant);
		}
	}
	public void debiter(double montant){
		if(montant > 0){
			if(verifDecouvert(montant)){
				credits.add(montant);
			}			
		}
	}

	public double getSolde() {
		return BanqueUtils.calculSomme(credits) - BanqueUtils.calculSomme(debits);
	} 

}

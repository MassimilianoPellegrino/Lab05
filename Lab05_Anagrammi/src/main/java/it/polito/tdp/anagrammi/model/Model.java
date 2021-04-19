package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	Set<String> risultato;
	AnagrammaDAO anagrammaDao;
	
	public Model() {
		anagrammaDao = new AnagrammaDAO();
	}
	
	public boolean isCorrect(String anagramma) {
		return this.anagrammaDao.isCorrect(anagramma);
	}
	
	public Set<String> getSoluzione(String parola){
		risultato = new HashSet<>();
		if(anagrammaDao.isCorrect(parola)) {
			permuta("", 0, parola);
			//System.out.println(risultato);
			return risultato;
		}
		return null;
		
	}
	
	public void permuta(String parziale, Integer livello, String residue) {
		if(residue.length() == 0) {
			risultato.add(parziale);
			return;
		}
		else{
			for(int i=0; i<residue.length(); i++) {
				parziale=parziale+residue.charAt(i);
				permuta(parziale, livello+1, residue.substring(0, i)+residue.substring(i+1));
				parziale=parziale.substring(0, parziale.length()-1);
			}
		}
		
	}
}

package it.polito.tdp.IndovinaNumero.Model;

public class Gioco {
	public enum OutcomeGioco {
		Vinto,
		Perso,
		TroppoAlto, 
		TroppoBasso
	}
	// Dati di funzionamento dell'applicazione
	private int TMax;
	private int NMax;
	private int NTentativiFatti;
	private int numeroSegreto;

	public void iniziaGioco(Difficolta livello) {
		this.NMax = livello.getNMax();
		this.TMax = livello.getTMax();
		this.NTentativiFatti = 0;
    	this.numeroSegreto = (int)(Math.random()*this.NMax) + 1;
    	
	}
	/*
	 * funzione che esegue un tentativo di indovinare il numero segreto
	 * @param tentativo: il numero che tiriamo per indovinare il numero segreto
	 * @return un intero: 0 se indovinato, 1 se abbiamo esaurito i tentativi, 
	 * 2 se non abbiamo indovinato e il numero trovato è troppo altro, 
	 * 3 se non abbiamo indovinato e il numero trovato troppo basso
	 */
	public OutcomeGioco faiTentativo(int guess) {
		//incrementare numero tentativi fatti
    	this.NTentativiFatti++;
    	//giocare
    	// caso 0: vittoria
    	if (guess == this.numeroSegreto) {
    		return OutcomeGioco.Vinto;
    	}
    	// caso 1: sconfitta
    	if (this.NTentativiFatti == this.TMax) {
    		return OutcomeGioco.Perso;
    	}
    	// caso 2/3: non abbiamo indovinato. Il numero è troppo alto oppure troppo basso
    	if(guess>this.numeroSegreto) {
    		return OutcomeGioco.TroppoAlto;
    	}else  {
    		return OutcomeGioco.TroppoBasso;
    	}
	}

	public int getNTentativiFatti() {
		return NTentativiFatti;
	}

	public void setNTentativiFatti(int nTentativiFatti) {
		NTentativiFatti = nTentativiFatti;
	}

	public int getNumeroSegreto() {
		return numeroSegreto;
	}

	public void setNumeroSegreto(int numeroSegreto) {
		this.numeroSegreto = numeroSegreto;
	}

	public int getTMax() {
		return TMax;
	}

	public int getNMax() {
		return NMax;
	}
}

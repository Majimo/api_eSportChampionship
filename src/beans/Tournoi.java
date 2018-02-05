package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tournoi {

	private int id;
	private String jeu;
	private int nbPlaces;
	private String dateTournoi;
	
	public Tournoi() {
		
	}

	public Tournoi(String jeu, int nbPlaces, String dateTournoi) {
		super();
		this.jeu = jeu;
		this.nbPlaces = nbPlaces;
		this.dateTournoi = dateTournoi;
	}

	public Tournoi(int id, String jeu, int nbPlaces, String dateTournoi) {
		super();
		this.id = id;
		this.jeu = jeu;
		this.nbPlaces = nbPlaces;
		this.dateTournoi = dateTournoi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJeu() {
		return jeu;
	}

	public void setJeu(String jeu) {
		this.jeu = jeu;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getDateTournoi() {
		return dateTournoi;
	}

	public void setDateTournoi(String dateTournoi) {
		this.dateTournoi = dateTournoi;
	}

	@Override
	public String toString() {
		return "Tournoi [id=" + id + ", jeu=" + jeu + ", nbPlaces=" + nbPlaces + ", dateTournoi=" + dateTournoi + "]";
	}
	
}

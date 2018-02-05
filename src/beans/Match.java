package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Match {
	
	private int id;
	private int joueur1;
	private String j1Pseudo;
	private int joueur2;
	private String j2Pseudo;
	private int tournoi;
	
	public Match() {
		
	}

	public Match(int id, int joueur1, int joueur2, int tournoi) {
		super();
		this.id = id;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.setTournoi(tournoi);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(int joueur1) {
		this.joueur1 = joueur1;
	}

	public int getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(int joueur2) {
		this.joueur2 = joueur2;
	}

	public int getTournoi() {
		return tournoi;
	}

	public void setTournoi(int tournoi) {
		this.tournoi = tournoi;
	}

	public String getJ1Pseudo() {
		return j1Pseudo;
	}

	public void setJ1Pseudo(String j1Pseudo) {
		this.j1Pseudo = j1Pseudo;
	}

	public String getJ2Pseudo() {
		return j2Pseudo;
	}

	public void setJ2Pseudo(String j2Pseudo) {
		this.j2Pseudo = j2Pseudo;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", joueur1=" + joueur1 + ", j1Pseudo=" + j1Pseudo + ", joueur2=" + joueur2
				+ ", j2Pseudo=" + j2Pseudo + ", tournoi=" + tournoi + "]";
	}
	
}

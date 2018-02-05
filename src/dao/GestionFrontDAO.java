package dao;

import java.util.List;

import beans.Joueur;
import beans.Match;

public interface GestionFrontDAO {

	//JOUEUR
	public Joueur createJoueur(String nom, String prenom, String pseudo, String mail);
	
	public void inscrireJoueur(int joueur_id, int tournoi_id);
	
	public Joueur getJoueurByMail(String mail);
	
	public Joueur getJoueurById(int id);
	
	//TOURNOI
	
	
	
	
	//MATCH
	public List<Match> getListMatch(int id_tournoi);
	
}

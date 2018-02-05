package dao;

import java.util.List;

import beans.Joueur;
import beans.Match;
import beans.Tournoi;

public interface GestionAdminDAO {

	List<Tournoi> getListTournoi();

	Tournoi createTournoi(String jeu, int nbPlaces, String date);

	List<Joueur> getListJoueursTournoi(int idTournoi);
	
	void generateArbreTournoi(Match m);

	List<Match> getMatchByTournoi(int idTournoi);
}

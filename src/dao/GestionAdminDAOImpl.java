package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Joueur;
import beans.Match;
import beans.Tournoi;

public class GestionAdminDAOImpl implements GestionAdminDAO {

	public static GestionAdminDAO instance = null;

	public static GestionAdminDAO getInstance() {
		if (instance == null) {
			instance = new GestionAdminDAOImpl();
		}
		return instance;
	}

	@Override
	public List<Tournoi> getListTournoi() {
		List<Tournoi> lesTournois = new ArrayList<Tournoi>();
        ResultSet rs = null;

        Connection cnx = AccesBase.getConnection();
        String sql = "SELECT * FROM tournoi";

        try {
            PreparedStatement req = cnx.prepareStatement(sql);
            rs = req.executeQuery();

            while (rs.next()){
                Tournoi t = new Tournoi();
                t.setId(rs.getInt("id"));
                t.setJeu(rs.getString("jeu"));
                t.setNbPlaces(rs.getInt("nbPlaces"));
                t.setDateTournoi(rs.getString("dateTournoi"));

                lesTournois.add(t);
            }
            req.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lesTournois;
	}

	@Override
	public Tournoi createTournoi(String jeu, int nbPlaces, String date) {
		Tournoi tournoi = new Tournoi(jeu, nbPlaces, date);
		
		System.out.println("DAO | jeu : " + jeu + " places : " + nbPlaces + " date : " + date);
		
		String sql = "INSERT INTO tournoi (jeu, nbPlaces, dateTournoi) VALUES (?, ?, ?)";

		PreparedStatement pstmt;
		try {
			Connection cnx = AccesBase.getConnection();
			pstmt = cnx.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, tournoi.getJeu());
			pstmt.setInt(2, tournoi.getNbPlaces());
			pstmt.setString(3, tournoi.getDateTournoi());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				tournoi.setId(rs.getInt(1));
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return tournoi;
	}

	@Override
	public List<Joueur> getListJoueursTournoi(int id_tournoi) {
		List<Joueur> lesJoueurs = new ArrayList<Joueur>();
        ResultSet rs = null;

        Connection cnx = AccesBase.getConnection();
        String sql = "SELECT j.id, j.nom, j.prenom, j.pseudo FROM joueur_tournoi t JOIN joueur j ON j.id = t.joueur_id WHERE t.tournoi_id = ?";

        try {
            PreparedStatement req = cnx.prepareStatement(sql);
            req.setInt(1, id_tournoi);
            
            rs = req.executeQuery();

            while (rs.next()){
                Joueur j = new Joueur();
                j.setId(rs.getInt("id"));
                j.setNom(rs.getString("nom"));
                j.setPrenom(rs.getString("prenom"));
                j.setPseudo(rs.getString("pseudo"));
                j.setIdTournoi(id_tournoi);

                lesJoueurs.add(j);
            }
            req.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lesJoueurs;
	}

	
	//MATCH -------------------------
	@Override
	public void generateArbreTournoi(Match m) {		
		Connection cnx = AccesBase.getConnection();
        String sql = "INSERT INTO match (joueur_1, joueur_2, tournoi) VALUES (?, ?, ?)";
        
        try {
			PreparedStatement req = cnx.prepareStatement(sql);
			req.setInt(1, m.getJoueur1());
			req.setInt(2, m.getJoueur2());
			req.setInt(3, m.getTournoi());
			
			req.executeUpdate();
			
			req.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Match> getMatchByTournoi(int idTournoi) {
		Connection cnx = AccesBase.getConnection();
        String sql = "SELECT * FROM match WHERE tournoi = ?";
        
        ResultSet rs = null;
        List<Match> lesMatchs = new ArrayList<Match>();
        
        try {
			PreparedStatement req = cnx.prepareStatement(sql);
			req.setInt(1, idTournoi);
			
			rs = req.executeQuery();
			
			while (rs.next()){
				Match m = new Match();
				m.setId(rs.getInt("id"));
				m.setJoueur1(rs.getInt("joueur_1"));
				m.setJoueur2(rs.getInt("joueur_2"));
				m.setTournoi(idTournoi);
				
				lesMatchs.add(m);
			}
			
			req.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return lesMatchs;
	}

}

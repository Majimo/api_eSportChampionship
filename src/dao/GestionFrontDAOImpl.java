package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Joueur;
import beans.Match;

public class GestionFrontDAOImpl implements GestionFrontDAO {

	private static GestionFrontDAO instance = null;
	
	public static GestionFrontDAO getInstance(){
		if (instance == null){
			instance = new GestionFrontDAOImpl();
		}
		return instance;
	}

	
	//JOUEUR -------------------------------------------------
	
	@Override
	public Joueur createJoueur(String nom, String prenom, String pseudo, String mail) {
		Joueur j = new Joueur();
		
		Connection cnx = AccesBase.getConnection();
		String sql = "INSERT INTO Joueur (nom, prenom, pseudo, mail) VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement req = cnx.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			req.setString(1, nom);
			req.setString(2, prenom);
			req.setString(3, pseudo);
			req.setString(4, mail);
			
			req.executeUpdate();
			
			ResultSet rs = req.getGeneratedKeys();
			if (rs.next()){
				j.setId(rs.getInt(1));
				j.setNom(nom);
				j.setPrenom(prenom);
				j.setPseudo(pseudo);
				j.setMail(mail);
			}
			
			req.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return j;
	}
	
	@Override
	public void inscrireJoueur(int joueur_id, int tournoi_id) {
		System.out.println("id joueur : " + joueur_id + " ; Tournoi id : " + tournoi_id);
		Connection cnx = AccesBase.getConnection();
		String sql = "INSERT INTO joueur_tournoi (joueur_id, tournoi_id) VALUES (?, ?)";
		
		try {
			PreparedStatement req = cnx.prepareStatement(sql);
			req.setInt(1, joueur_id);
			req.setInt(2, tournoi_id);
			
			req.executeUpdate();
			
			req.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Joueur getJoueurByMail(String mail){
		Joueur j = new Joueur();
		j.setId(-1);
		ResultSet rs = null;
		
		Connection cnx = AccesBase.getConnection();
		String sql = "SELECT * FROM Joueur WHERE mail = ?";
		
		try {
			PreparedStatement req = cnx.prepareStatement(sql);
			req.setString(1, mail);
			
			rs = req.executeQuery();
			
			if (rs.next()){
				j.setId(rs.getInt("id"));
				j.setNom(rs.getString("nom"));
				j.setPrenom(rs.getString("prenom"));
				j.setPseudo(rs.getString("pseudo"));
				j.setMail(mail);
			}
			
			req.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return j;
	}
	
	public Joueur getJoueurById(int id){
		Joueur j = new Joueur();
		ResultSet rs = null;
		Connection cnx = AccesBase.getConnection();
		String sql = "SELECT * FROM Joueur WHERE id = ?";
		
		j.setId(-1);
		
		try {
			PreparedStatement req = cnx.prepareStatement(sql);
			req.setInt(1, id);
			
			rs = req.executeQuery();
			
			if (rs.next()){
				j.setNom(rs.getString("nom"));
				j.setPrenom(rs.getString("prenom"));
				j.setPseudo(rs.getString("pseudo"));
				j.setMail(rs.getString("mail"));
				j.setId(rs.getInt("id"));
			}
			
			req.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return j;
	}
	
	//MATCH ----------------------------------------------------------
	
	
	@Override
	public List<Match> getListMatch(int idTournoi) {
		List<Match> lesMatchs = new ArrayList<Match>();
		ResultSet rsM = null;
		ResultSet rsJ1 = null;
		ResultSet rsJ2 = null;
		
		Connection cnx = AccesBase.getConnection();
		String sqlMatch = "SELECT * FROM match WHERE tournoi = ?";
		String sqlJ1 = "SELECT j.pseudo FROM match m JOIN tournoi t ON m.tournoi = t.id "
				+ "JOIN joueur j ON m.joueur_1 = j.id WHERE m.tournoi = ? AND m.id = ?;";
		String sqlJ2 = "SELECT j.pseudo FROM match m JOIN tournoi t ON m.tournoi = t.id "
				+ "JOIN joueur j ON m.joueur_2 = j.id WHERE m.tournoi = ? AND m.id = ?;";
		
		try {
			PreparedStatement pstmtM = cnx.prepareStatement(sqlMatch);
			pstmtM.setInt(1, idTournoi);
            rsM = pstmtM.executeQuery();
			
			while(rsM.next()) {
				Match m = new Match();
				
				m.setId(rsM.getInt("id"));
				m.setTournoi(rsM.getInt("tournoi"));
				m.setJoueur1(rsM.getInt("joueur_1"));
				m.setJoueur2(rsM.getInt("joueur_2"));
				
				PreparedStatement pstmtJ1 = cnx.prepareStatement(sqlJ1);
				pstmtJ1.setInt(1, idTournoi);
				pstmtJ1.setInt(2, m.getId());
	            rsJ1 = pstmtJ1.executeQuery();
				
				if(rsJ1.next()){
					m.setJ1Pseudo(rsJ1.getString("pseudo"));
				}
				
				PreparedStatement pstmtJ2 = cnx.prepareStatement(sqlJ2);
				pstmtJ2.setInt(1, idTournoi);
				pstmtJ2.setInt(2, m.getId());
	            rsJ2 = pstmtJ2.executeQuery();
				
				if(rsJ2.next()){
					m.setJ2Pseudo(rsJ2.getString("pseudo"));
				}
				lesMatchs.add(m);
				
				pstmtJ1.close();
				pstmtJ2.close();
			}
			
			pstmtM.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lesMatchs;
	}

	
	
	
}

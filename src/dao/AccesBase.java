package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AccesBase {
	private static InitialContext jndi;
	private static DataSource ds;
	static {
		// Charger l'annuaire JNDI
		try {
			jndi = new InitialContext();
			// Chercher le pool de connexions dans l'annuaire
			ds=(DataSource) jndi.lookup("java:comp/env/jdbc/dsTPWeb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection cnx=null;
		// Activer une connexion du pool
		if (ds != null)
			try {
				cnx=ds.getConnection();
				System.out.println("Je récupère une connexion par le Pool de Tomcat!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return cnx;
	}
}

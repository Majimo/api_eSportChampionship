package serviceRest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import beans.Match;
import beans.Joueur;
import beans.Tournoi;
import dao.GestionAdminDAO;
import dao.GestionAdminDAOImpl;

@Path("/administration")
public class AdminService {
	
	@GET()
	@Path("/afficher")
	public Response goToAdmin() {
		URI uri = UriBuilder.fromUri("../administration/administration.jsp").build();
		return Response.seeOther(uri).build();
	}

	@POST()
	@Path("/tournoi/create")
	public Response createTournoi(@FormParam("jeu") String jeu,@FormParam("nbPlaces") int nbPlaces,@FormParam("date") String date){
		// Tournoi tournoi = new Tournoi();
		
		System.out.println("jeu : " + jeu + " places : " + nbPlaces + " date : " + date);
		
		GestionAdminDAO gad = GestionAdminDAOImpl.getInstance();
		gad.createTournoi(jeu, nbPlaces, date);
		
		URI uri = UriBuilder.fromUri("../administration/administration.jsp").build();
		return Response.seeOther(uri).build();
	}
	
	@GET()
	@Path("/tournoi/afficher")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tournoi> getListTournoi(){
		List<Tournoi> lesTournois = new ArrayList<Tournoi>();
		
		GestionAdminDAO gad = GestionAdminDAOImpl.getInstance();
		lesTournois = gad.getListTournoi();
		
		System.out.println(lesTournois);
		
		return lesTournois;
	}
	
	@GET()
	@Path("/tournoi/afficher/joueurs/{id_tournoi}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Joueur> getListJoueursTournoi(@PathParam("id_tournoi") int idTournoi){
		List<Joueur> lesJoueurs = new ArrayList<Joueur>();
		
		GestionAdminDAO gad = GestionAdminDAOImpl.getInstance();
		lesJoueurs = gad.getListJoueursTournoi(idTournoi);
		
		System.out.println(lesJoueurs);
		
		return lesJoueurs;
	}
	
	@GET()
	@Path("/tournoi/arbre/generer/{id_tournoi}")
	public void generateArbreTournoi(@PathParam("id_tournoi") int idTournoi){
		List<Joueur> lesJoueurs = this.getListJoueursTournoi(idTournoi);
		GestionAdminDAO gad = GestionAdminDAOImpl.getInstance();
		
		List<Match> emptyPlease = gad.getMatchByTournoi(idTournoi);
		
		if (emptyPlease.size() == 0){
			Joueur j1 = new Joueur();
			Joueur j2 = new Joueur();
			Match m = new Match();
			
			Random r = new Random();
			int random = 0;
			
			
			
			while(lesJoueurs.size() > 1){
				random = r.nextInt(lesJoueurs.size());
				j1 = lesJoueurs.get(random);
				m.setJoueur1(j1.getId());
				lesJoueurs.remove(random);
				
				random = r.nextInt(lesJoueurs.size());
				j2 = lesJoueurs.get(random);
				m.setJoueur2(j2.getId());
				lesJoueurs.remove(random);
				
				m.setTournoi(idTournoi);
				
				System.out.println(m);
				if(verifMatch(m)){
					gad.generateArbreTournoi(m);
				}
			}
			
			if (lesJoueurs.size() == 1){
				System.out.println("le joueur " + lesJoueurs.get(0) + " est qualifié d'office !");
			}
		}
		else{
			System.out.println("T'as déjà générer un arbre");
		}
	}
	
	private boolean verifMatch(Match m){
		if (m.getJoueur1() <= 0){
			return false;
		}
		if (m.getJoueur2() <= 0){
			return false;
		}
		if (m.getTournoi() <= 0){
			return false;
		}
				
		return true;
	}
}

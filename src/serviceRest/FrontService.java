package serviceRest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import beans.Joueur;
import beans.Match;
import beans.Tournoi;
import dao.GestionAdminDAO;
import dao.GestionAdminDAOImpl;
import dao.GestionFrontDAO;
import dao.GestionFrontDAOImpl;

@Path("/front")
public class FrontService {
	
	//JOUEUR ---------------------------------------------
	
	@POST()
	@Path("/joueur/create")
	public Joueur createJoueur(@FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("pseudo") String pseudo, @FormParam("mail") String mail, @FormParam("tournoi") int tournoi_id){
		GestionFrontDAO gf = GestionFrontDAOImpl.getInstance();
		Joueur j  = new Joueur();
		
		j = gf.getJoueurByMail(mail);
		
		if (j.getId() <= 0){
			j = gf.createJoueur(nom, prenom, pseudo, mail);
		}
		gf.inscrireJoueur(j.getId(), tournoi_id);
		
		return j;
	}
	
	//LISTE DES TOURNOIS A L'INSCRIPTION ------------------
	
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
	@Path("match/afficher/{id_tournoi}")
	public Response goToAdmin(@PathParam("id_tournoi") int idTournoi) {
		URI uri = UriBuilder.fromUri("../match.jsp?id=" + idTournoi).build();
		return Response.seeOther(uri).build();
	}
	
	@GET()
	@Path("match/afficher/liste/{id_tournoi}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Match> getListMatch(@PathParam("id_tournoi") int idTournoi){
		List<Match> lesMatchs = new ArrayList<Match>();
		
		GestionFrontDAO gad = GestionFrontDAOImpl.getInstance();
		lesMatchs = gad.getListMatch(idTournoi);
		
		System.out.println(lesMatchs);
		
		return lesMatchs;
	}
	
	//TOURNOI -----------------------------------------
	
	@GET()
	@Path("/tournoi/arbre/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Match> getMatchByTournoi(int id_tournoi){		
		GestionFrontDAO gf = GestionFrontDAOImpl.getInstance();
		
		return gf.getListMatch(id_tournoi);
	}
}

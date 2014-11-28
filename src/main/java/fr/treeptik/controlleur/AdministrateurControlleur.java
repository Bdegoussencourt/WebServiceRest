package fr.treeptik.controlleur;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Administrateur;
import fr.treeptik.service.impl.AdministateurServiceImpl;

@Path("/administrateur")

@Stateless
public class AdministrateurControlleur {

	private Administrateur administrateur = new Administrateur();

	@EJB
	private AdministateurServiceImpl serviceAdmin;

	// **********LISTES*****************************************************
	private List<Administrateur> listAdministrateurs = new ArrayList<Administrateur>();
	
	@Context
	private UriInfo uriInfo;
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Administrateur> getAllAdministrateur() throws ServiceException{
		return serviceAdmin.getALLAdministrateurs();
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAdministrateur(Administrateur a) throws ServiceException{
		serviceAdmin.saveAdministrateur(a);
		return Response.status(200).entity("CHAMPION").build();
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Administrateur updateAdministrateur(Administrateur a) throws ServiceException{
		return serviceAdmin.saveAdministrateur(a);
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAdministrateur(@PathParam("id")Integer id) throws ServiceException{
		Administrateur a = new Administrateur();
		a.setId(id);
		serviceAdmin.removeAdministrateur(a);
	}
}
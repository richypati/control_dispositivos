package co.edu.udea.controldispositivos.serviciosweb;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.exception.ConstraintViolationException;

import co.edu.udea.controldispositivos.logica.IUsuarioService;
import co.edu.udea.controldispositivos.logica.UsuarioService;

@Path("/usuario")
public class UsuarioWebService {
	
	IUsuarioService usuarioService;

	@GET
	@Path("esUsuarioValido")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response esUsuarioValido(@QueryParam("email")String email,@QueryParam("password") String password){
		
		Response respuesta;
		usuarioService = new UsuarioService();
		try{
			if (usuarioService.esUsuarioValido(email, password)){
				respuesta = Response.status(Status.ACCEPTED).build();
			}else{
				respuesta = Response.status(Status.UNAUTHORIZED).build();
			}
		}catch(Exception e){
			respuesta = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return respuesta;
	}
	
	@POST
	@Path("registrarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(String usuarioJSON){
		
		Response respuesta;
		try{
			usuarioService.registrarUsuario(usuarioJSON);
			respuesta = Response.status(Status.CREATED).build();
		}catch(ConstraintViolationException cve){
			respuesta = Response.status(Status.CONFLICT).build();
		}catch (Exception e) {
			respuesta = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return respuesta;
	}
}

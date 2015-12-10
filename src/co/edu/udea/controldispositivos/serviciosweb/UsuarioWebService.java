package co.edu.udea.controldispositivos.serviciosweb;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.exception.ConstraintViolationException;

import com.google.gson.Gson;

import co.edu.udea.controldispositivos.dominio.Usuario;
import co.edu.udea.controldispositivos.dto.LoginDTO;
import co.edu.udea.controldispositivos.logica.UsuarioService;
import co.edu.udea.controldispositivos.logicai.IUsuarioService;

@Path("/usuario")
public class UsuarioWebService {
	
	IUsuarioService usuarioService;
	Gson gson;

	@POST
	@Path("esUsuarioValido")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response esUsuarioValido(String loginJSON){
		
		Gson gson = new Gson();
		LoginDTO login = gson.fromJson(loginJSON, LoginDTO.class);
		
		String email = login.getEmail();
		String password = login.getPassword();
		
		Response respuesta;
		
		if ("".equals(email) || "".equals(password)){
			respuesta = Response.status(Status.UNAUTHORIZED).build();
		}else{
			usuarioService = new UsuarioService();
			try{
				if (usuarioService.esUsuarioValido(email, password)){
					respuesta = Response.status(Status.ACCEPTED).build();
				}else{
					respuesta = Response.status(Status.UNAUTHORIZED).build();
				}
			}catch(Exception e){
				e.printStackTrace();
				respuesta = Response.status(Status.INTERNAL_SERVER_ERROR).build();
			}
		}
		return respuesta;
	}
	
	@POST
	@Path("registrarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(String usuarioJSON){
		
		gson = new Gson();
		Usuario usuario = gson.fromJson(usuarioJSON, Usuario.class);
		
		Response respuesta;
		usuarioService = new UsuarioService();
		try{
			if ("".equals(usuario.getEmail()) 
					|| "".equals(usuario.getNombres())
					|| "".equals(usuario.getApellidos())
					|| "".equals(usuario.getPassword())){
				respuesta = Response.status(Status.NOT_ACCEPTABLE).build();
			}else{
				usuarioService.registrarUsuario(usuario);
				respuesta = Response.status(Status.CREATED).build();
			}
		}catch(ConstraintViolationException cve){
			respuesta = Response.status(Status.CONFLICT).build();
		}catch (Exception e) {
			e.printStackTrace();
			respuesta = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return respuesta;
	}
}

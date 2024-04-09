package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.dao.ProveedorDAO;
import com.entity.Proveedor;
import com.general.Status;

@Path("proveedor")
public class ProveedorService {
	Proveedor proveedor = null; 
	ProveedorDAO dao = null;
	
	
	@Path("mostrar") 
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public List<Proveedor> mostrar() {
		dao = new ProveedorDAO();
		List<Proveedor> list = dao.mostrar();
		System.out.println("datos:" + list);
		return list;
	}
	@Path("guardar")
	@POST 
	@Consumes({MediaType.APPLICATION_JSON})//como recibe la informacion
	@Produces({MediaType.APPLICATION_JSON})//como debe responder los datos del server al cliente
	public Status guardar(Proveedor p) {
		System.out.println("Proveedor a guardar");
		Status s = new Status();
		s.setOb(p);
		dao = new ProveedorDAO();
		String response = dao.guardar(p);

		if (response.equals("1")) {
			s.setMensaje("Guardado exitosamente");
			s.setRespuesta(response);
		} else {
			s.setMensaje("Error al guardar");
			s.setRespuesta(response);
		}
		return s;
	}
	
	@Path("actualizar")
	@PUT //
	@Consumes({MediaType.APPLICATION_JSON})//como recibe la informacion
	@Produces({MediaType.APPLICATION_JSON})
	public Status actualizar(Proveedor p) {
		Status s = new Status();
		s.setOb(p);
		dao = new ProveedorDAO();
		String response = dao.actualizar(p);

		if (response.equals("1")) {
			s.setMensaje("Actualizar exitosamente");
			s.setRespuesta(response);
		} else {
			s.setMensaje("Error al actualizar");
			s.setRespuesta(response);
		}
		return s;
	}

		
	
	
	@Path("eliminar/{id}")
	@DELETE 
	@Produces({MediaType.APPLICATION_JSON})
	public Status eliminar(@PathParam ("id")int id) {

		Status s = new Status();
		s.setOb(id);
		dao = new ProveedorDAO();
		String response = dao.eliminar(id);

		if (response.equals("1")) {
			s.setMensaje("Eliminado exitosamente");
			s.setRespuesta(response);
		} else {
			s.setMensaje("Error al eliminar");
			s.setRespuesta(response);
		}
		return s;
	}
	
	@Path("buscar/{id}")
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public Proveedor buscar(@PathParam("id") int id) {
		dao = new ProveedorDAO();
		proveedor = (Proveedor) dao.buscar(id);
		System.out.println("Se encontro el registro");
		return proveedor;
	}
}

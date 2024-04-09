package com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.entity.Proveedor;
import com.general.Metodos;

public class ProveedorDAO implements Metodos {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tables");
	
	EntityManager em = emf.createEntityManager();
	Proveedor proveedor = null;
	@Override
	public String guardar(Object ob) {
		proveedor = (Proveedor) ob;
		em.getTransaction().begin();
		String resultado = null;
		try {
			em.persist(proveedor);
			em.getTransaction().commit();
			resultado="1";
		System.out.println("Registro insertado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			resultado = e.getMessage();
			System.out.println("No pudo insertarse");
		}
		em.close();//Importante cerrar el entity para liberara memoria
		return resultado;
	}

	@Override
	public String actualizar(Object ob) {
		proveedor = (Proveedor) ob;
		Proveedor proveedordb = em.find(Proveedor.class, proveedor.getProveedorId());
		String r = null;
		em.getTransaction().begin();
		try {
			proveedordb.setNombre(proveedor.getNombre());
			proveedordb.setTelefono(proveedor.getTelefono());
			proveedordb.setCorreo(proveedor.getCorreo());
			em.getTransaction().commit();
			System.out.println("Editado correctamente");
			r = "1";
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No pudo editarse");
			r = e.getMessage();
			
		}
		return r;
	}

	@Override
	public String eliminar(int id) {
		String r = null;
		proveedor = em.find(Proveedor.class, id);
		em.getTransaction().begin();
		
		try {
			em.remove(proveedor);
			em.getTransaction().commit();
			System.out.println("Se ha eliminado correctamente");
			r = "1";
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No pudo eliminarse");
			r = e.getMessage();
		}
		return r;
	}

	@Override
	public Object buscar(int id) {
		proveedor = em.find(Proveedor.class, id);
		return proveedor;
	}

	@Override
	public List mostrar() {
		List<Proveedor> ls = em.createQuery("from Proveedor").getResultList();
		return ls;
	}

}

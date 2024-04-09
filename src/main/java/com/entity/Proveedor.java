package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROVEEDOR")
public class Proveedor {

	public Proveedor() {}
	
	public Proveedor(int id) {
		this.proveedorId = id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROVEEDOR_ID", columnDefinition="NUMBER")
	int proveedorId;
	
	@Column(name="NOMBRE", columnDefinition="NVRACHAR(15)")
	String nombre;
	
	@Column(name="TELEFONO", columnDefinition="NVRACHAR(15)")
	String telefono;
	
	@Column(name="CORREO", columnDefinition="NVRACHAR(20)")
	String correo;

	public int getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(int proveedorId) {
		this.proveedorId = proveedorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Proveedor [proveedorId=" + proveedorId + ", nombre=" + nombre + ", telefono=" + telefono + ", correo="
				+ correo + "]";
	}
	
	
}

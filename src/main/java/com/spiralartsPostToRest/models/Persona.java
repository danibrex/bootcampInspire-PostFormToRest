/**
 * 
 */
package com.spiralartsPostToRest.models;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Daniel
 *
 */
@Entity
@Table(name="persona")
public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private String[] pelis;
	private String[] aficiones;
	private String[] musica;
	
	

	
	/**
	 * 
	 */
	public Persona() {
		super();
	}


	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param password
	 * @param pelis
	 * @param aficiones
	 * @param musica
	 */
	public Persona(Long id, String nombre, String apellidos, String email, String password, String[] pelis,
			String[] aficiones, String[] musica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.pelis = pelis;
		this.aficiones = aficiones;
		this.musica = musica;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the nombre
	 */
	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellidos
	 */
	@Column(name="apellidos")
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * @return the email
	 */
	@Column(name="email")
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the password
	 */
	@Column(name="password")
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the pelis
	 */
	@Column(name="pelis")
	public String[] getPelis() {
		return pelis;
	}


	/**
	 * @param pelis the pelis to set
	 */
	public void setPelis(String[] pelis) {
		this.pelis = pelis;
	}


	/**
	 * @return the aficiones
	 */
	@Column(name="aficiones")
	public String[] getAficiones() {
		return aficiones;
	}


	/**
	 * @param aficiones the aficiones to set
	 */
	public void setAficiones(String[] aficiones) {
		this.aficiones = aficiones;
	}


	/**
	 * @return the musica
	 */
	@Column(name="musica")
	public String[] getMusica() {
		return musica;
	}


	/**
	 * @param musica the musica to set
	 */
	public void setMusica(String[] musica) {
		this.musica = musica;
	}

	/**
	 * Me permite igualmente poner etiquetas HTML ya que ser?? invocado en la vista e interpretado por el navegador
	 */
	@Override
	public String toString() {
		return "Persona ["
				+ "<br>id=" + id + "," 
				+ "<br>nombre=" + nombre + "," 
				+ "<br>apellidos=" + apellidos + "," 
				+ "<br>email=" + email + ","
				+ "<br>password=" + password + "," 
				+ "<br>pelis=" + Arrays.toString(pelis) + "," 
				+ "<br>aficiones=" + Arrays.toString(aficiones) + "," 
				+ "<br>musica=" + Arrays.toString(musica) + "<br>]";
	}


	
}

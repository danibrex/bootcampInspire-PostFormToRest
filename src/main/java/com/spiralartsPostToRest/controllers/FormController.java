/**
 * 
 */
package com.spiralartsPostToRest.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spiralartsPostToRest.Util.Util;
import com.spiralartsPostToRest.models.Persona;
import com.spiralartsPostToRest.repository.PersonaRepositoryI;
import com.spiralartsPostToRest.services.PersonaServiceI;

/**
 * BANCO DE PRUEBAS:
 * 
 * Esta clase es un controlador que hace todas las funciones a modo de prueba 
 * - y está respaldada por una una clase Util con
 * - un mapa y un método que encripta más un modelo simple 
 * - de Persona para probar la interacción de datos con el formulario de la vista.
 * 
 * Esta prueba consiste en obtener datos desde HTML mediante un formulario simple.
 * También se hacen pruebas con la respuesta del servidor, etiquetas html y js
 * 
 * Para mi sorpresa el navegador las interpreta como etiquetas válidas que renderiza, puedo usar Js.
 * 
 * PRUEBAS CON curl
 * 
		 curl -i \
		-H "Accept: application/json" \
		-H "Content-Type:application/json" \
		-X POST --data 
		  '{"id": "2","nombre": "johnny", "apellidos": "jurjur"}' "https://localhost:8094/.../peticion"
 * 
 * @author Daniel
 *
 */

@RestController
//@EnableWebMvc
public class FormController {
	
	@Autowired
	private PersonaServiceI personaServiceI;
	
	@RequestMapping(
			value = "/peticion"
			//method = RequestMethod.POST,
			//consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
	)
	
	//creo que también funcionó, devuelve un Json creo, u "ok" si va con HttpStatus no estoy seguro.
	//public ResponseEntity<?> postController(@ModelAttribute Persona persona) {
	
	//public ResponseEntity<HttpStatus> postController(@RequestBody Persona persona) {
	
	//devuelve un Json con @RequestMapping y value ="extensión" Crea una persona con todos los datos, del tiron
	  //public Persona postController(@ModelAttribute Persona persona) {
	
	//coge lo que le paso por POST desde un form con esos campos en el name de los input
		/** Parámetros que obtenemos por el método POST desde el formulario de la vista */
	    public String postController(
						    		@RequestParam 
						    		Long id, 
						    		String nombre, 
						    		String apellidos,
						    		String email,
						    		String password,
						    		String[] pelis, 
						    		String[] aficiones,
						    		String[] musica) {
			
		
			//return ResponseEntity.ok(HttpStatus.OK);
			//return persona;
			/**Encriptar el password */
			String md5 = Util.getMD5(password);
			
			/** Se instancia una persona con los datos */
			Persona persona = new Persona(id, nombre, apellidos, email, md5, pelis, aficiones, musica);
			
			/** Se añade al mapa que contiene personas */
			Util.addPersonaToMap(md5, persona);
			
			/** Se inserta el registro en la BD */
			personaServiceI.crearPersona(persona);
			
			/** Se retornan los datos obtenidos y procesados de forma "amigable" usando etiquetas HTML */
			//pruebas etiquetas HTML de respuesta
			return "<h1>Datos Recibidos en el servidor y enviados de vuelta</h1>"
				  +	"<p id='pruebaJS'>Se ha encriptado el password, se ha creado un objeto Persona con estos datos y se ha añadido a un mapa que usa de clave el password y de valor a la persona.</p>"
				  //etiqueta prueba para respuesta JavaScript
				  + "<p id='demo'></p>"
				  //datos que vienen desde el formulario y saltos de línea
				  + "ID: " + id  
				  + "<br>Nombre: "+ nombre 
				  + "<br>Apellidos: " + apellidos
				  + "<br>email: " + email
				  + "<br>password: " + password
				  + "<hr>"
				  //pruebas encriptación password
				  + "<br>password MD5: ------------->" + Util.getMD5(password)
				  + "<br>password regenerated MD5: " + md5
				  + "<hr>"
				  //pruebas obtención de datos múltiples de un formulario
				  + "<br>Género de pelis: " + Arrays.toString(pelis)
				  + "<br>Aficiones tamaño checkbox array: " + aficiones.length + " Opciones seleccionadas: " + Arrays.toString(aficiones)
				  + "<br>Estilos musicales tamaño datalist array: " + musica.length + " Opción seleccionada: " + musica[0]
				  + "<hr>"
				  //prueba tamaño del mapa Personas
				  + "<br>Tamaño del mapa que contiene personas: " + Util.getPersonaMap().size()
				  + "<br>Cantidad de registros en la BD: " + personaServiceI.numeroPersonas()				  
				  + "<hr>"
				  + "<br>Persona creada, llamada al método toString del objeto: " + persona.toString()
				  //prueba link de vuelta
				  + "<br><br><a href ='file:///C:/springboot/com.spiral-arts-PostFormToRest/sendform_to_rest.html'>Volver</a>"
				  //prueba respuesta JS
				  + "<script>"
				  	+ "document.getElementById('pruebaJS').style.color='red';"
				  	+ "document.getElementById('demo').innerHTML='¡¡Hola Mundo!!';"
				  + "</script>";
		
	}
	/**
	 * Retorna el contenido de la tabla persona en una lista de tipo Persona
	 * 
	 * @return
	 */
	@GetMapping("/listar")
	public List<Persona> listarPersonas(){
		return personaServiceI.listarPersonas();
	}
	

}

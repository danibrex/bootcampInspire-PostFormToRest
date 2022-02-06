/**
 * 
 */
package com.spiralartsPostToRest.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.spiralartsPostToRest.models.Persona;

/**
 * @author Daniel
 *
 */
public class Util {
	
	private static Map <String, Persona> mapaPersonas = new HashMap<>();
	/**
	 * 
	 * Método que añade personas al mapa como valor con su password encriptado como clave.
	 * 
	 * @param password
	 * @param persona
	 */
	
	public static void addPersonaToMap(String password, Persona persona) {
		
		mapaPersonas.put(password, persona);
	}
	/**
	 * Método que devuelve el mapa donde guarda pass:Persona
	 * 
	 * @return Map<String, Persona>
	 */
	
	
	public static Map<String, Persona> getPersonaMap(){
		return mapaPersonas;
	}
	
	/**
	 * Encriptación hash/MD5 método que recibe un string y devuelve el resultado de la encriptación.
	 * 
	 * @param password
	 * @return String
	 */
	
	public static String getMD5(String password) {
			
			final byte[] initialBytes = password.getBytes();
			
			try {
				
				final MessageDigest md5Digest = MessageDigest.getInstance("MD5");
				md5Digest.reset();
				md5Digest.update(initialBytes);
				
				final byte msgDigest[] = md5Digest.digest();
				final StringBuffer hexString = new StringBuffer();
				
				for(final byte element : msgDigest) {
					final String hex = Integer.toHexString(0xFF & element);
					
					if (hex.length() == 1) {
	                    hexString.append('0');
	                }
					
	                hexString.append(hex);	
				}
				password = hexString + "";
				
	        } catch (final NoSuchAlgorithmException nsae) {
	            nsae.printStackTrace();
	        }
			
			return password;
		}


}

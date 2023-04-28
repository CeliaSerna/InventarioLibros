package com.cursoceat.services;

public interface Validacion {

	public default boolean isbnCorrecto(String isbn) {
		boolean isbnOk;
		if (isbn.length() != 13 || !isbn.startsWith("978")) {
			isbnOk = false;
		}else {
			isbnOk= true;
		}
		
		return isbnOk;
		
	}
	
	public default String primeraMayusNombre(String nombre) {
		
	    String nombreMay = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
			
	    return nombreMay;
		
		}

	public default String pasarPriMayus(String autor) {
		autor=autor.toLowerCase();//paso todo el texto a minisculas
		String[] arrayTexto=autor.split(" ");//si es mas de una palabra
		String temp="";//creo la variable que se formara por cada interacion
		for (int i=0; i <arrayTexto.length; i++) {
		arrayTexto[i]=arrayTexto[i].substring(0,1).toUpperCase() 
			+ arrayTexto[i].substring(1);
			
		temp+=arrayTexto[i] + " ";//lo acumulamos en temp
		}
		return temp.trim();//enviamos temp ya formateado 
		//y quitando espacios del principio y el final


	}

}

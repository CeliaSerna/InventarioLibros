package com.cursoceat.modell;

public final class Libros {

     static int id;
     private int idLibro;
     private String nombre;
     private String autor;
     private String isbn;
     private int cantidad;
	
    public Libros(String nombre, String autor, String isbn, int cantidad) {
		
		this.nombre = nombre;
		this.autor = autor;
		this.isbn = isbn;
		this.cantidad = cantidad;
		this.idLibro= ++id;
    
    }

	public Libros() {
		this.idLibro= ++id;
	
	}

	public int getIdLibro() {
		return idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public String getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getCantidad() {
		return cantidad;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
     



}

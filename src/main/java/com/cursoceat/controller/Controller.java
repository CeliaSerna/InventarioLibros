package com.cursoceat.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cursoceat.modell.Libros;
import com.cursoceat.services.Validacion;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet implements Validacion {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	///////ARRAY DE LIBROS///////////////////////////////
	List<Libros> listadoLibros = new ArrayList<Libros>();
	/////////////////////////////////////////////////////
	
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//cogemos los datos del formulario//
		String nombre = request.getParameter("nombre");
		String autor = request.getParameter("autor");
		String isbn = request.getParameter("isbn");
		String cantidad = request.getParameter("cantidad");
		//paso cantidad de string a int
		int cantidadInt = Integer.parseInt(cantidad) ;
		////////////////////////////////////
		String mensaje= null;
		
		if (nombre.isEmpty() || autor.isEmpty() || isbn.isEmpty() || cantidad.isEmpty() ) {
			
			mensaje = "Faltan campos por rellenar";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		//if isbn tiene formato correcto	
		}
		else if ( !isbnCorrecto(isbn) ) {
			mensaje="ISBN incorrecto";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
			
		}else {
		
			mensaje="Libro registrado correctamente";
			Libros miLibros = new Libros(primeraMayusNombre(nombre),pasarPriMayus(autor), isbn, cantidadInt);
			listadoLibros.add(miLibros);
			request.getSession().setAttribute("mensaje", mensaje);
			 
			request.getSession().setAttribute("libro", listadoLibros);
			response.sendRedirect("index.jsp");
			
		}
		
	}

}

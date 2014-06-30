package com.luis.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luis.modelo.Producto;
import com.luis.modelo.Usuario;

/**
 * Servlet implementation class VerDatos
 */
@WebServlet("/privado/verDatos")
public class VerDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	
	
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		Usuario us=(Usuario)sesion.getAttribute("miUsuario");
		ArrayList<Producto> productos=
				(ArrayList<Producto>) getServletContext().getAttribute("productos");
		
		PrintWriter salida=response.getWriter();
		
		salida.print("<html><head></head><body>");
		salida.print("Bienvenido "+us.getLogin()+"<br>");
		salida.print("Estos son nuestros productos:");
		salida.print("<table><tr><th>Producto</th><th>Precio</th></tr>");
		for (Producto pro : productos) {
			salida.print("<tr><td>"+pro.getNombre()+"</td><td>"+pro.getPrecio()+
					"</td></tr>");
				
		}
		/*
		 * Esto haria lo mismo que lo de arriba pero mas largo
		 * for (int i = 0; i < productos.size(); i++) {
			Producto pr=productos.get(i);
		}*/
		
		salida.print("</table></body></html>");
		
		
	}

}

















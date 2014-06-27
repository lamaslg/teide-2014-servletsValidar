package com.luis.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luis.modelo.Producto;
import com.luis.modelo.Usuario;

/**
 * Servlet implementation class VerDatos
 */
@WebServlet("/verDatos")
public class VerDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private ArrayList<Producto> productos;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	
	productos=new ArrayList<>();
	
	productos.add(new Producto("Telefono",200));
	productos.add(new Producto("Reloj",100));
	productos.add(new Producto("Tablet",150));
	productos.add(new Producto("Aire acondicionado",300));
	productos.add(new Producto("Portatil",1200));
	productos.add(new Producto("Monitor",50));
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario us=(Usuario)request.getAttribute("miUsuario");
		
		
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

















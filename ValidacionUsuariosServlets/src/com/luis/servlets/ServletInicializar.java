package com.luis.servlets;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.luis.modelo.Producto;
import com.luis.modelo.Usuario;

/**
 * Servlet implementation class ServletInicializar
 */
@WebServlet(value="/ServletInicializar",loadOnStartup=1)
public class ServletInicializar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	public void init() throws ServletException {
   		super.init();
   		HashMap<String, Usuario> usuarios;
   		usuarios=new HashMap<>();
		
		Usuario u1=new Usuario("luis","1234",true);
		usuarios.put("luis", u1);
		usuarios.put("pedro", new Usuario("pedro", "1234", false));
		usuarios.put("maria", new Usuario("maria", "1234", true));
		usuarios.put("eva", new Usuario("eva", "1234", false));
   	
   	
		getServletContext().setAttribute("usuarios", usuarios);
		
		ArrayList<Producto> productos;
		productos=new ArrayList<>();
		
		productos.add(new Producto("Telefono",200));
		productos.add(new Producto("Reloj",100));
		productos.add(new Producto("Tablet",150));
		productos.add(new Producto("Aire acondicionado",300));
		productos.add(new Producto("Portatil",1200));
		productos.add(new Producto("Monitor",50));
		
		getServletContext().setAttribute("productos", productos);
		
   	}

}

package com.luis.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.luis.modelo.Usuario;

/**
 * Servlet implementation class ServletValidar
 */
@WebServlet("/validarUsuario")
public class ServletValidar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	//Definimos un mapa con los usuarios de la aplicacion
	private HashMap<String, Usuario> usuarios;
	
	//Definimos el init para inicializar la lista de usuarios
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		usuarios=new HashMap<>();
		
		Usuario u1=new Usuario("luis","1234",true);
		usuarios.put("luis", u1);
		usuarios.put("pedro", new Usuario("pedro", "1234", false));
		usuarios.put("maria", new Usuario("maria", "1234", true));
		usuarios.put("eva", new Usuario("eva", "1234", false));
		
	
	}
	
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String login=request.getParameter("txtLogin");
   		String pwd=request.getParameter("txtPassword");
   		HttpSession sesion=request.getSession();
   		
   		//Contains key indica si tenemos la clave en el mapa
   		if(usuarios.containsKey(request.getParameter("txtLogin"))){
   			//Para obtener uso get
   			Usuario us=usuarios.get(login);
   			if(us.getPassword().equals(pwd) && us.isAutorizado()){
   				sesion.setAttribute("miUsuario", us);
   				
   				RequestDispatcher dsp=request.getRequestDispatcher("/privado/verDatos");
   				dsp.forward(request, response);
   				
   				return;
   				}
   			}
   		RequestDispatcher dsp2=request.getRequestDispatcher("/error.jsp");
   		dsp2.forward(request, response);
   		
	}

}



















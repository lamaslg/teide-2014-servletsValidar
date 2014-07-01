<%@page import="com.luis.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    try{
    		Cookie[] cookies=request.getCookies();
    
    		for(Cookie coo:cookies){
   	 		if(coo.getName().equals("usuario")){
    				Usuario us=new Usuario(coo.getValue(),"",true);
    				session.setAttribute("miUsuario", us);
    				RequestDispatcher dsp=request.getRequestDispatcher("/privado/verDatos");
    				dsp.forward(request, response);
    			
    			}
    	
    		}
       }catch(Exception ee){}
    
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="validarUsuario" method="post">
Login:<input type="text" name="txtLogin" id="txtLogin" /><br />
Password:<input type="password" name="txtPassword" id="txtPassword"><br />
Recuerdame<input type="checkbox" name="chRecordar" value="si"><br /> 
<input type="submit" value="Enviar"> 
</form>

</body>
</html>
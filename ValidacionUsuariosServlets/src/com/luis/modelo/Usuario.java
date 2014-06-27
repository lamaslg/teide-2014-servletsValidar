package com.luis.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	private String login,password;
	private boolean autorizado;
	
	
	public Usuario() {
	}
	
	public Usuario(String login, String password, boolean autorizado) {
		this.login = login;
		this.password = password;
		this.autorizado = autorizado;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAutorizado() {
		return autorizado;
	}
	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}
	

	
	
}

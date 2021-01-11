package com.spring.modelo;

public class Especialidad {
	private String codEsp;
	private String nomeEsp;
	
	@Override
	public String toString() {
		return "Especialidad [codEsp=" + codEsp + ", nomeEsp=" + nomeEsp + "]";
	}
	
	public String getCodEsp() {
		return codEsp;
	}
	public void setCodEsp(String codEsp) {
		this.codEsp = codEsp;
	}
	public String getNomeEsp() {
		return nomeEsp;
	}
	public void setNomeEsp(String nomeEsp) {
		this.nomeEsp = nomeEsp;
	}	
}

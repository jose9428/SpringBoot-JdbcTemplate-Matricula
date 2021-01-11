package com.spring.modelo;

public class Curso extends Especialidad{
	String codCur;
	String nomCur;
	double costo;
	int nroVac;
	
	@Override
	public String toString() {
		return "Curso [codCur=" + codCur + ", nomCur=" + nomCur + ", costo=" + costo + ", nroVac=" + nroVac + "]";
	}
	public String getCodCur() {
		return codCur;
	}
	public void setCodCur(String codCur) {
		this.codCur = codCur;
	}
	public String getNomCur() {
		return nomCur;
	}
	public void setNomCur(String nomCur) {
		this.nomCur = nomCur;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getNroVac() {
		return nroVac;
	}
	public void setNroVac(int nroVac) {
		this.nroVac = nroVac;
	}
	
	
}

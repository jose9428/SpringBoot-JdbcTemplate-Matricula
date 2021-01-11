package com.spring.modelo;

public class Alumno extends Curso{
	private String nroMatr;
	private String nomAlu;
	private String tipo;
	private double pago;
	
	@Override
	public String toString() {
		return "Alumno [nroMatr=" + nroMatr + ", nomAlu=" + nomAlu + ", tipo=" + tipo + ", pago=" + pago + ", codCur="
				+ codCur + ", nomCur=" + nomCur + ", costo=" + costo + ", nroVac=" + nroVac + "]";
	}
	public String getNroMatr() {
		return nroMatr;
	}
	public void setNroMatr(String nroMatr) {
		this.nroMatr = nroMatr;
	}
	public String getNomAlu() {
		return nomAlu;
	}
	public void setNomAlu(String nomAlu) {
		this.nomAlu = nomAlu;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	
	
}

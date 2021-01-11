package com.spring.modeloDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.modelo.Alumno;

@Repository
public class AlumnoDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Alumno> Listar(String cod){
		String sql = "select * from alumno where codcur = ?";
		List<Alumno> lista = jdbc.query(sql, new RowMapper<Alumno>() {

			@Override
			public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {
				Alumno a = new Alumno();
				a.setNroMatr(rs.getString(1));
				a.setCodCur(rs.getString(2));
				a.setNomAlu(rs.getString(3));
				a.setTipo(rs.getString(4));
				a.setPago(rs.getDouble(5));
				return a;
			}
			
		} , new Object[] {cod});
		return lista;
	}
	
	public int Anular(String nroMatr , String codCurs) {
		String sql = "{call sp_anularMatricula(?,?)}";
		int res = jdbc.update(sql , nroMatr , codCurs);
		return res;
	}
	
	public String nroMatricula() {
		String sql = "select lpad(ifnull(max(nroMat),0) + 1,6 ,'0') from alumno";
		
		String nro = jdbc.queryForObject(sql, String.class);
		
		return nro;
	}
	
	public int GuardarMatricula(Alumno a) {
		String sql = "{call sp_guardarMatricula(?,?,?,?,?)}";
		Object parametros[] = {a.getNroMatr() , a.getCodCur() , a.getNomAlu() , a.getTipo() , a.getPago()};
		int res = jdbc.update(sql , parametros);
		return res;
	}
	
}

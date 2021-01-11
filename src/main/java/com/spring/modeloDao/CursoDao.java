package com.spring.modeloDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.modelo.Curso;

@Repository
public class CursoDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Curso> Listar(String id){
		String sql = "select * from Curso where codesp = ?";
		Object []parametros = {id};
		List<Curso> lista = jdbc.query(sql,  new RowMapper<Curso>() {
			@Override
			public Curso mapRow( ResultSet rs,  int rowNum) throws SQLException {
				final Curso c = new Curso();
				c.setCodCur(rs.getString(1));
				c.setCodEsp(rs.getString(2));
				c.setNomCur(rs.getString(3));
				c.setCosto(rs.getDouble(4));
				c.setNroVac(rs.getInt(5));
				return c;
			}
		} , parametros);
		
		return lista;
	}
	
	public Curso ObtenerPorId(String id) {
		String sql = "select * from Curso where codcur = ?";
		Curso curso = jdbc.queryForObject(sql, new RowMapper<Curso>() {

			@Override
			public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
			    Curso c = new Curso();
				c.setCodCur(rs.getString(1));
				c.setCodEsp(rs.getString(2));
				c.setNomCur(rs.getString(3));
				c.setCosto(rs.getDouble(4));
				c.setNroVac(rs.getInt(5));
				return c;
			}
			
		} , id);
		return curso;
	}
}

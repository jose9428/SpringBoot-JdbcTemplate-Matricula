package com.spring.modeloDao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.modelo.Especialidad;


@Repository
public class EspecialidadDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List getAll() {
		String sql = "select * from TABESP";
		
		List lista = jdbc.queryForList(sql);
		return lista;
	}
	

	public List<Map<String, Object>> listar() {
		List<Map<String, Object>> lista = jdbc.queryForList("select * from TABESP");
		return lista;
	}
	
	public List<Especialidad> listar2(){
		String sql = "select * from TABESP";
		List<Especialidad> lista = jdbc.query(sql, new RowMapper<Especialidad>() {

			@Override
			public Especialidad mapRow(ResultSet rs, int rowNum) throws SQLException {
				Especialidad e = new Especialidad();
				e.setCodEsp(rs.getString(1));
				e.setNomeEsp(rs.getString(2));
				return e;
			}
		});
		
		return lista;
	}

}

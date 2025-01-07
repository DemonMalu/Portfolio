package com.divinita.SpringJDBCDivinita.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.divinita.SpringJDBCDivinita.model.Divinita;

@Repository
public class DivineRepo {

	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void add(Divinita divinita) {

		String sql = "INSERT INTO Divinita (divinita_id, nome, razza, abilita, equipaggiamento) VALUES (?, ?, ?, ?, ?)";
		int rows = template.update(sql, divinita.getId(), divinita.getNome(), divinita.getRazza(), divinita.getAbilita(), divinita.getEquipaggiamento());
		System.out.println(rows + "row/s affected");

	}
	
	public void delete(Divinita divinita) {

	    String sql = "DELETE FROM Divinita WHERE divinita_id = ?";
	    int rows = template.update(sql, divinita.getId());
	    System.out.println(rows + "row/s affected");

	}
	
	public void update(Divinita divinita) {

		String sql = "UPDATE Divinita SET nome = ?, razza = ?, abilita = ?, equipaggiamento = ? WHERE divinita_id = ?";
		int rows = template.update(sql, divinita.getNome(), divinita.getRazza(), divinita.getAbilita(), divinita.getEquipaggiamento(), divinita.getId());
		System.out.println(rows + "row/s affected");

	}
	
	public List<Divinita> view(int divinitaId) {

	    String sql = "SELECT * FROM Divinita WHERE divinita_id = ?";

	    RowMapper<Divinita> mapper = new RowMapper<Divinita>() {
	        @Override
	        public Divinita mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Divinita d = new Divinita();
	            d.setId(rs.getInt("divinita_id"));
	            d.setNome(rs.getString("nome"));
	            d.setRazza(rs.getString("razza"));
				d.setAbilita(rs.getString("abilita"));
				d.setEquipaggiamento(rs.getString("equipaggiamento"));
	            return d;
	        }
	    };

	    List<Divinita> divine = template.query(sql, mapper, divinitaId);

	    return divine;
	}
	
	public List<Divinita> findAll(){

		String sql = "SELECT * FROM Divinita";
		
		RowMapper<Divinita> mapper = new RowMapper<Divinita>() {
			
			@Override
			public Divinita mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Divinita d = new Divinita();
				d.setId(rs.getInt(1));
				d.setNome(rs.getString(4));
				d.setRazza(rs.getString(5));
				d.setAbilita(rs.getString(2));
				d.setEquipaggiamento(rs.getString(3));
				
				return d;
			}
		};
		
		List<Divinita> varie = template.query(sql, mapper);
		
		return varie;

	}

}

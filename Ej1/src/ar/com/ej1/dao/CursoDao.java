package ar.com.ej1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.ej1.DB.UConnection;
import ar.com.ej1.dto.Curso;

public class CursoDao {

	public List<Curso> getCursos(){
		List<Curso> cursos = new ArrayList<Curso>();
		String sql = "";
		sql += "SELECT ID, DESCRIPCION, PRECIO FROM CURSO";
		
		try {
			Connection con = UConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				cursos.add(new Curso(rs.getLong("id"),rs.getString("descripcion"),rs.getDouble("precio")));				;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return cursos;
		
	}
	
}

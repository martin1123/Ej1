package ar.com.ej1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.ej1.DB.UConnection;
import ar.com.ej1.dto.Inscripcion;

public class InscripcionDao {

	public Long generarInscripcion(Inscripcion insc){
		Long id = 0l;
		
		String s1 = "INSERT INTO INSCRIPCION(ID,NOMBRE,TELEFONO,ID_CURSO,ID_FORMA_DE_PAGO) VALUES (?,?,?,?,?)";
		String s2 = "SELECT MAX(ID) FROM INSCRIPCION";

		try {
			Connection con = UConnection.getConnection();
			PreparedStatement pstm1 = con.prepareStatement(s1);
			PreparedStatement pstm2 = con.prepareStatement(s2);
			
			pstm1.setInt(1, 1);
			pstm1.setString(2, insc.getNombre());
			pstm1.setString(3, insc.getTelefono());
			pstm1.setLong(4, insc.getIdCurso());
			pstm1.setLong(5, insc.getIdFormaDePago());
			
			if(pstm1.executeUpdate() != 1){
				throw new RuntimeException("Error al generar inscripcion");
			}
			
			ResultSet rs = pstm2.executeQuery();
			
			if(rs.next()){
				id = rs.getLong(1);
			}else{
				throw new RuntimeException("Error al generar inscripcion");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return id;
	}
}

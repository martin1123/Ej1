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
		
		String s1 = "INSERT INTO INSCRIPCION(NOMBRE,TELEFONO,ID_CURSO,ID_FORMA_DE_PAGO) VALUES (?,?,?,?)";
		String s2 = "SELECT MAX(ID) FROM INSCRIPCION";

		try {
			Connection con = UConnection.getConnection();
			PreparedStatement pstm1 = con.prepareStatement(s1);
			PreparedStatement pstm2 = con.prepareStatement(s2);
			
			pstm1.setString(0, insc.getNombre());
			pstm1.setString(1, insc.getTelefono());
			pstm1.setLong(2, insc.getIdCurso());
			pstm1.setLong(3, insc.getIdFormaDePago());
			
			if(pstm1.executeUpdate() != 1){
				throw new RuntimeException("Error al generar inscripcion");
			}
			
			ResultSet rs = pstm2.executeQuery();
			
			if(rs.next()){
				id = rs.getLong(0);
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

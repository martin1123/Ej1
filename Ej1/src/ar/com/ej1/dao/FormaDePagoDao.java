package ar.com.ej1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.ej1.DB.UConnection;
import ar.com.ej1.dto.FormaDePago;

public class FormaDePagoDao {
	public List<FormaDePago> getFormasDePago(){
		List<FormaDePago> formasDePago = new ArrayList<FormaDePago>();
		String sql = "";
		sql += "SELECT ID, DESCRIPCION, RECARGO FROM FORMA_DE_PAGO";
		
		try {
			Connection con = UConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				formasDePago.add(new FormaDePago(rs.getLong("id"),rs.getString("descripcion"),rs.getDouble("recargo")));				;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return formasDePago;
		
	}
}

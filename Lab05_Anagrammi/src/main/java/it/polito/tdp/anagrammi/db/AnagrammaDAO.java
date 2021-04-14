package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {
		boolean corretta;
		String sql = "SELECT nome "
				+ "FROM parola "
				+ "WHERE nome = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				corretta = true;
			else
				corretta = false;
			
			rs.close();
			st.close();
			conn.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return corretta;
	}
}

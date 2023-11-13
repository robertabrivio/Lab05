package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnagrammaDAO {
	
	public boolean isCorrect(String parola) throws SQLException {
		List<String> parole = new ArrayList<>();
		boolean corretta = false;
		String sql = "SELECT nome "
				+ "FROM parola "
				+ "WHERE nome = ?";
		
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,parola);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				parole.add(rs.getString("nome"));
			}
			rs.close();
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Errore di connessione al database", e);
		}
		for(String s: parole) {
			if(s.compareTo(parola)==0)
				corretta = true;
		}
		return corretta;
		
	}

}

package it.polito.tdp.anagrammi.DAO;

import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) {
		AnagrammaDAO adao = new AnagrammaDAO();
		
		boolean var=false;
		try {
			var = adao.isCorrect("casa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(var);
	}

}

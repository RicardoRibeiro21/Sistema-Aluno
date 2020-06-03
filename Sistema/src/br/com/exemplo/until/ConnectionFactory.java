package br.com.exemplo.until;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	static Connection conexao = null;

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String login = "root";
			String senha = "";
			String url = "jdbc:mysql://localhost:3308/sistemaaluno?serverTimezone=UTC";
			conexao = DriverManager.getConnection(url,login,senha);
			return conexao;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}
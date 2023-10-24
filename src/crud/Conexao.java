package crud;

public class Conexao {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/faculdade";
	private static String user = "caique";
	private static String password = "12345678";
	
	public static String getJdbcURL() {
		return jdbcURL;
	}
	
	public static String getUser() {
		return user;
	}
	
	public static String getPassword() {
		return password;
	}
}

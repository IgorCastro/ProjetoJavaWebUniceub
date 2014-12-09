/* Classe responsavel por realizar  a conexão com o Banco
 * Necessita do conector do banco .jar
 * 
 */

package projetotava.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexao{
	
	
	
	public static Connection getConnection(){
		Connection con = null;//"Ponteiro" para o banco de dados
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");//Carrega o drive na memoria para o uso do Servidor ApacheTomCat
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Conecta com o banco, usando o Drive, caminho, porta , nome do banco ,usuario principal e senha do BD
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Projeto_Java_HTML","root","");
			System.out.println("Conectado com sucesso");
		} catch (SQLException e) {


			System.out.println("Não pode conectar : " + e.getMessage());
		}
		return con;
	}
	
	
	
}
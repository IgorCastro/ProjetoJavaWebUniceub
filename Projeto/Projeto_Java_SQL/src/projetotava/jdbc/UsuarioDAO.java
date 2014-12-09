/*Classe de inserção  e alteração dos dados no banco
 * Recebe os valosres da Classe USuario
 *
 * Tudo que se refere aos atrubutos do banco, o UsuarioDAO é responsavel
 * 
 * DAO =>Padrão de projeto
 * DAO(Data Access Object)=Objeto de acesso a dados =>  é um padrão para persistência de dados que 
 * permite separar regras de negócio das regras de acesso a banco de dados. Numa aplicação que 
 * utilize a arquitetura MVC, todas as funcionalidades de bancos de dados, tais como obter 
 * as conexões, mapear objetos Java para tipos de dados SQL ou executar comandos SQL,
 *  devem ser feitas por classes DAO.
 *  
 *  Para cada tabela no bd, criasse um DAO
 */

package projetotava.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import projetotava.entidades.Usuario;

public class UsuarioDAO {
	
	
	private Connection con = Conexao.getConnection();
	
	//Metodo resposavel em cadastras o usuario no BD, recebe os valores da Classe Usuario
	public void cadastrar(Usuario usuario){
		//Montar SQL
		String sql = "INSERT INTO USUARIO (nome, login, senha) values (?,?,md5(?))";
		try{
			java.sql.PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1,usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3,usuario.getSenha());
			
			preparador.execute();
			preparador.close();
				
			System.out.println("Cadastrado com sucesso");
			
		}catch(SQLException e ){
			e.printStackTrace();
			
		}
				
	}

	
	public void alterar (Usuario usuario){
		//Montar SQL
		String sql = "UPDATE USUARIO SET nome=?, login=?, senha=md5(?) WHERE id=?";
		try{
			java.sql.PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1,usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3,usuario.getSenha());
			preparador.setInt(4,usuario.getId());
			
			
			preparador.execute();
			preparador.close();
				
			System.out.println("Alterado  com sucesso");
			
		}catch(SQLException e ){
			e.printStackTrace();}
			
		}
		
		
		public void exluir (Usuario usuario){
			//Montar SQL
			String sql = "DELETE FROM USUARIO WHERE id=?";
			try{
				java.sql.PreparedStatement preparador = con.prepareStatement(sql);
				
				preparador.setInt(1,usuario.getId());
				
				
				preparador.execute();
				preparador.close();
					
				System.out.println("Excluido  com sucesso");
				
			}catch(SQLException e ){
				e.printStackTrace();}
				
			}
		
		public void salva (Usuario usuario){
			
			if(usuario.getId() != null && usuario.getId()!=0 ){
				alterar(usuario);
					}else{
						cadastrar(usuario);
					}
			
		}
	
			public ArrayList<Usuario> buscarTodos(){
				//Montar SQL
				String sql = "SELECT * FROM USUARIO ";
				ArrayList<Usuario> lista = new ArrayList<Usuario>();
				
				try{
					java.sql.PreparedStatement preparador = con.prepareStatement(sql);
										
					ResultSet resultado =  preparador.executeQuery();
							
										
					while(resultado.next()){
						
						Usuario usu = new Usuario(); // Obejeto para recuperação dos dados
						
						usu.setId(resultado.getInt("id")); // Valor da coluna id
						usu.setNome(resultado.getString("nome"));// Valor da coluna nome
						usu.setLogin(resultado.getString("login"));// Valor da coluna login	
						usu.setSenha(resultado.getString("senha"));// Valor da coluna senha
						lista.add(usu);
						
					}
					
					preparador.close();
						
					System.out.println("Busca realizada  com sucesso");
					
				}catch(SQLException e ){
					e.printStackTrace();
					
				}
				
				return lista;
	}
			
			public Usuario buscarPorID(Integer id){
				String sql = "SELECT * FROM Usuario WHERE ID=?";
				Usuario usuario = null;
				try {
					PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
					preparador.setInt(1, id);
					
					ResultSet resultado = preparador.executeQuery();
					
					if(resultado.next()){
				    usuario = new Usuario();
					usuario.setId(resultado.getInt("id"));
					usuario.setNome(resultado.getString("nome"));
					usuario.setLogin(resultado.getString("login"));
					usuario.setSenha(resultado.getString("senha"));;
									
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return usuario;
				
			}
			/**
			 * Buscar por login e senha de usuario no BD
			 * @param usuario : Objeto com login e senha a ser consultado no bd
			 * @return Null quando não encontrar ou um ponteiro a um objeto usuario completo quando encontra
			 */

			
			public ArrayList<Usuario> buscarPorNome(String nome){
				String sql = "SELECT * FROM Usuario WHERE nome like =?";
				ArrayList<Usuario> lista = new ArrayList<Usuario>();
				try {
					PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
					preparador.setString(1, "%" + nome + "%" );
				
					ResultSet resultado = preparador.executeQuery();
					
					while(resultado.next()){
				    Usuario usuario = new Usuario();
					usuario.setId(resultado.getInt("id"));
					usuario.setNome(resultado.getString("nome"));
					usuario.setLogin(resultado.getString("login"));
					usuario.setSenha(resultado.getString("senha"));;
					lista.add(usuario);				
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return lista;
				
			}
			
			public Usuario autencicar(Usuario usuario){
				String sql = "SELECT * FROM Usuario WHERE login = ? and senha = md5(?)";
				Usuario usuarioRetorno = null;
				try {
					PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
					preparador.setString(1, usuario.getLogin());
					preparador.setString(2, usuario.getSenha());
					
					ResultSet resultado = preparador.executeQuery();
					
					if(resultado.next()){
					usuarioRetorno = new Usuario();
					usuarioRetorno.setId(resultado.getInt("id"));
					usuarioRetorno.setNome(resultado.getString("nome"));
					usuarioRetorno.setLogin(resultado.getString("login"));
					usuarioRetorno.setSenha(resultado.getString("senha"));;
									
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return usuarioRetorno;
}
			public boolean existeUsuario(Usuario usuario){
				String sql = "SELECT * FROM Usuario WHERE login = ? and senha = md5(?)";
				
				try {
					PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
					preparador.setString(1, usuario.getLogin());
					preparador.setString(2, usuario.getSenha());
					
					ResultSet resultado = preparador.executeQuery();
					
					return resultado.next();
					
						
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}

		
}



		
		


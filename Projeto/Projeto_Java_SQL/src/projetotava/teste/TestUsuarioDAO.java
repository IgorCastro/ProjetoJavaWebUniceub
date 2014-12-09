/*Classe usada para testar os metodos do UsarioDao
 * 
 */

package projetotava.teste;

import java.util.List;

import projetotava.entidades.Usuario;
import projetotava.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		testeCadastrar();
		//testeAlterar();
		//testExcluir();
		//testBuscarTodos();
		//testeAutenticar();
		//testeBuscarPorId();
	}

	private static void testeCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("casa");
		usu.setLogin("casa");
		usu.setSenha("casa");
		
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastrar(usu);
	}
	
	private static void testeAlterar(){
		
		Usuario usu = new Usuario();
		usu.setId(3);
		usu.setNome("alterar");
		usu.setLogin("alterar");
		usu.setSenha("alterar123");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.alterar(usu);
		
		
	}
private static void testExcluir(){
		
		Usuario usu = new Usuario();
		usu.setId(2);
		
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.exluir(usu);
	
	

}

private static void testBuscarTodos(){
	
	UsuarioDAO usuDao = new UsuarioDAO();
	List<Usuario> listaResultado =  usuDao.buscarTodos();
	
	
	for(Usuario u: listaResultado){
		
		System.out.println(" ID: " + u.getId() + " , Nome :  " + u.getNome()+ " , Login :  " + u.getLogin() + " , Senha :  " + u.getSenha());
		
	}


}

	public static void testeAutenticar(){
		Usuario usuario = new Usuario();
		usuario.setLogin("teste2");
		usuario.setSenha("12345");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println (usuarioDAO.autencicar(usuario));
		
		
		
	}

	public static void testeBuscarPorId(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuRetorno = usuarioDAO.buscarPorID(3);
		if(usuRetorno != null);
			System.out.println("nome : " + usuRetorno.getNome());
		
	}
	
}


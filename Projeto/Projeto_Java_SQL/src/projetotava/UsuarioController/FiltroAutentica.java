/*
 * Classe que faz o controle do  de acesso a todas as 
 * outras paginas.
 */

package projetotava.UsuarioController;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, //requisão que ativa o filtro
				DispatcherType.FORWARD //requisão que ativa o filtro
		}
					, urlPatterns = { "/*" }) // Diz que todas as paginas podem acessar o filtro
public class FiltroAutentica implements Filter {

    
    public FiltroAutentica() {
    	
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//Casting do HttpServlet Request
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		
		String url = httpServletRequest.getRequestURI();
		
		
		//Capturando sessão
		HttpSession sessao = httpServletRequest.getSession();
		if(sessao.getAttribute("usuLogado")!= null || url.lastIndexOf("login.html")>-1 || url.lastIndexOf("autcontroller.do")>-1) {
				
		chain.doFilter(request, response);//Permite o fluxo da req
		} else {
			// redireciona para o login		
			((HttpServletResponse) response).sendRedirect("login.html");
			
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

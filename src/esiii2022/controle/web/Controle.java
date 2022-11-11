package esiii2022.controle.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esiii2022.controle.IFachada;
import esiii2022.controle.impl.Fachada;
import esiii2022.dominio.EntidadeDominio;

/**
 * Servlet implementation class ControleCliente
 */
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, IViewHelper> vhs = new HashMap<String, IViewHelper>();
	private Map<String, ICommand> cmds = new HashMap<String, ICommand>();
	
    /**
     * Default constructor. 
     */
    public Controle() {
    	vhs.put("/ESIII_2022/SalvarCliente", new ClienteVH());
    	vhs.put("/ESIII_2022/SalvarFornecedor", new FornecedorVH());
    	
    	
    	cmds.put("Salvar", new SalvarCommand());
    	cmds.put("Alterar", new AlterarCommand());
    	cmds.put("Consultar", new ConsultarCommand());
    	cmds.put("Excluir", new ExcluirCommand());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);	
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		
		String uri = request.getRequestURI();
		String operacao = request.getParameter("operacao");
	
		
		IViewHelper vh = vhs.get(uri);	
		
		EntidadeDominio entidade = vh.getEntidade(request);
		
		ICommand cmd = cmds.get(operacao);
		
		Object msg = cmd.executar(entidade);
		
		vh.setEntidade(response, request, msg);
		
	}

}

package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import model.Produto;


/**
 * Servlet implementation class InserirCategoria
 */
@WebServlet(urlPatterns = "/inserirProduto")
public class InserirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProdutoDAO dao = new ProdutoDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
        double preco = Double.parseDouble(request.getParameter("preco"));
		Integer categoria = Integer.parseInt(request.getParameter("categoria"));

		Produto produto = new Produto();		
		produto.setNome(nome);		
		produto.setPreco(preco);
        produto.setCodCategoria(categoria);

		String retorno = dao.inserir(produto);
		
		if (retorno.equals("sucesso")) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Nao foi possivel inserir o produto!</h2>");
			out.print("<br");
			out.print("<a href = 'index.jsp'> Voltar </a>");
			out.print("</html>");
		}				
	}
	
}

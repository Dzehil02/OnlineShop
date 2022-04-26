package by.iba.resources;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.iba.entities.Product;
import by.iba.services.ProductService;

@WebServlet("/catalog/product")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 7504138943952052052L;

	private ProductService service;

	public ProductServlet() {
		super();
		service = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("id");
		Product product = service.getProduct(Integer.parseInt(productId));

		String productJson = new Gson().toJson(product);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(productJson);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Gson().fromJson(request.getReader(), Product.class);
		service.createProduct(product);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Gson().fromJson(request.getReader(), Product.class);
		service.updateProduct(product);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Gson().fromJson(request.getReader(), Product.class);
		service.deleteProduct(product);
	}

}

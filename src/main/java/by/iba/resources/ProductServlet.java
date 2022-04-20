package by.iba.resources;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.iba.entities.Product;
import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;
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

		if (productId != null) {
			Product product = service.getProduct(Integer.parseInt(productId));
			request.setAttribute("product", product);
		}
		request.setAttribute("brand", Brand.values());
		request.setAttribute("category", Category.values());
		request.getRequestDispatcher("/product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Gson().fromJson(request.getReader(), Product.class);

		service.createProduct(product);

		response.sendRedirect("/catalog");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Gson().fromJson(request.getReader(), Product.class);

		service.updateProduct(product);

		response.sendRedirect("/catalog");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Gson().fromJson(request.getReader(), Product.class);

		service.deleteProduct(product);

		response.sendRedirect("/catalog");
	}

}

package by.iba.resources;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.iba.entities.Catalog;
import by.iba.entities.Product;
import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;
import by.iba.utils.FileUtils;

@WebServlet("/catalog/product")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 7504138943952052052L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("id");

		if (productId != null) {
			Catalog catalog = FileUtils.readCatalog(this.getClass().getClassLoader().getResource("catalog.bin").getPath());
			Product product = catalog.getProductById(Integer.parseInt(productId)).get();
			request.setAttribute("product", product);
		}

		request.getRequestDispatcher("/product.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Category category = Category.valueOf(request.getParameter("category"));
		Brand brand = Brand.valueOf(request.getParameter("brand"));
		String model = request.getParameter("model");
		String count = request.getParameter("count");

		Catalog catalog = FileUtils.readCatalog(this.getClass().getClassLoader().getResource("catalog.bin").getPath());
		int newProductId = catalog.getProductList().get(catalog.getProductList().size()-1).getId() + 1;
		catalog.addProduct(new Product(newProductId, category, brand, model, Integer.parseInt(count)));
		
		FileUtils.writeCatalog(catalog, this.getClass().getClassLoader().getResource("catalog.bin").getPath());
		request.setAttribute("productList", catalog.getProductList());
		request.getRequestDispatcher("/catalog.jsp").forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Product newProduct = new Gson().fromJson(request.getReader(), Product.class);
		Catalog catalog = FileUtils.readCatalog(this.getClass().getClassLoader().getResource("catalog.bin").getPath());
		
		Product originalProduct = catalog.getProductById(newProduct.getId()).get();
		int originalProductIndex = catalog.getProductList().indexOf(originalProduct);
		catalog.getProductList().set(originalProductIndex, newProduct);

		FileUtils.writeCatalog(catalog, this.getClass().getClassLoader().getResource("catalog.bin").getPath());
		request.setAttribute("productList", catalog.getProductList());
		request.getRequestDispatcher("/catalog.jsp").forward(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int productId = Integer.parseInt(request.getParameter("id"));
		Catalog catalog = FileUtils.readCatalog(this.getClass().getClassLoader().getResource("catalog.bin").getPath());
		catalog.removeProduct(productId);
		FileUtils.writeCatalog(catalog, this.getClass().getClassLoader().getResource("catalog.bin").getPath());
		request.setAttribute("productList", catalog.getProductList());
		request.getRequestDispatcher("/catalog.jsp").forward(request, response);
	}

}

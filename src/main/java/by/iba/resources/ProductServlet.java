package by.iba.resources;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import by.iba.entities.Catalog;
import by.iba.entities.Product;
import by.iba.entities.enums.Brand;
import by.iba.entities.enums.Category;
import by.iba.utils.FileUtils;

@WebServlet("/catalog/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String count = request.getParameter("count");
		System.out.println(category + " " + brand + " " + model + " " + count + " ");
		Catalog catalog = FileUtils.readCatalog(this.getClass().getClassLoader().getResource("catalog.bin").getPath());
		int lastId = catalog.getProductList().size()+1;
		catalog.addProduct(new Product(lastId+1, Category.getCategory(category), Brand.getBrand(brand), model, Integer.parseInt(count)));
		FileUtils.writeCatalog(catalog, this.getClass().getClassLoader().getResource("catalog.bin").getPath());
		request.setAttribute("productList", catalog.getProductList());
		request.getRequestDispatcher("/catalog.jsp").forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Catalog catalog = FileUtils.readCatalog(this.getClass().getClassLoader().getResource("catalog.bin").getPath());
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = catalog.getProductById(productId).get();
		System.out.println(request.getReader().readLine());
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int removedId = Integer.parseInt(request.getParameter("id"));
			Catalog catalog = FileUtils.readCatalog(this.getClass().getClassLoader().getResource("catalog.bin").getPath());
			catalog.removeProduct(removedId);
			System.out.println(catalog.getProductList());
			FileUtils.writeCatalog(catalog, this.getClass().getClassLoader().getResource("catalog.bin").getPath());
			request.setAttribute("productList", catalog.getProductList());
			request.getRequestDispatcher("/catalog.jsp").forward(request, response);
	}

}

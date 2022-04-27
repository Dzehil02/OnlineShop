package by.iba.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import by.iba.entities.Product;
import by.iba.services.ProductService;

@Path("/catalog/product")
public class ProductResourse {
	
	private ProductService service = new ProductService();
	
	@GET
	@Path("/{id}")
	public Response getProduct(@PathParam("id") String id) {
		Product product = service.getProductById(Integer.parseInt(id));
		return Response.status(200).entity(product).build();
	}

	@POST
	public Response createProduct(Product product) {
		service.createProduct(product);
		return Response.status(201).entity("Продукт " + product + " добавлен").build();

	}
	
	@PUT
	public Response updateProduct(Product product) {
		//product.setId(Integer.valueOf(id));
		service.updateProduct(product);
		return Response.status(204).entity("Продукт обновлён: " + product).build();
	}
	
	@DELETE
	public Response removeProduct(Product product) {
		service.deleteProduct(product);
		return Response.status(204).entity("Продукт удалён: " + product).build();
	}
}

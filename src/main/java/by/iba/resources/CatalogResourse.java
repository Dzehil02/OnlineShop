package by.iba.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import by.iba.entities.Product;
import by.iba.services.CatalogService;

@Deprecated
@Path("/catalog")
public class CatalogResourse {

	private CatalogService service = new CatalogService();

	@GET
	public Response getCatalog() {
		ArrayList<Product> catalog = service.getCatalog();
		return Response.status(200).entity(catalog).build();
	}

}

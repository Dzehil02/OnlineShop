package by.iba.entities.ids;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItemId implements Serializable {

	private static final long serialVersionUID = 3081490489686775615L;
	private int cart;
	private int product;
	
}

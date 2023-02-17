import React from "react";
import { Button } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import { Link } from "react-router-dom";

const Product = (props) => {
  
  return (
    <tr>
      <td>{props.item.id}</td>
      <td>{props.item.category}</td>
      <td>{props.item.brand}</td>
      <td>{props.item.model}</td>
      <td>{props.item.count}</td>
      <td>{props.item.price}</td>
      <td>
        <Button variant="warning"><Link to={`/product/${props.item.id}`}>Изменить продукт</Link></Button>
      </td>
      <td>
        <Button variant="danger" onClick={() => props.deleteProduct(props.item)}>Удалить продукт</Button>
      </td>
    </tr>
  );
};

export default Product;

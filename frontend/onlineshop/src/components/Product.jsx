import React from "react";
import { Button } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

const Product = (props) => {
  return (
    <tr>
      <td>{props.item.id}</td>
      <td>{props.item.category}</td>
      <td>{props.item.brand}</td>
      <td>{props.item.model}</td>
      <td>{props.item.count}</td>
      <td>
        <Button variant="warning">Изменить продукт</Button>
      </td>
      <td>
        <Button variant="danger">Удалить продукт</Button>
      </td>
    </tr>
  );
};

export default Product;

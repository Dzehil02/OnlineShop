import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Product from "./ProductRow";
import { Table } from "react-bootstrap";

const ProductList = (props) => {

  return (

        <Table striped bordered hover variant="light">
          <thead>
            <tr>
              <th>ID</th>
              <th>Категория</th>
              <th>Брэнд</th>
              <th>Модель</th>
              <th>Количество</th>
              <th>Цена</th>
              <th>Изменение продукта</th>
              <th>Удаление продукта</th>
            </tr>
          </thead>
          <tbody>
          {props.products.map((item) => (
            <Product item={item} key={item.id} deleteProduct={props.deleteProduct} />
          ))}
        </tbody>
        </Table>
  );
};

export default ProductList;

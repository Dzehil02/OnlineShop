import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Product from "./Product";

const ProductList = () => {

  const [catalogState, setCatalogState] = useState([]);

  const deleteProduct = async function (item) {
    await fetch("/catalog/product", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json;charset=utf-8",
      },
      body: JSON.stringify(item)
    });
    await setCatalogState(catalogState.filter(product => product !== item)); //поменять на get catalog
  }

  useEffect(() => {
    fetch('/catalog')
    .then(response => response.json())
    .then(data => {
      setCatalogState(data);
    });
  }, [setCatalogState]);

  return (
    <tbody>
      {catalogState.map((item) => (
        <Product item={item} key={item.id} deleteProduct={deleteProduct}/>
      ))}
    </tbody>
  );
};

export default ProductList;

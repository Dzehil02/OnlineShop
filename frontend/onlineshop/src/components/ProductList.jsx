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
      body: JSON.stringify({
        "category": item.category,
        "brand": item.brand,
        "model": item.model,
        "count": item.count,
      })
    });
    await setCatalogState(catalogState.filter(product => product !== item));
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

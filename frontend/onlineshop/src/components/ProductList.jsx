import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Product from "./Product";
import { Button } from "react-bootstrap";

const ProductList = () => {
  // const arr = [
  //   {
  //     id: 1,
  //     category: "COMPUTERS",
  //     brand: "NOTEBOOK",
  //     model: "HP Pavilion",
  //     count: 14,
  //   },
  //   {
  //     id: 2,
  //     category: "ELECTRONICS",
  //     brand: "TV",
  //     model: "LG",
  //     count: 7,
  //   },
  //   {
  //     id: 3,
  //     category: "TECHNIQUE",
  //     brand: "FRIDGE",
  //     model: "Samsung",
  //     count: 4,
  //   },
  //   {
  //     id: 4,
  //     category: "INSTRUMENTS",
  //     brand: "DRILL",
  //     model: "Bosh",
  //     count: 5,
  //   },
  //   {
  //     id: 5,
  //     category: "TECHNIQUE",
  //     brand: "OVEN",
  //     model: "Gefest",
  //     count: 9,
  //   },
  // ];

  const [catalogState, setCatalogState] = useState([]);

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
        <Product item={item} key={item.id} />
      ))}
    </tbody>
  );
};

export default ProductList;

import React, { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import { defaultProduct } from "../utils/constants";

function ProductPage() {

  const history = useNavigate();
  const [product, setProduct] = useState(defaultProduct);
  const { id } = useParams();

  useEffect(() => {
    if (id > 0) {
      fetch(`/catalog/product/${id}`)
        .then((res) => res.json())
        .then((data) => setProduct(data))
        .catch(() => {
          console.log("Продукт не найден");
          history("/notfound");
        });
    }
  }, [id, history]);

  const addProduct = async function () {
    await fetch("/catalog/product", {
      method: "POST",
      headers: {
        "Content-Type": "application/json;charset=utf-8",
      },
      body: JSON.stringify(product),
    });
    await history("/catalog");
  };

  const changeProduct = async function () {
    await fetch("/catalog/product", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json;charset=utf-8",
      },
      body: JSON.stringify(product),
    });
    await history("/catalog");
  };

  return (
    <>
      {id > 0 ? <h1>Изменение продукта</h1> : <h1>Добавление продукта</h1>}

      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          flexDirection: "column",
        }}
      >
        <Form.Label>Категория</Form.Label>
        <Form.Select
          style={{ width: "200px" }}
          value={product.category}
          onChange={(e) => {
            setProduct((product) => ({
              ...product,
              category: e.target.value,
            }));
          }}
        >
          <option value="ELECTRONICS">ELECTRONICS</option>
          <option value="COMPUTERS">COMPUTERS</option>
          <option value="TECHNIQUE">TECHNIQUE</option>
          <option value="INSTRUMENTS">INSTRUMENTS</option>
        </Form.Select>
        <Form.Label>Брэнд</Form.Label>
        <Form.Select
          style={{ width: "200px" }}
          value={product.brand}
          onChange={(e) => {
            setProduct((product) => ({
              ...product,
              brand: e.target.value,
            }));
          }}
        >
          <option value="PHONE">PHONE</option>
          <option value="TV">TV</option>
          <option value="AUDIO">AUDIO</option>
          <option value="PHOTO">PHOTO</option>
          <option value="FRIDGE">FRIDGE</option>
          <option value="SCREWDRIVER">SCREWDRIVER</option>
          <option value="OVEN">OVEN</option>
        </Form.Select>
        <Form.Label>Модель</Form.Label>
        <Form.Control
          value={product.model}
          onChange={(e) => {
            setProduct((product) => ({
              ...product,
              model: e.target.value,
            }));
          }}
          style={{ width: "200px" }}
          type="text"
          placeholder="Model"
        />
        <Form.Label>Количество</Form.Label>
        <Form.Control
          value={product.count}
          onChange={(e) => {
            setProduct((product) => ({
              ...product,
              count: +e.target.value,
            }));
          }}
          style={{ width: "200px" }}
          type="text"
          placeholder="Count"
        />
        <Form.Label>Цена</Form.Label>
        <Form.Control
          value={product.price}
          onChange={(e) => {
            setProduct((product) => ({
              ...product,
              price: +e.target.value,
            }));
          }}
          style={{ width: "200px" }}
          type="text"
          placeholder="Price"
        />
        {id > 0 ? (
          <Button
            variant="warning"
            onClick={changeProduct}
            style={{ marginTop: "10px" }}
          >
            Изменить
          </Button>
        ) : (
          <Button
            variant="success"
            onClick={addProduct}
            style={{ marginTop: "10px" }}
          >
            Добавить
          </Button>
        )}
      </div>
      {id > 0 ? <div>Продукт с ID: {id}</div> : <div>Добавьте продукт</div>}
    </>
  );
}

export default ProductPage;

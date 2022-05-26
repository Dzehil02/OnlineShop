import React, { useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/HomePage";
import Catalog from "./pages/CatalogPage";
import NotFoundPage from "./pages/NotFoundPage";
import Layout from "./components/Layout";
import ProductPage from "./pages/ProductPage";


function App() {

// ================= Запрос с категориями для проверки ===================
useEffect(() => {
  fetchCategorized()
}, []);

async function fetchCategorized() {
  const categorized = await fetch("/catalog/categorized", {
    headers: {
      "Content-Type": "application/json;charset=utf-8",
      "criteria": "{category: COMPUTERS, brand: PHOTO}"
    }
  });
  const data = await categorized.json();
  console.log(data)
}
// ================= Запрос с категориями для проверки ===================

  return (
    <>
      <Routes>
        <Route path="/" element={<Layout/>}>
        <Route index element={<Home />} />
        <Route path="catalog" element={<Catalog />} />
        <Route path="product" element={<ProductPage />} />
        <Route path="product/:id" element={<ProductPage />} />
        <Route path="*" element={<NotFoundPage />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;

import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Catalog from "./pages/Catalog";
import NotFoundPage from "./pages/NotFoundPage";
import Layout from "./components/Layout";
import ProductPage from "./pages/ProductPage";


function App() {
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

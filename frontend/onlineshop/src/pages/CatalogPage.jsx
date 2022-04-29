import ProductList from "../components/ProductList";
import { useEffect, useState } from "react";
import { Button, Spinner } from "react-bootstrap";
import { Link } from "react-router-dom";

function Catalog() {

  const [catalogState, setCatalogState] = useState([]);
  const [isCatalogLoading, setIsCatalogLoading] = useState(false);

  const deleteProduct = async function (item) {
    await fetch("/catalog/product", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json;charset=utf-8",
      },
      body: JSON.stringify(item),
    });
    await setCatalogState(catalogState.filter((product) => product !== item)); //поменять на get catalog
  };

  useEffect(() => {
    fetchCatalog()
  }, []);

  async function fetchCatalog() {
    setIsCatalogLoading(true);
    setTimeout(async() => {
    const products = await fetch("/catalog");
    const data = await products.json();
    setCatalogState(data);
    setIsCatalogLoading(false);
    }, 500);
   
  }

  return (
    <div className="App">
      <h1>Online Shop React</h1>
      <h2>Каталог</h2>
      {isCatalogLoading
        ? <div style={{ textAlign: "center" }}>
            <h1>Идёт загрузка каталога</h1>
            <Spinner animation="border" role="status"><span className="visually-hidden">Loading...</span></Spinner>
          </div>
        : <div>
            <ProductList products={catalogState} deleteProduct={deleteProduct} />
            <Button variant="light"><Link to="/product">Добавить продукт</Link></Button>
          </div>
      }
    </div>
  );
}

export default Catalog;

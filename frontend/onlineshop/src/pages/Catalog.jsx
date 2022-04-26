import ProductList from "../components/ProductList";
import { Table } from "react-bootstrap";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";

function Catalog() {

  return (
    <div className="App">
      <h1>Online Shop React</h1>
      <h2>Каталог</h2>
      <div>
        <Table striped bordered hover variant="light">
          <thead>
            <tr>
              <th>ID</th>
              <th>Категория</th>
              <th>Брэнд</th>
              <th>Модель</th>
              <th>Количество</th>
              <th>Изменение продукта</th>
              <th>Удаление продукта</th>
            </tr>
          </thead>
          <ProductList />
        </Table>
        <Button variant="light"><Link to="/product">Добавить продукт</Link></Button>
      </div>
    </div>
  );
}

export default Catalog;

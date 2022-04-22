import { Button } from "react-bootstrap";
import { Link, Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <>
    <header>
      <Button variant="link"><Link to="/">Home</Link></Button>
      <Button variant="link"><Link to="/catalog">Catalog</Link></Button>
      <Button variant="link"><Link to="/product">Product</Link></Button>
    </header>
    <Outlet />
    <footer>Footer 2022</footer>
    </>
  );
};

export default Layout;

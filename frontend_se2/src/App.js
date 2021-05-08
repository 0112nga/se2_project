
import Sidebar from "./Components/sidebar";
import Navbar from "./Components/navbar";
import ProductComponent from "./Components/Product/productComponent";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom"

function App() {
  return (
    <Router>
      <Navbar/>
      <Sidebar/>
      <ProductComponent/>
    </Router>
  );
}

export default App;

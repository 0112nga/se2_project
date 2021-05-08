
function Sidebar() {
  return (
    <div className="position-relative">
        <div className="sidemenu">
                <div className="sidemenu-item" id="icon-dashboard">
                    <a href="#"><i className="fa fa-home" aria-hidden="true"></i></a>
                </div>
                <div className="sidemenu-item" id="icon-inventory">
                    <a href="#"><i className="fas fa-dolly-flatbed"></i></a>
                </div>
                <div className="sidemenu-item" id="icon-order-management">
                    <a href="#"><i className="fas fa-boxes"></i></a>
                </div>
                <div className="sidemenu-item" id="icon-logistics">
                    <a href="#"><i className="fas fa-truck"></i></a>
                </div>
                <div className="sidemenu-item" id="icon-forcast">
                    <a href="#"><i className="fa fa-line-chart" aria-hidden="true"></i></a>
                </div>
                <div className="sidemenu-item" id="icon-return-managment">
                    <a href="#"><i className="fas fa-sync"></i></a>
                </div>
        </div>	
        <div className="sidenav sidenav-dashboard">
            <div className="dashboard">
                <p id="dashboard">Dashboard</p>
                <a href="#" className="closebtn" >&times;</a>
            </div>
            <ul>
                <li>
                    <a href="/products">Products and Services</a>
                </li>
                <li>
                    <a href="/fulfillment">Fulfillment</a>
                </li>
            </ul>
        </div>
        <div className="sidenav sidenav-inventory">
            <div className="dashboard">
                <p id="dashboard">Inventory</p>
                <a href="#" className="closebtn" >&times;</a>
            </div>
        </div>
        <div className="sidenav sidenav-order-management">
            <div className="dashboard">
                <p id="dashboard">Order Management</p>
                <a href="#" className="closebtn" >&times;</a>
            </div>
        </div>
        <div className="sidenav sidenav-logistics">
            <div className="dashboard">
                <p id="dashboard">Logistics</p>
                <a href="#" className="closebtn" >&times;</a>
            </div>
        </div>
        <div className="sidenav sidenav-forcast">
            <div className="dashboard">
                <p id="dashboard">Forcast</p>
                <a href="#" className="closebtn" >&times;</a>
            </div>
        </div>
        <div className="sidenav sidenav-return-managment">
            <div className="dashboard">
                <p id="dashboard">Return Managment</p>
                <a href="#" className="closebtn" >&times;</a>
            </div>
        </div>
	</div>
  );
}

export default Sidebar;

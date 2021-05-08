
function Navbar() {
    return (
    <div>
	    <nav className="navbar navbar-expand-lg  navbar-light position-relative">
            <div>
                <a href="#" ><img src={process.env.PUBLIC_URL + '/img/circular-economy.svg'} id="supply-chain-management-icon"/></a>
            </div>
            <div className="navbar-nav" id="search">
			<form className="nav-item d-flex" action="/search" method="GET">
				<input className="form-control" type="search" placeholder="Search..." aria-label="Search" name="search" id="search-box"/>
				<button className="btn" type="submit"><i className="fa fa-search" aria-hidden="true"></i></button>
			</form>
		</div>
		<div className="navbar-nav">
				<div className="nav-item">
					<a className="nav-link" href="/login"><i className="fa fa-sign-in" aria-hidden="true"></i>&nbsp; LOG IN</a>
				</div>
		</div>
        </nav>
    </div>
    );
  }
  
  export default Navbar;
  
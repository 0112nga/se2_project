function openNav(event) {
    const item = event.currentTarget;
    const activeItem = document.querySelector('.active');
    const activeSidemenuItem = document.querySelector('.sidemenu-item-active');
    var itemid = item.id;
    var sidenav = "sidenav-"+itemid.substring(5,itemid.length);
    sidenav_item = document.getElementsByClassName(sidenav);
    const closebtn = sidenav_item[0].querySelector(".closebtn");
    closebtn.addEventListener('click', closeNav);
    if (activeItem && activeSidemenuItem) {
        activeItem.classList.remove('active');
        activeSidemenuItem.classList.remove('sidemenu-item-active');
    }
    sidenav_item[0].classList.add('active');
    item.classList.add('sidemenu-item-active');
  }
  
function closeNav(event) {
    const item = event.currentTarget;
    const activeSidemenuItem = document.querySelector('.sidemenu-item-active');
    activeSidemenuItem.classList.remove('sidemenu-item-active');
	sidenav_item[0].classList.remove('active');
}
const mySidenav = document.querySelector("#sidenav-dashboard");
const sidemenu_items = document.querySelectorAll(".sidemenu-item");
var sidenav_item = null;

sidemenu_items.forEach((item) => {
    item.addEventListener('click', openNav);
});
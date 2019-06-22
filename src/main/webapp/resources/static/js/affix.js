var header = document.getElementById("nav");
var sticky = header.offsetTop;
var sticked = false;
function myFunction() {

    if (window.pageYOffset > header.offsetTop) {
        header.classList.add("sticky");
        sticked = true;
    }
    if (window.pageYOffset < sticky && sticked){
        header.classList.remove("sticky");
        sticked = false;
    }
}
function stickyUpdate() {
    console.log(sticky);
    header.classList.remove("sticky");
    sticky = header.offsetTop;
    myFunction()
}
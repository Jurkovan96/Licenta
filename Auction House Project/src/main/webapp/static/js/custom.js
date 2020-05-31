function myfunction() {
    var x  = document.getElementById("menubar");
    x.style.visibility = "hidden";

    var y = document.getElementById("selectProd").firstChild;
    console.log(y.value);

    searchProductByTerm()
}
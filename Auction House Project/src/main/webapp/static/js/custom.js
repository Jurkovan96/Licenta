function myfunction() {
    var x  = document.getElementById("menubar");
    x.style.visibility = "hidden";

    var y = document.getElementById("selectProd").firstChild;
    console.log(y.value);

    searchProductByTerm()
}

function Display() {

    var y = document.getElementById("adressEdit");
    y.style.display = "block";

}

 var buttonDoSmth = document.getElementsByName("showAdressDetails");
buttonDoSmth.style.background = "black";
buttonDoSmth.addEventListener("click", Display);
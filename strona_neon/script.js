let button = document.querySelector("button");
button.addEventListener("click", function () {
    if (button.textContent == "WŁĄCZ") {
        button.textContent = "WYŁĄCZ";
    } 
    else {
        button.textContent = "WŁĄCZ";
    }
    const letters=document.querySelectorAll("li");
    for(let i=0;i<letters.length;i++){
        letters[i].classList.toggle("off");
    }
})

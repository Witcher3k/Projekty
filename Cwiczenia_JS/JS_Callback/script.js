function dodaj(a, b) {
    return a + b;
}

function odejmij(a, b) {
    return a - b;
}

function calc(a, b, callback) {
    console.log(`wprowadzone zostaly wartosci: ${a} i ${b}`);
    return callback(a, b);
}
const wynik = calc(10, 20, dodaj);

/////////////////////////////////////////////////////////////////////

function show(x) {
    console.log(x);
}

function showAlert(x) {
    alert(x);
}

function whichAlert(x, callback) {
    return callback(x);
}

///////////////////////////////////////////////////////////////////


const myinterval= setInterval(function () {
    console.log('cos')
}, 1000);

function stopInterval(){
    clearInterval(myinterval);
}

document.addEventListener("click",stopInterval);


const wiek=[21,5,3,2,8];
console.log(wiek.sort(function(a,b){return a-b;}));

const miasta=["KraKów","kAtowiCe","wRocław"];
const miastaUpper=miasta.map(function(miasta){return miasta.toUpperCase()});
console.log(miastaUpper);


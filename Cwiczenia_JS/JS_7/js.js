/**
 * Created by Kamil on 2017-06-11.
 */
var dodawanie=function (a,b) {
    return a+b;
}
var wynik=dodawanie(5,5);
console.log(wynik);

var a ="zmienna globalna";

function one() {
    var a ="zmienna lokalna";
    console.log(a)
}
one();
console.log(a);
let b ="let globalny";

if(true){
    let b = "let lokalny w if , var tutaj bylby globalny :O";
    console.log(b);
}
console.log(b);

var c ="0";

function one() {
    var c ="1";
    console.log(c);
    function two() {
        var c="2";
        console.log(c);
        function three() {
            var c="3";
            console.log(c);
        }
        three();
    }
    two();
}
one();
console.log("zmienna globalna "+c);

function silnia(z) {
   if(z==0){
       return 1;
   }
    else return z*silnia(z-1);
}
function dodajrek(z) {
 if(z==0){
     return 0;
 }
 else {
     console.log(z);
     return z+dodajrek(z-1);
    }
}
console.log("Wynik silnia:"+silnia(4));
console.log("Wynik rekurencja dodaj:"+dodajrek(4));

console.log("-------------------------------------");
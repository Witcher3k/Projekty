/**
 * Created by Kamil on 2017-06-19.
 */
console.log(a);
console.log('hoistingowi podlega tylko deklaracja');
console.log('przenoszenie deklaracji zmiennych i funkcji na poczatek danego ' +
    'zakresu');
console.log('funkcje w procesie hoistingu są pierwsze! potem zmienne');
console.log('hoisting nie dotyczy przypisania');
var a=5;
one();


function one() {
    console.log(b);
    var b=20;
    console.log('wartosc b z funkcji'+b);
    console.log(a); // z zasiegu globalnego
}

let c =2;
function two(){
    //let c=2;
    //console.log(c);
    function three(){
        console.log(c);
    }
    three();
}

two();
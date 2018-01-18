var a = 10;
let b = 15;
const c = 'hello'

//c='bład' const wartosc przypisujemy tylko 1 raz

function letTest() {
    let b = true;
    if (b) {
        let b = false;
        console.log(b);
    }
    console.log(b);
}
letTest();

function constTest() {
    const b = true;
    if (b) {
        const b = false;
        console.log(b);
    }
    console.log(b);
}
constTest();

function varTest() {
    var b = true;
    if (b) {
        var b = false;
        console.log(b);
    }
    console.log(b);
}
varTest();
var a = 'eldo';
// let b ='blad'; nie nadpisujemy let i const var mozna
console.log(a);
console.log(b);

const tab = ['aaa', 87, true];
console.log(tab);
tab.push('bbb');
console.log(tab);
tab.splice(0, 1);
console.log(tab);


let x = true;
const y = 'prawda';
const z = 'falsz';
console.log(x ? y : z);

let obiekt ={
    wlasciwosc1:'numer1',
    wlasciwosc2:'numer2',
    wlasciwosc3:'numer3'
};
obiekt.wlasciwosc1='numer99';
console.log(obiekt.wlasciwosc1);

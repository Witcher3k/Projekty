// funkcja jest obiektem

function add(a, b) { //1 sposob deklaracji
    return a + b;
}

let number = add(5, 5);
console.log(number);

const add2 = function (a, b) { //2 sposob deklaracji
    return a + b;
}


const add3 = new Function('a', 'b', 'return a+b;'); //3 sposob deklaracji


const add4 = (a, b) => { //4 sposob deklaracji
    return a+b;
}
console.log(add4);
console.log(add4(5,5));

function userName(name,surname){
    return(`nazwa uzytkownika to ${name} ${surname}`);
}
console.log(userName("Mati","Nowak"));
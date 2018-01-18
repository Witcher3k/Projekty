//tworzenie obiektu za pomoca literału
let hotel = {
    name: 'Super Hotel',
    rooms: 40,
    booked: 25,
    gym: true,
    roomTypes: ['Twin', 'double', 'suite'],

    checkAvailability: function () {
        console.log("Tyle pokoi jest dostępnych: " + (this.rooms - this.booked));
    }
}
hotel.checkAvailability();

hotel.rooms = 50;
console.log(hotel.rooms);

function Hotel(name, rooms, booked) { //konstruktor
    this.name = name;
    this.rooms = rooms;
    this.booked = booked;
}

let hotel_2 = new Hotel("Fajny Hotel", 25, 0); //tworzenie obiektu za pomoca konstruktora

for (let key in hotel_2) { //wyswietlanie wlasciwosci
    let value = hotel_2[key]
    console.log(key + ":" + value);
}

console.log(Object.values(hotel_2)); //wyswietlanie wlasciwosci
console.log(typeof (hotel_2));
//document.body.textContent += hotel.name + " ";
//document.body.textContent += hotel_2.name;

let hotele = new Array();

let liczba_hoteli = 5;

for (let i = 0; i < 5; i++) {
    //  let nazwa = prompt("Podaj nazwe hotelu", "");
    //   let liczbapokoi = prompt("Podaj liczbe pokoi", "");
    //  let liczba_rez = prompt("Podaj liczbe zarezerwowanych", "");
    let nazwa = "Hotel " + i;
    let liczbapokoi = 50;
    let liczba_rez = 20;
    liczbapokoi = parseInt(liczbapokoi);
    liczba_rez = parseInt(liczba_rez);
    hotele[i] = new Hotel(nazwa, liczbapokoi, liczba_rez);
}
hotele.forEach(element => {
    console.log(element.name); //wyswietlanie nazwy obiektow z tablicy obiektow
});

resolution();

function resolution() {
    console.log(this.innerWidth + "x" + this.innerHeight); //rozdzialka strony 
}

var ile_p = document.getElementsByTagName("P");
console.log(ile_p);
ile_p[0].textContent = hotel.name + " " + hotel_2.name; //dodanie do 1 paragrafu nazwy obiektu hotel i hotel 2
console.log(document.lastModified) //ostatnia modyfikacja dokumentu , na operze inaczej pokazuje :O
alert('Bieżąca strona: ' + window.location);

let variable = 10;

console.log(!isNaN(variable));

variable = 105.84945618;
console.log(variable.toFixed(3)); //zaokraglenie do 3 miejsc po przecinku
console.log(variable.toPrecision(3)); //zaokraglenie do okreslonej liczby cyfr
console.log(variable.toExponential(3));
console.log(Math.round(variable)); //do najblizeszj calkowitej
console.log(Math.ceil(variable)); //w gore do najblizszej calkowitej
console.log(Math.floor(variable)) //w dol do najblizeszej calkowitej

console.log(Math.random()); //generuje liczby z zakresu od 0 do 1 (wykluczajac 1) czyli przediał [0,1)


function getRandomInt(max, min) {
    var random
    random = Math.floor(Math.random() * (max - min) + 1) + min;
    return random.toFixed(3);
}

let today = new Date();
console.log(today.getFullYear());
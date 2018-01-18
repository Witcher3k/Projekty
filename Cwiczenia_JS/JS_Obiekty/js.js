let a = 1;
let b = a;
a = 2;

console.log(a + "+" + b);

const tab = ["a", "b", "c"];
const tab1 = tab;
const tab2 = [9,8,7,6,5,4,3,2,1];
let temp;
let change = true;

console.log(tab);
console.log(tab1);

tab.push("d");

for (let i = 0; i < tab.length; i++) {
    //tab[i] = prompt("Podaj wartosc do tablicy", "");
}

console.log(tab);
console.log(tab1);    

console.log(tab2+'przed sortowaniem');
while (change) {
    change = false;
    for (let i = 0; i < tab2.length - 1; i++) {
        if (tab2[i] > tab2[i + 1]) {
            temp=tab2[i+1];
            tab2[i+1]=tab2[i];
            tab2[i]=temp;
            change=true;
        }
    }
}

document.getElementById("liczby").innerHTML=tab2;



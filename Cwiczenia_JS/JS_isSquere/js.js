/**
 * Created by Kamil on 2017-06-19.
 */
function isSquare(n) {
    var sqrt= Math.sqrt(n);
    var x = Math.round(sqrt);
    if(Math.pow(sqrt,2)==Math.pow(x,2)){
        return true;
    }
    else return false;
}
console.log(isSquare(3));
console.log(Math.sqrt(79)*Math.sqrt(79));

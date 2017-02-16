/**
 * Created by Administrator on 2017-01-20.
 */
function calc (event, i) {
    var s = event.data;
    var num =parseInt(s);
    postMessage(s + i);

}

onmessage = function (event) {
    var i = 0;
    i++;
    calc(event, i);
}
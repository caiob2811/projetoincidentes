function getDataHoraAtual() {

    const data = new Date();
    const dia = String(data.getDate()).padStart(2, '0');
    const mes = String(data.getMonth() + 1).padStart(2, '0');
    const ano = data.getFullYear();
    const horas = String(data.getHours()).padStart(2, '0');
    const minutos = String(data.getMinutes()).padStart(2, '0');
    const segundos = String(data.getSeconds()).padStart(2, '0');


    var all = dia + "/" + mes + "/" + ano + " " + horas + ":" + minutos + ":" + segundos
console.log(all)

var inputx = document.getElementById("dataIncidente")
var inputy = document.getElementById("status")
inputx.setAttribute("value", all)
inputy.setAttribute("value", "Aberto")

console.log(all)
document.getElementById("formdata").submit()

}
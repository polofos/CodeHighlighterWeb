/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addRow(){
    var text = document.getElementsByName("addrow")[0].value;
    var para = document.createElement("p");
    var node = document.createTextNode(text);
    para.appendChild(node);

    var element = document.getElementById("d1");
    element.appendChild(para);
}



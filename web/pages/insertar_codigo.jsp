<%-- 
    Document   : insertar_codigo
    Created on : 30/06/2016, 07:15:52 AM
    Author     : Pol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editro de código</title>
        <script src="/js/jquery-3.0.0.js" type="text/javascript"></script>
        <script>
            var contador = 0;
            function addRow(){
                // Obtiene el valor de Write new Line
                var text = document.getElementsByName("addrow")[0].value;
                // Crea la fila con el nuevo texto y el numero
                var trRow = document.createElement("tr");
                var tdRow1 = document.createElement("td");
                var tdRow2 = document.createElement("td");
                
                tdRow1.setAttribute("class","tdLabel");
                var labelRow = document.createElement("label");
                labelRow.setAttribute("class", "label");
                labelRow.setAttribute("for","Action_rowList_"+ contador + "_");
                var textoLabel = document.createTextNode((contador+1) + ":");
                labelRow.appendChild(textoLabel);
                tdRow1.appendChild(labelRow);
                
                var inputRow = document.createElement("input");
                inputRow.setAttribute("id","ActionAdd_rowList_"+ contador +"_");
                inputRow.setAttribute("name","rowList["+ contador +"]");
                inputRow.setAttribute("value",text);
                inputRow.setAttribute("readonly", "readonly");
                inputRow.setAttribute("type","text");
                tdRow2.appendChild(inputRow);
                
                trRow.appendChild(tdRow1);
                trRow.appendChild(tdRow2);
                
                var tabla = document.getElementById("rowstable");
                var tbody = document.createElement("tbody");
                tbody.appendChild(trRow);
                
                // Crea la fila con la etiqueta Mark y el checkbox
                
                var trMark = document.createElement("tr");
                var tdM1 = document.createElement("td");
                var tdM2 = document.createElement("td");
                
                tdM1.setAttribute("align", "right");
                tdM1.setAttribute("valign", "top");
                trMark.appendChild(tdM1);
                
                tdM2.setAttribute("align", "left");
                tdM2.setAttribute("valign", "top");
                
                var chBM = document.createElement("input");
                var hiddenM = document.createElement("input");
                var labelM = document.createElement("label");
                
                
                chBM.setAttribute("id","ActionAdd_markList_"+ contador +"_");
                chBM.setAttribute("name","markList["+contador+"]");
                chBM.setAttribute("value","true");
                chBM.setAttribute("type","checkbox");
                hiddenM.setAttribute("id","__checkbox_ActionAdd_markList_"+contador+"_");
                hiddenM.setAttribute("name","__checkbox_markList["+contador+"]");
                hiddenM.setAttribute("value","false");
                hiddenM.setAttribute("type","hidden");
                labelM.setAttribute("class","checkboxLabel");
                labelM.setAttribute("for","ActionAdd_markList_"+contador+"_");
                
                var labelText = document.createTextNode("mark");
                labelM.appendChild(labelText); 
                tdM2.appendChild(chBM);
                tdM2.appendChild(hiddenM);
                tdM2.appendChild(labelM);
                trMark.appendChild(tdM2);
                
                tbody.appendChild(trMark);
                
                tabla.appendChild(tbody);
                contador++;
                
            }
        </script>
    </head>
    <body>
        <h1> Welcome: ${sessionScope.userName} </h1>
        <main>
            <section>
                <h3>Write code in ${applicationScope.language}:</h3>
                <div style="background-color: #ccccff ;">
                <s:form action="ActionAdd" >
                    <s:textfield name="title" label="Title" /> <br />
                    <tr>
                        <td>
                            <label for="addrow">Write new Line: </label> 
                        </td>  
                        <td>
                            <input type="text" name="addrow" />
                        </td>
                        <td> <button type="button" name="addrowbuttton" onclick="addRow()"> Add Line </button> </td>
                    </tr>
                    <s:textarea label="input" name="input" cols="30" rows="4"></s:textarea>
                    <s:checkbox name="inputInclude" label="include" />           
                    <tr> 
                        <td >
                            <h4> Code: </h4> 
                        </td>
                        <td >
                            <div style="background-color:#ccffff ; overflow-y: scroll; width: 300px; height: 400px; position: relative; display: table;">
                                <table id="rowstable" class="table" border="1">
                                    
                                        <!--<s:textfield readonly="true" value="int main(){" name="rowList[0]" label="0"/>
                                        <s:checkbox name="markList[0]" fieldValue="false" label="mark" />
                                        <s:textfield readonly="true" value="x=1{" name="rowList[1]" label="2"/>
                                        <s:checkbox name="markList[1]" fieldValue="false" label="mark" />     -->
                                    
                                </table>      
                            </div>
                        </td>
                    </tr> 
                    <s:textarea label="output" name="output" cols="30" rows="4"></s:textarea>
                    <s:checkbox name="outputOptional" label="inlcude" />  
                    
                    <s:submit value="Send" />    
        
                </s:form>
                </div>
                    <div id="d1" name="d1">
                        
                    </div>
            </section>
        </main>
        
        
    </body>
</html>

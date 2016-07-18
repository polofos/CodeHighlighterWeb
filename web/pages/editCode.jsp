<%-- 
    Document   : editCode
    Created on : 6/07/2016, 04:23:11 PM
    Author     : Pol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Welcome: ${sessionScope.userName} </h1>
        <main>
            <section>
                <h3>Write code in ${applicationScope.language}:</h3>
                <div style="background-color: #ccccff ;">
                <s:form action="ActionAdd" >
                    <s:textfield name="title" label="Title" value="%{#attr.title}" /> <br />
                    <tr>
                        <td>
                            <label for="addrow">Write new Line: </label> 
                        </td>  
                        <td>
                            <input type="text" name="addrow" />
                        </td>
                        <td> <button type="button" name="addrowbuttton" onclick="addRow()"> Add Line </button> </td>
                    </tr>
                    <s:textarea label="input" name="input" cols="30" rows="4"> <s:property value="#attr.input" />   </s:textarea>
                    <s:checkbox name="inputInclude" label="include" />           
                    <tr> 
                        <td>
                            <h4> Code: </h4> 
                        </td>
                        <td>
                            <div style="background-color:#ccffff ; overflow-y: scroll; width: 300px; height: 400px; position: relative; display: table;">
                                <table id="rowstable" class="table" border="1">
                                    <s:set var="i" value="%{0}" scope="page" />
                                    <s:iterator value="rowList">
                                        <s:textfield readonly="false" value="%{#attr.rowList[#attr.i]}" name="rowList[%{#attr.i}]" label="%{#attr.i}"/>
                                        <s:checkbox name="markList[%{#attr.i}]" fieldValue="true" label="mark" />
                                        <s:set var="i" value="%{#attr.i+1}" scope="page" />
                                        <!--<s:textfield readonly="true" value="int main(){" name="rowList[0]" label="0"/>
                                        <s:checkbox name="markList[0]" fieldValue="false" label="mark" />
                                        <s:textfield readonly="true" value="x=1{" name="rowList[1]" label="2"/>
                                        <s:checkbox name="markList[1]" fieldValue="false" label="mark" />     -->
                                    </s:iterator>
                                </table>      
                            </div>
                        </td>
                    </tr> 
                    <s:textarea label="output" name="output" cols="30" rows="4"> <s:property value="#attr.output" /> </s:textarea>
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

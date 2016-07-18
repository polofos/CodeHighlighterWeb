<%-- 
    Document   : bienvenido
    Created on : 29/06/2016, 02:24:39 AM
    Author     : Pol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
    </head>
    <body>
        <h1> <s:actionmessage /> <s:property value="#session.userName" />   </h1>
        <main>
           <s:form action="ActionNewCode">
                <s:select label="Lenguaje" headerKey="-1" headerValue="---Selecciona uno---" list="languages" name="language" />
                <s:submit value="add new Code" />
            </s:form>
            <!--
            <s:iterator id="lenguajes" value="languages" status="it">
                <li><s:property /></li>
            </s:iterator> -->
            <s:set var="i" value="%{0}" scope="page" > </s:set>
            <s:iterator id="codes" value="listCode" status="it">
                <s:url action="ActionEdit.action" var="urlAct" >
                    <s:param name="idIdCode"> ${attr.listCode[i].id.idcode} </s:param>
                    <s:param name="idUserName"> ${attr.listCode[i].id.userUsername} </s:param>
                    <s:param name="idLanguage"> ${attr.listCode[i].id.languageIdlanguage} </s:param>
                </s:url>
                <li> <p> Code ${page.i+1}: ${attr.listCode[i].title}    Language: ${attr.listCode[i].language.idlanguage} </p> </li>
                <li> <s:a href=" %{urlAct}">  Edit </s:a>  </li>
                <s:set var="i" value="%{attr.i+1}" scope="page" > </s:set>
            </s:iterator>
        </main>
        
    </body>
</html>

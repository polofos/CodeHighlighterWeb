<%-- 
    Document   : Code
    Created on : 3/07/2016, 05:42:29 PM
    Author     : Pol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code</title>
            <script type="text/javascript" src="js/SHL/shCore.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushAS3.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushAppleScript.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushBash.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushCSharp.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushColdFusion.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushCpp.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushCss.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushDelphi.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushDiff.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushErlang.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushGroovy.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushJScript.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushJava.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushJavaFX.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushPerl.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushPhp.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushPowerShell.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushPython.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushRuby.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushSass.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushScala.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushSql.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushVb.js"></script>
            <script type="text/javascript" src="js/SHL/shBrushXml.js"></script>
            <link type="text/css" rel="stylesheet" href="css/SHL/shCore.css">
            <link type="text/css" rel="stylesheet" href="css/SHL/shThemeDefault.css"> 
            <script type="text/javascript" src="js/html2canvas.js"></script>
            <script>
                function createCanvas(){
                    html2canvas(document.body.main.section {
                        onrendered: function(canvas) {
                            document.body.appendChild(canvas);
                        }
                    });
                }
            </script>
    </head>
    <body>
        <h1>Welcome: ${sessionScope.userName} </h1>
        <main>
            <section>
                <div>
                    <h4>
                        Code: <s:property value="title" />
                    </h4>
                    <div class="input">
                        <s:textarea label="Input" name="input" cols="30" rows="4">  </s:textarea>
                    </div>
                    <div class="codigo">
                        <h4>Code: <h4>
                            <s:set var="i" value="%{0}" scope="page" />
                            <pre class="brush: ${applicationScope.language}">
                            <s:iterator value="rowList">
                                <s:property />
                            </s:iterator>
                            </pre>
                    </div>
                    <div class="input">
                        <s:textarea label="Output" name="output" cols="30" rows="4">  </s:textarea>
                    </div>
                </div>
            </section>
                            
            <section>
                <ul>
                    <li><a href="ActionEdit.action" > Edit Code </a></li>
                    <li><a href="ActionLogin.action" > Regresar </li>
                </ul>
                <button type="button" name="canvasbuttton" onclick="createCanvas()"> Create screenShot </button>
            </section>
        </main>
        <script type="text/javascript">
             SyntaxHighlighter.all();
        </script>

    </body>
</html>

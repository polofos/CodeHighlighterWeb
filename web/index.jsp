<%-- 
    Document   : index
    Created on : 29/06/2016, 01:10:14 AM
    Author     : Pol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
          <script type="text/javascript" src="js/SHL/shCore.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushAS3.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushAppleScript.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushBash.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushCSharp.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushColdFusion.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushCpp.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushCss.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushDelphi.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushDiff.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushErlang.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushGroovy.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushJScript.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushJava.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushJavaFX.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushPerl.js"></script>
  <script type="text/javascript" src="js/SHL/shBrushPhp.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushPowerShell.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushPython.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushRuby.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushSass.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushScala.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushSql.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushVb.js"></script>
  <script type="text/javascript" src="/js/SHL/shBrushXml.js"></script>
  <link type="text/css" rel="stylesheet" href="css/SHL/shCore.css">
  <link type="text/css" rel="stylesheet" href="css/SHL/shThemeDefault.css"> 
    </head>
    <body>
        <h1>Acceder</h1>
        <s:form action="ActionLogin" >
            <s:textfield name="userName" key="Nombre de Usuario" value="rperedo" />
            <s:password name="password" key="Contraseña" value="rpv" />
            <s:submit value="Login" />
            
            <s:actionmessage />
            <s:actionerror />
        </s:form>
        
        
        <pre class="brush: php">
            function foo()
            {
                    $variable = "hola como estas";
                    echo $variable
            }
            </pre>

            <!-- Finally, to actually run the highlighter, you need to include this JS on your page -->
            <script type="text/javascript">
                 SyntaxHighlighter.all()
            </script>

    </body>
</html>

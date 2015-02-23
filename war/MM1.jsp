<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

 <%@ page import="lib.MM1" %>
 <%@ page import="lib.MM2" %>
 <%@ page import="lib.MM3" %>
 <%@ page import="lib.MM4" %>




<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<style type="text/css">

    body { background-color:#f0f0ff }

    .tbl { border-style:solid; border-width:1px;border-color:darkgreen;border-collapse:collapse; width:1000px }

    .dt_o { border-style:solid; border-width:1px; border-color:darkgreen }

    .dt_e { border-style:solid; border-width:1px; border-color:darkgreen;background-color:#c0c0ff }

    .head { border-style:solid; border-width:1px; border-color:darkgreen;background-color:darkgreen;color:white }

</style>



</head>

<body>



<a href="/index.html">トップページへ</a><br><br>
<a href="/j11016-calc.html">再計算</a><br><br>
<a href="/j11016-hisenkeicalc.html">非線形計算</a><br><br>

[計算結果]



<TABLE border="4" width="200" height="300" bordercolorlight="white" bgcolor="white" bordercolor="black">
<TR>
<TD>x1</TD><TD><%= request.getAttribute("service1") %></TD><tr>
<TD>x2</TD><TD><%= request.getAttribute("service2") %></TD><tr>
<TD>x3</TD><TD><%= request.getAttribute("service3") %></TD><tr>
<TD>x4</TD><TD><%= request.getAttribute("service4") %></TD><tr>
<TD>x5</TD><TD><%= request.getAttribute("service5") %></TD><tr>
<TD>式</TD><TD><%= request.getAttribute("formula") %></TD><tr>
<TD>答え</TD><TD><%= request.getAttribute("ans") %></TD>
</TR>
</TABLE>

</body>
</html>

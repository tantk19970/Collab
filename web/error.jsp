<%-- 
    Document   : error
    Created on : 14-Dec-2020, 11:55:28
    Author     : Admin
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR Page</title>
    </head>
    <body>
        <h1 >
            <font color="red"> ERROR!!! </br>
            <s:property value="%{#session.ERROR}"/>
            </font>
        </h1>
    </body>
</html>

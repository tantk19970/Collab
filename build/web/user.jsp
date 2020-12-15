<%-- 
    Document   : user
    Created on : 14-Dec-2020, 11:55:21
    Author     : Admin
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Page</title>
    </head>
    <body>
        <h1>Hello <s:property value="%{#session.USER}"/></h1>
    </body>
</html>

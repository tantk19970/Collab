<%-- 
    Document   : shopping
    Created on : 14-Dec-2020, 13:06:07
    Author     : Admin
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <h1>Shopping Cart!</h1>
        <s:iterator value="%{listCate}">
            <s:if test="%{listCate!=null">
                
            </s:if>
        </s:iterator>
        
    </body>
</html>

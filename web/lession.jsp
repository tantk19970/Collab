<%-- 
    Document   : lession
    Created on : Dec 18, 2020, 10:51:43 PM
    Author     : Admin
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Theory</th>
                    <th>Excercise</th>
                    <th>Delete</th>
                    <th>Add</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="%{listLoad}" status="counter">
                <tr>
                    <td><s:property value="%{#counter.count}"/></td>
                    <td><s:property value="%{proID}"/></td>
                    <td><s:property value="%{proName}"/></td>
                    <td><s:property value="%{theory}"/></td>
                    <td><s:property value="%{excer}"/></td>
                    <td><s:form action="DeleteAction">
                            <s:hidden name="productID" value="%{proID}"/>
                            <s:hidden name="lastSub" value="%{#session.LASTSUB}"/>
                            <s:hidden name="shopType" value="%{#session.SHOP}"/>
                            <s:submit value="Delete"/>
                    </s:form></td>
                    <td>Add</td>
                </tr>
                </s:iterator>
            </tbody>
        </table>

    </body>
</html>

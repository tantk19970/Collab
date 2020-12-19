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
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Choose action!</h1>
        <%--<s:iterator value="%{listCate}">--%>
            <s:if test="%{listCate != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>NO</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Delete</th>
                            <th>Add</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="%{listCate}" status="counter">
                        <tr>
                            <td><s:property value="%{#counter.count}"/></td>
                            <td><s:property value="%{proID}"/></td>
                            <td><s:property value="%{proName}"/></td>
                            <td>Delete</td>
                            <td><s:form action="LoadAction">
                                    <s:hidden name="txtProID" value="%{proID}"/>
                                    <s:hidden name="shopType" value="%{shopType}"/>
                                    <s:submit value="Add"/>
                            </s:form></td>
                        </tr>
                        </s:iterator>
                    </tbody>
                </table>

                
                
            </s:if>
        <%--</s:iterator>--%>
        
    </body>
</html>

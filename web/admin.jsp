<%-- 
    Document   : admin
    Created on : 14-Dec-2020, 11:55:16
    Author     : Admin
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Page</title>
    </head>
    <body>
        <h1>Hello <s:property value="%{#session.USER}"/>!</h1>
        <s:form action="SearchAction">
            <s:textfield name="searchValue" label="Search :"/>
            <s:submit value="Search"/>
        </s:form>
        </br>
        <s:if test="%{list!= null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>Full name</th>
                        <th>Role</th>
                        <th>Major</th>
                        <th>Year</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="%{list}" status="counter">
                    <tr>
                        <td><s:property value="%{#counter.count}"/></td>
                        <td><s:property value="%{username}"/></td>
                        <td><s:property value="%{fullname}"/></td>
                        <td><s:property value="%{role}"/></td>
                        <td><s:property value="%{major}"/></td>
                        <td><s:property value="%{year}"/></td>
                        <td>Delete</td>
                        <td>Update</td>
                    </tr>
                    </s:iterator>
                </tbody>
            </table>

        </s:if>
        <s:form action="FirstShopAction">
            <s:hidden name="shopType" value="shopSub"/>
            <s:submit value="addSub" label="Add subject :"/>
        </s:form>
        <s:form action="FirstShopAction">
            <s:hidden name="shopType" value="shopLes"/>
            <s:submit value="addLesson" label="Add lesson :"/>
        </s:form>
        
        <s:form action="GoToQuizPage">
            <s:hidden name="shopType" value="shopSub"/>
            <s:submit value="Test Subject" label="Test Subject"/>
        </s:form>
        
        
    </body>
</html>

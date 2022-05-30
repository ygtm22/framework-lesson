<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
<h2>検索条件または登録条件を入力してください。</h2>
<c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
   <form:form action="result" modelAttribute="top" method="post">
   <label>product_name:</label> <form:input path="productName" name="keyword" /><form:errors path="productName" cssStyle="color: red"/><br>
    <label>price:</label> <form:input path="price" /><form:errors path="price" cssStyle="color: red"/>
    <br>
     <form:button name="param1">検索</form:button>
     <form:button name="param2">登録</form:button>
  </form:form>
    
</body>
</html>
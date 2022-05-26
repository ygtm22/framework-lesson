<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
  <h2>検索結果</h2>
  <p>
    <c:if test="${not empty product}">
      product_id:${fn:escapeXml(product.productId)}<br>
      product_name:${fn:escapeXml(product.productName)}<br>
      price:${fn:escapeXml(product.price)}<br>
    </c:if>
  </p>
  <a href="top">戻る</a>
</body>

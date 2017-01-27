<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>HelloWorld Admin page</title>
</head>
<body>
	Dear <strong>${name}</strong>, Welcome to Admin Page.
        <c:forEach var="pedidos" items="${controlePedidosManagedBean.pedidos}">
        <c:out value="${pedidos.idSalesOrder}"/>
        <c:out value="${pedidos.clientName}"/>
            <c:forEach var="products" items="${pedidos.products}">
                <c:out value="${products.prodDescription}"/>
            </c:forEach>    
</c:forEach>
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>
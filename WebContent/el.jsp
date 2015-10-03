<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Page</title>
</head>
<body>
<h2>Expression Language Demonstration:</h2>
<h3>Request Scope:</h3>

<p>Person Object: ${person}</p>
<p>Person Object using requestScope: ${requestScope.person}</p>
<p>Person Name using . operator: ${person.name}</p>
<p>Person Name using []: ${person["name"]}</p>

<h3>Application Scope:</h3>
<p>Person.Cookie: ${applicationScope["Person.Cookie"]}</p>

<h3>Session Scope:</h3>
<p>Employee using []: ${sessionScope["employee"]}</p>
<p>Employee using [] get address: ${sessionScope["employee"]["address"]["address"]}</p>
<p>Employee using . operator: ${sessionScope.employee}</p>
<p>Employee using . operator get address: ${sessionScope.employee.address.address}</p>

<h3>Using Cookie:</h3>
<p>Person.Cookie: ${cookie["Person.Cookie"].value}</p>

<h3>Using initParam:</h3>
<p>system.user: ${initParam["system.user"]}</p>
</body>
</html>
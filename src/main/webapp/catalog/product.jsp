<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>OnlineShop</title>
</head>
<body>
	<h1>This is Product !!!</h1>
	<form method="POST" action="product">
		<input type="submit" value="Добавить продукт"/>
		<br/>
		<br/>
		Категория <input type="text" name="category"/>
		<br/>
		Брэнд <input type="text" name="brand"/>
		<br/>
		Модель <input type="text" name="model"/>
		<br/>
		Количество <input type="text" name="count"/>
	</form>
</body>
</html>
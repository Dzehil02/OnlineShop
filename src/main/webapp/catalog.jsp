<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
	<head>
		<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	
		<script type="text/javascript">
			function sendDelete(id,category, brand, model, count) {
				$.ajax({
					type : "DELETE",
					url : "/catalog/product",
					data: JSON.stringify({ "id": id, "category": category, "brand" : brand, "model" : model, "count" : count}),
					success : function(page) {
						$( "html" ).html(page);
				    },
				});
			}
		</script>

		<title>OnlineShop</title>
</head>
<body>
	<h1>This is OnlineShop !!!</h1>
	<h2>Каталог</h2>
	<table border="1px">

		<tr>
			<th>ID</th>
			<th>Категория</th>
			<th>Брэнд</th>
			<th>Модель</th>
			<th>Количество</th>
			<th>Изменение продукта</th>
			<th>Удаление продукта</th>
		</tr>

		<c:forEach var="product" items="${productList}">
			<tr>
				<td><c:out value="${product.id}" /></td>
				<td><c:out value="${product.category}" /></td>
				<td><c:out value="${product.brand}" /></td>
				<td><c:out value="${product.model}" /></td>
				<td><c:out value="${product.count}" /></td>
				<td><button onclick="location.href='/catalog/product?id=${product.id}'">Изменить продукт</button></td>
				<td><button onClick="sendDelete('${product.id}','${product.category}','${product.brand}','${product.model}','${product.count}')">Удалить продукт</button></td>
			</tr>
		</c:forEach>
	</table>
	<button>
		<a href="/catalog/product">Добавить продукт</a>
	</button>
</body>
</html>
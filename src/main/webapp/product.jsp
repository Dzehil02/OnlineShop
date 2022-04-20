<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	
<script type="text/javascript">
function sendPut(id) {
	$.ajax({
        type: "PUT",
        url: "/catalog/product",
        data: JSON.stringify({ "id": id, "category": $('select[name=category]').val(), "brand" : $('select[name=brand]').val(), "model" : $('input[name=model]').val(), "count" : $('input[name=count]').val()}),
        success : function(page) {
			$( "html" ).html(page);
	    },
    });
}
function sendPost() {
	$.ajax({
        type: "POST",
        url: "/catalog/product",
        data: JSON.stringify({ "id": null, "category": $('select[name=category]').val(), "brand" : $('select[name=brand]').val(), "model" : $('input[name=model]').val(), "count" : $('input[name=count]').val()}),
        success : function(page) {
			$( "html" ).html(page);
	    },
    });
}
</script>

<title>OnlineShop</title>
</head>
<body>
	<h1>This is Product !!!</h1>
	<c:if test="${product.id == null}">
		<form>
			<select	id="category" name="category">
				<c:forEach items="${category}" var="item">
					<option value="${item}">${item}</option>
				</c:forEach>
			</select>
			<select id="brand" name="brand">
				<c:forEach items="${brand}" var="item">
					<option value="${item}">${item}</option>
				</c:forEach>
			</select>
			Модель <input type="text" name="model" value="${product.model}" />
			Количество <input type="text" name="count" value="${product.count}" />
			<br>
			
		</form>
		<button onclick="sendPost()">Добавить продукт</button>
	</c:if>
	
	<c:if test="${product.id != null}">
		<form>
			<select	id="category" name="category">
				<c:forEach items="${category}" var="item">
					<c:if test="${product.category == item}">
						<option selected value="${item}">${item}</option>
					</c:if>
					<c:if test="${product.category != item}">
						<option value="${item}">${item}</option>
					</c:if>
				</c:forEach>
			</select>
			<select id="brand" name="brand">
				<c:forEach items="${brand}" var="item">
					<c:if test="${product.brand == item}">
						<option selected value="${item}">${item}</option>
					</c:if>
					<c:if test="${product.brand != item}">
						<option value="${item}">${item}</option>
					</c:if>
				</c:forEach>
			</select>
			Модель <input type="text" name="model" value="${product.model}" />
			Количество <input type="text" name="count" value="${product.count}" />
			<br>
		</form>
		<button onclick="sendPut('${product.id}')">Изменить продукт</button>
	</c:if>
		
		<p>Product ID: ${product.id}</p>

</body>
</html>
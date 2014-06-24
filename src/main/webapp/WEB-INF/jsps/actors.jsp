<%@include file="common/include.jsp"%>

<div class="body">

	<h2>
		<c:out value="${title}"></c:out>
	</h2>

	<table border="1">
		<tr>
			<td>Actor ID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Last Update</td>
		</tr>

		<c:forEach var="actor" items="${actors}">
			<tr>
				<td><c:out value="${actor.actor_id}"></c:out></td>
				<td><c:out value="${actor.first_name}"></c:out></td>
				<td><c:out value="${actor.last_name}"></c:out></td>
				<td><c:out value="${actor.last_update}"></c:out></td>
			</tr>
		</c:forEach>
	</table>


</div>



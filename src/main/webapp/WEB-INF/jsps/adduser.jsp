<%@include file="common/include.jsp"%>



<script type="text/javascript">
	$("#username_id").focus();
</script>


<div class="body" id="adduser_bloc">
	<h3>Register a new user</h3>
	<form:form name='f' action='${adduser_url}' method='POST'
		commandName="user">
		<table>
			<tr>
				<td>User Name:</td>
				<td><form:input path="username" name="username"
						id="username_id" type="text" /></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" name='password'
						id="password_id" type='password' /></td>
				<td><form:errors path="password" /></td>
			</tr>

			<tr>
				<td>Authority:</td>
				<td><form:input path="authority" name='authority'
						id="authority_id" type='text' /></td>
				<td><form:errors path="authority" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Register" /></td>
			</tr>
		</table>
	</form:form>
</div>
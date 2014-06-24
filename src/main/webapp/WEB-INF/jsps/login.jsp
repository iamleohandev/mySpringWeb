<%@include file="common/include.jsp"%>


<script type="text/javascript">
	$("#username_id").focus();
</script>

<div class="body" id="login_block">
	<h3>Leo Login page</h3>
	<form name='f' action='${j_spring_security_check_url}' method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input id="username_id" type='text' name='j_username'
					value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>

	<div>
		<a href='${adduser_url}'><spring:message code="register.user" /></a>
	</div>
</div>



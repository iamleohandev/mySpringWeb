<%@include file="include.jsp"%>

<div class="menu">


	Menu
	<ul>
		<li><a href='${en_locale}'><spring:message code="english" />
		</a>| <a href='${zh_CN_locale}'><spring:message code="chinese" /> </a></li>

		<sec:authorize access="isAuthenticated()">
			<li><a href='${actors_url}'><spring:message
						code="show_all_actor" /></a></li>
			<li><a href='${addactor_url}'><spring:message
						code="create_new_actor" /></a></li>
			<li><a href='${logout_url}'><spring:message
						code="title.logout" /></a></li>
		</sec:authorize>

		<sec:authorize access="!isAuthenticated()">
			<li><a href='${login_url}'><spring:message
						code="title.login" /></a></li>
		</sec:authorize>

		<li><a href='${jquery_url}'><spring:message
					code="title.jquery" /></a></li>

	</ul>
</div>


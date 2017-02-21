
<%@ include file="logoutForm.jsp" %>
<%@ include file="loggedUser.jsp" %>
	<c:if test="${loginId != null}">
		<h2>
			Welcome : ${loginId} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

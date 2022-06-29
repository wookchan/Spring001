<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action='update.cu' method="post">
	<input type="hidden" name="id" value="${vo.id}">
		<h3> [${vo.name}]고객정보 수정</h3>
			<table class="w-px500">
				<tr><th class="w-px120">성별</th>
					<td>
						<label><input type="radio" name="gender" ${vo.gender eq '남' ? 'checked' : '' } value="남">남</label>
						<label><input type="radio" name="gender" <c:if test="${vo.gender eq '여' ? 'checked' : ''}"> </c:if> value="여" >여</label>
					</td>
				</tr>	
				<tr><th>이메일</th>
					<td><input type="text" value='${vo.email}' name='email'></td>
				</tr>
				<tr><th>전화번호</th>
					<td><input type="text" value='${vo.phone}' name='phone'></td>
				</tr>
			</table>
		<div class="btnSet">
			<a class="btn-fill" onclick="$('form').submit()">등록</a>
			<a class="btn-empty" href="detail.cu?id=${vo.id}">취소</a>
		</div>
	</form>


</body>
</html>
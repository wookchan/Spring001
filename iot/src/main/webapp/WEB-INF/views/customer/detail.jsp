<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 컨트롤러에 값이 저장됨  -->

<h3>[${vo.name}]고객 정보</h3>
	<table class='w-px500'>
		<colgroup>
			<col width='120px'>
			<col>
		</colgroup>
		<tr><th>성별</th>
			<td>${vo.gender}</td>
		</tr>
		<tr><th>이메일</th>
			<td>${vo.email}</td>
		</tr>
		<tr><th>전화번호</th>
			<td>${vo.phone}</td>
		</tr>
	
	</table>
	<div class="btnSet">
		<a href="list.cu" class="btn-fill">고객 목록</a>
		<a href="modify.cu?id=${vo.id}" class="btn-empty">정보 수정</a>
		<a onclick="if(confirm('삭제하시겠습니까?')){ href='delete.cu?id=${vo.id}'}" class="btn-empty">정보 삭제</a>
	</div>

</body>
</html>
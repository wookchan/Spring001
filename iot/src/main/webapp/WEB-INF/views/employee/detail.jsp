<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>사원 정보</h3>
	<table class="w-px500">
		<c:set value="${vo}" var="em"/>
		<tr><th class="w-px120">사번</th>
			<td>${em.employee_id}</td>
		</tr>
		<tr><th>성명</th>
			<td>${em.last_name} ${em.first_name}</td>
		</tr>
		<tr><th>부서명</th>
			<td>${em.department_name}</td>
		</tr>
		<tr><th>업무</th>
			<td>${em.job_title}</td>
		</tr>
		<tr><th>입사 일자</th>
			<td>
				${em.hire_date}
			</td>
			
		<tr><th>이메일</th>
			<td>${em.email}</td>
		</tr>
		<tr><th>전화번호</th>
			<td>${em.phone_number}</td>
		</tr>
		<tr><th>급여</th>
			<td>${em.salary}</td>
		</tr>
	</table>
<div class="btnSet">
	<a href='modify.hr?emp_id=${em.employee_id}' class="btn-fill">수정</a>
	<a onclick="if(confirm(' [${em.employee_id}] 사원님의 정보를 삭제 하시겠습니까?')) href='delete.hr?emp_id=${em.employee_id}'" class="btn-fill">삭제</a>
	<a href="list.hr" class="btn-empty">뒤로</a>
</div> 
</body>
</html>
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
<h3>${vo.first_name} ${vo.last_name}회원 님의 정보</h3>
	<form method="post" action="update.hr">
	<input type="hidden" name="employee_id" value="${vo.employee_id}">
		<table class="w-px500">
		<tr><th class="w-px120">사번</th>
			<td>${vo.employee_id}</td>
		</tr>
		<tr><th>성명</th>
			<td>
				<input class="w-px120" type="text" name="last_name" value="${vo.last_name}">
				<input class="w-px120" type="text" name="first_name" value="${vo.first_name}">
			</td>
		</tr>
		<tr><th>부서명</th>
			<td>
				<select name="department_id">
						<option value="-1">부서 선택 </option>
						<c:forEach items="${departments}" var="de">
							<option value= "${de.department_id}" ${vo.department_id eq de.department_id ? 'selected' : '' }>
								${de.department_name}
							</option>
						</c:forEach>
			
				</select>
				
			</td>
		</tr>
		<tr><th>업무</th>
			<td>
				<select name="job_id">
				
						<c:forEach items="${jobs}" var="jo">
							<option value="${jo.job_id}" ${vo.job_id eq jo.job_id ? 'selected' : '' }>
								${jo.job_title }
							</option>
						</c:forEach>
			
				</select>
			</td>
		</tr>
		<tr><th>입사 일자</th>
			<td>
				<input type="date" name="hire_date" value="${vo.hire_date }">
			</td>
			
		<tr><th>이메일</th>
			<td>
				<input type="text"  name="email" value="${vo.email}">
			</td>
		</tr>
		<tr><th>전화번호</th>
			<td>
				<input type="text"  name="phone_number" value="${vo.phone_number}">
			</td>
		</tr>
		<tr><th>급여</th>
			<td>
				<input type="text" name="salary" value="${vo.salary}">	
			</td>
		</tr>
	</table>
</form>
		
<div class="btnSet">
	<a class='btn-fill' onclick="$('form').submit()">저장</a>
	<a href="detail.hr?emp_id=${vo.employee_id}" class="btn-empty">뒤로</a>
</div> 
</body>
</html>
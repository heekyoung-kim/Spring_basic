        
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 리스트</title>
<style type="text/css">
	table {
		width: 100%;
		border-collapse: collapse;
	}
	td, th {
  		border: 1px solid #dddddd;
  		text-align: left;
  		padding: 8px;
	}

	tr:nth-child(even) {
  		background-color: #dddddd;
	}
</style>
</head>
<body>
	<h1>직원리스트</h1>
	
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>직종</th>
				<th>급여</th>
				<th>입사일</th>
			</tr>
		</thead>
		<tbody>
			<%--
				* EmployeeController의 list() 메소드에서 전체 직원리스트를 조회하였음
				* 조회된 전체 직원목록을 Model객체에 "employees"속성명으로 저장하였음
				* JSP 페이지에서는 ${employees }로 조회하면 전체 직원목록을 획득할 수 있음
				List<Employee> employees = employeeService.getAllEmployees();
				model.addAttribute("employees", employees);
				
				
				items="${employees }"로 전체 직원목록 데이터를 획득한다.
				<c:forEach/>는 획득된 데이터에 포함된 직원의 갯수만큼 HTML 태그를 반복해서 출력한다.
				var="emp"는 획득한 전체 직원목록 데이터에서 한 번 반복될 때마다 순서대로 직원정보(Employee객체)가 저장된다. 
				
				<c:forEach var="emp" items="${employees }">
					HTML 태그
				</c:forEach>
			 --%>
			<c:forEach var="emp" items="${employees }">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.firstName } ${emp.lastName }</td>
					<td>${emp.phoneNumber }</td>
					<td>${emp.jobId }</td>
					<td><fmt:formatNumber value="${emp.salary }" pattern="##,###"/> 달러</td>
					<td><fmt:formatDate value="${emp.hireDate }" pattern="yyyy년 M월 d일"/> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>

    

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">

			<c:choose>
				<c:when test="${students.size()>0}">
				<div>検索結果：${students.size()}件</div>
				<table class="table table-hover">
					<tr>
						<th>入学年度</th>
						<th>クラス</th>
						<th>学生番号</th>
						<th>氏名</th>
						<th">１回</th>
						<th>２回</th>
					</tr>
					<c:forEach var="student" items="${students}">
						<tr>
							<td>${student.entYear}</td>
							<td>${test.classNum}</td>
							<td>${test.student_no}</td>
							<td>${student.name}</td>
							<td>${test.}</td>
							<td>${test.}</td>



					</tr>
				</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<div></div>
			</c:otherwise>
		</c:choose>
	</section>
</c:param>
</c:import>






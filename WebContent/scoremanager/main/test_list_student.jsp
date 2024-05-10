
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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生管理</h2>
			<div class="my-2 text-end px-4">
				<a href="StudentCreate.action">新規登録</a>
			</div>
			<c:choose>
				<c:when test="${students.size()>0}">
				<div>検索結果：${students.size()}件</div>
				<table class="table table-hover">
					<tr>
						<th>入学年度</th>
						<th>クラス</th>
						<th>学生番号</th>
						<th>氏名</th>
						<th class="text-center">１回</th>
						<th class="text-center">２回</th>
					</tr>
					<c:forEach var="student" items="${students}">
						<tr>
							<td>${student.entYear}</td>
							<td>${student.no}</td>
							<td>${student.name}</td>
							<td>${student.classNum}</td>
							<td class="text-center">
								<%-- --%>
								<c:choose>
								<c:when test="${student.isAttend()}">
									〇
								</c:when>
								<c:otherwise>
									✕
								</c:otherwise>
							</c:choose>
						</td>
						<td><a href="StudentUpdate.action?no=${student.no}">変更</a></td>
						<td><a href="StudentDelete.action?no=${student.no}">削除</a></td>
					</tr>
				</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<div>学生情報が存在しませんでした</div>
			</c:otherwise>
		</c:choose>
	</section>
</c:param>
</c:import>






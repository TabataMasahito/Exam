<%-- 成績管理一覧JSP --%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="score">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績管理</h2>
			<form action="TestRegist.action" method="post">
			<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
				<table>
					<tr>
						<th>入学年度</th>
						<th>クラス</th>
						<th>科目</th>
						<th>回数</th>
						<th></th>
					</tr>
					<tr>
						<th>
							<select class="form-select" id="student-f1-select" name="f1">
								<option value="0">--------</option>
								<c:forEach var="year" items="${ent_year_set}">
									<option value="${year}">${year}</option>
								</c:forEach>
							</select>
						</th>
						<th>
							<select class="form-select" id="student-f2-select" name="f2">
								<option value="0">--------</option>
								<c:forEach var="num" items="${class_num_set}">
									<option value="${num}">${num}</option>
								</c:forEach>
							</select>
						</th>
						<th>
							<select class="form-select" id="student-f3-select" name="f3">
								<option value="0">--------</option>
								<c:forEach var="subject" items="${subject_set}">
									<option value="${subject.cd}">${subject.name}</option>
								</c:forEach>
							</select>
						</th>
						<th>
							<select class="form-select" id="student-f4-select" name="f4">
								<option value="0">--------</option>
								<c:forEach var="count" begin="1" end="5">
									<option value="${count}">${count}</option>
								</c:forEach>
							</select>
						</th>
				<th>
				<button class="btn btn-secondary" id="filter-button">検索</button>
				</th>
				</tr>
				</table>
			</div>
			</form>
			<c:if test="${tests.size() > 0}">
				<form action="TestRegistExecute.action" method="post">
				<input type="hidden" name="subject_cd" value="${subject.cd}">
					<h2>科目：${subject.name}（${count}回）</h2>
					<table class="table table-hover">
						<tr>
							<th>入学年度</th>
							<th>クラス</th>
							<th>学生番号</th>
							<th>氏名</th>
							<th>点数</th>
						</tr>
						<c:forEach var="test" items="${tests}">
							<tr>
								<th>${test.student.entYear}</th>
								<td>${test.classNum}</td>
								<td>${test.student.no}</td>
								<td>${test.student.name}</td>
								<td><input type="text" name="point_${test.student.no}" value="${test.point}"></td>
							</tr>
							<input type="hidden" name="ent_year" value="${test.student.entYear}">
							<input type="hidden" name="class_num" value="${test.classNum}">
							<input type="hidden" name="count" value="${test.student.no}">
						</c:forEach>
					</table>
					<button class="btn btn-secondary" id="filter-button">登録して終了</button>
				</form>
			</c:if>
		</section>
	</c:param>
</c:import>

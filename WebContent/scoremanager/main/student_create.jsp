
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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生情報登録</h2>

			<form action ="StudentCreateExecute.action">
				<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
					<div class="col-4">

						<label class="form-labe" for="student-ent_year-select">入学年度</label>
						<select class="form-select" id="student-ent_year-select" name="ent_year" style="width:653px;">
							<option value="0">--------</option>
							<c:forEach var="year" items="${ent_year_set}">
								<%-- --%>
								<option value="${year}" <c:if test="year=={f1}">selected</c:if>>${year}</option>
							</c:forEach>
						</select>
					</div>
					<p></p>
					<div class="col-4">
					学生番号
					<input type="text"size="84"name="no"placeholder="学生番号を入力してください" required>
					</div>

					<p></p>
					<div class="col-4">
					氏名
					<input type="text" size="84" name="name" placeholder="氏名を入力してください" required>
					</div>

					<p></p>

					<div class="col-4">
						<label class="form-label" for="student-class_num-select">クラス</label>
						<select class="form-select" id="student-class_num-select" name="class_num" style="width:653px;">
							<option value="0">--------</option>
							<c:forEach var="num" items="${class_num_set}">
								<%-- --%>
								<option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>
							</c:forEach>
						</select>
					</div>

					<div class="mt-2 text-warning">${errors.get("f1")}</div>
				</div>
				<input type="submit" value="登録して終了">
				<p></p>
				<a href="StudentList.action">戻る</a>
			</form>

	</section>
</c:param>
</c:import>

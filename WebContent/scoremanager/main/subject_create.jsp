
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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報登録</h2>

			<form action ="SubjectCreateExecute.action">
				<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">

					<p></p>
					<div class="col-4">
					科目コード
					<input type="text"size="84"name="cd"placeholder="科目コードを入力してください" required maxlength="3">
					</div>

					<p></p>
					<div class="col-4">
					科目名
					<input type="text" size="84" name="name" placeholder="科目名を入力してください" required maxlength="20">
					</div>

					<p></p>



					<div class="mt-2 text-warning">${errors.get("f1")}</div>
				</div>
				<input type="submit" value="登録">
				<p></p>
				<a href="SubjectList.action">戻る</a>
			</form>

	</section>
</c:param>
</c:import>

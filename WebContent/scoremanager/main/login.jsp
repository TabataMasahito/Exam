
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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">ログイン</h2>

			<form action ="LoginExecute.action">
				<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">

					<p></p>
					<div class="col-4">
					ID
					<input type="text"size="84"name="id"placeholder="半角で入力してください" required>
					</div>

					<p></p>
					<div class="col-4">
					パスワード
					<input type="text" size="84" name="password" placeholder="20文字以内の半角英数字でご入力ください" required>
					</div>

					<p></p>


					<p><input type="checkbox" name="is_attend">パスワードを表示</p>

					<div class="mt-2 text-warning">${errors.get("f1")}</div>
				</div>
				<input type="submit" value="ログイン">
				<p></p>
			</form>

	</section>
</c:param>
</c:import>

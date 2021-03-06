<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>UserList画面</title>

	<style type="text/css">
		/* ========TAG LAYOUT======== */
		body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana, Helvetica, sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
		}
		table{
			text-align:center;
			margin:0 auto;
		}

		/* ========ID LAYOUT======== */
		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
		}
		#header{
			width:100%;
			height:80px;
			background-color:black;
		}
		#main{
			width:100%;
			height:500px;
			text-align:center;
		}
		#footer{
			width:100%;
			height:80px;
			background-color:black;
			clear:both;
		}
	</style>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>
		<div>
			<s:if test="userInfoDTOList == null || userInfoDTOList.isEmpty()">
				<h3>ユーザー情報がありません。</h3>
			</s:if>

			<s:else>
				<h3>ユーザー一覧</h3>
				<table border="1">
					<tr>
						<th>ログインID</th>
						<th>ログインPASS</th>
						<th>ユーザー名</th>
						<th>登録日時</th>
					</tr>

					<s:iterator value="userInfoDTOList">
						<tr>
							<td>
								<s:property value="loginUserId" />
							</td>
							<td>
								<s:property value="loginPassword" />
							</td>
							<td>
								<s:property value="userName" />
							</td>
							<td>
								<s:property value="insertDate" />
							</td>
						</tr>
					</s:iterator>
				</table>

				<s:form action="UserListDeleteConfirmAction">
					<s:submit value="削除" />
				</s:form>
			</s:else>

			<p>
				管理者画面に戻る場合は
				<a href="<s:url action='AdminAction' />">こちら</a>
			</p>
		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>
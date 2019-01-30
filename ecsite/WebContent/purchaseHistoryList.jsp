<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>PurchaseHistoryList画面</title>

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
			min-height:calc(100vh - 202px);	/* 202pxは次の合計 topのmargin(30px), pのmargin(12px), headerのheight(80px) footerのheight(80px) */
			text-align:center;
		}
		#footer{
			width:100%;
			height:80px;
			background-color:black;
			clear:both;
		}

		/* ========CLASS LAYOUT======== */
		.picture{
			width:400px;
			height:300px;
			background-color:#EFF8FB;
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
			<p>PurchaseHistoryList</p>
		</div>

		<div>
			<s:if test="phList == null || phList.isEmpty()">
				<h3>商品購入履歴情報はありません。</h3>
			</s:if>

			<s:else>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th>ふりがな</th>
						<th>商品画像</th>
						<th>発売会社名</th>
						<th>発売年月日</th>
						<th>値段</th>
						<th>個数</th>
						<th>合計金額</th>
					</tr>

					<s:iterator value="phList">
						<tr>
							<td><s:property value="itemName" /></td>
							<td>（ふりがな）</td>
							<td><img class="picture"></img></td>
							<td>（発売会社名）</td>
							<td>（発売年月日）</td>
							<td><s:property value="itemPrice" /></td>
							<td><s:property value="purchaseCount" /></td>
							<td><s:property value="totalPrice" /></td>
						</tr>
					</s:iterator>

				</table>

				<s:form action="PurchaseHistoryListDeleteAction">
					<s:submit value="履歴削除" />
				</s:form>
			</s:else>

			<p>
				HOMEに戻る場合は
				<a href="<s:url action='GoHomeAction' />">こちら</a>
			</p>
			<p>
				ログアウトする場合は
				<a href="<s:url action='LogoutAction' />">こちら</a>
			</p>

		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<meta http-equiv="Content-Script-Type" content="text/jacascript">
	<meta http-equiv="imagetoolbar" content="no">
	<meta name="description" content="">
	<meta name="keywords" content="">

	<title>ItemCreate画面</title>

	<style>
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
			<p>ItemCreate</p>
		</div>
		<div>
			<s:if test="errorMessage != null">
				<s:property value="errorMessage" />
			</s:if>

			<table>
				<s:form action="ItemCreateConfirmAction">
					<tr>
						<td>商品名:</td>
						<td>
							<input type="text" name="itemName" />
						</td>
					</tr>
					<tr>
						<td>価格:</td>
						<td>
							<input type="number" placeholder="0以上の整数を入力" min=0 name="itemPrice" />
							<span>円</span>
						</td>
					</tr>
					<tr>
						<td>在庫:</td>
						<td>
							<input type="number" placeholder="0以上の整数を入力" min=0 name="stock" />
							<span>個</span>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="登録" />
						</td>
					</tr>
				</s:form>
			</table>
			<span>前画面に戻る場合は
			<a href="<s:url action='AdminAction' />">こちら</a></span>
		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>BuyItemDetail画面</title>

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
			min-height:calc(100vh - 220px);	/* 220pxは次の合計 topのmargin(30px), headerのheight(80px), itemBoxのpadding(10px)とmargin(20px), footerのheight(80px) */
			text-align:center;
		}
		#footer{
			width:100%;
			height:80px;
			background-color:black;
			clear:both;
		}
		#itemBox{
			display:inline-block;
			width:200px;
			height:300px;
			background-color:#EFF8FB;
			padding:10px;
			margin:20px;
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
			<p>BuyItemDetail</p>
		</div>

		<div>
			<form>
				<table border="1">
					<tr>
						<th>商品名</th>
						<td><s:property value="itemName" /></td>
					</tr>
					<tr>
						<th>ふりがな</th>
						<td>(ふりがな)</td>
					</tr>
					<tr>
						<td colspan="2"><img src="./image/sample.jpg"></td>
					</tr>
					<tr>
						<th>値段</th>
						<td><s:property value="itemPrice" />円</td>
					</tr>
					<tr>
						<th>購入個数</th>
						<td>
							<select name="count">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>発売会社名</th>
						<td>(発売会社名)</td>
					</tr>
					<tr>
						<th>発売年月日</th>
						<td>(発売年月日)</td>
					</tr>
				</table>
				<p>商品の説明文 商品の説明文 商品の説明文 商品の説明文 商品の説明文</p>

				<input type="submit" value="カートに追加(未作成)">
			</form>
		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>
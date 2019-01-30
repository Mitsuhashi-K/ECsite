<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Script-Type" content="text/javascript">

	<title>BuyItemList画面</title>

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
		button {
			padding: 0;
			border: none;
		}
		button img {
			cursor: pointer;
			display: block;
		}
		button img:hover{
			opacity: 0.5;
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
			<p>BuyItemList</p>
		</div>

		<s:if test="buyItemList == null || buyItemList.isEmpty()">
			<p>検索結果がありません。</p>
		</s:if>

		<s:property value="buyItemList.dto" />

		<!-- 商品の出力回数をカウントする変数 -->
		<% int count = 0; %>

		<!-- buyItemListの要素の数(商品の数)だけ繰り返す処理 -->
		<s:iterator value="buyItemList">

			<div id="itemBox">
				<form action="BuyItemDetailAction">

					<input type="hidden" name="id" value="<s:property value='id' />">	<!-- 画像押下時に送られる商品のid -->

					<p>
						<s:property value="itemName" />
					</p>
					<p>(ふりがな)</p>
					<p>
						<!-- <input type="image" src="./image/sample.jpg"> -->	<!-- このタグを生かすと押下時にクリック位置の座標が送られる -->
						<button type="submit">
							<img src="./image/sample.jpg">
						</button>
					</p>

					<p><s:property value="itemPrice" />円</p>
				</form>
			</div>

			<!-- 商品を出力する度にcountを加算し、3の倍数の時に改行する -->
			<%
			count++;
			if(count % 3 == 0){
				out.print("<br>");
			}
			%>
		</s:iterator>

	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>
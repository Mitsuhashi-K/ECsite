<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ItemListDeleteConfirm画面</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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

	<!-- ボタン押下時の処理 formのaction属性に引数を指定してsubmitを実行 -->
	<script type="text/javascript">
		function submitAction(url){
			$('form').attr('action', url);
			$('form').submit();
		}
	</script>

</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>ItemListDeleteConfirm</p>
		</div>

		<div>
			<h3>すべての商品を削除します。よろしいですか？</h3>

			<!-- ボタン押下時の処理 formのaction属性に引数を指定してsubmitを実行 -->
			<form>
				<input type="button" value="ＯＫ"
				onclick="submitAction('ItemListDeleteCompleteAction')">
				<input type="button" value="キャンセル"
				onclick="submitAction('ItemListAction')">
			</form>
		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    	//サーブレットでセッションスコープに格納したユーザー情報
        //loginUserを取得する
        Login loginUser = (Login)session.getAttribute("loginUser");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶログイン</h1>
<% 
//もしセッションスコープから取得した情報がnullでなかった場合、
//ちゃんとユーザー情報が入っているから、成功！
if(loginUser != null) { %>
  <p>ログインに成功しました</p>
  <%//Login.javaServletのセッションスコープでloginUserとしてuserの値を格納
    //loginUserにはnameとpassが入っている。そのnameを取り出して表示 %>
  <p>ようこそ<%= loginUser.getName() %>さん</p>
  <a href="/docotsubu/Main">つぶやき投稿・閲覧へ</a>
  <% } else { %>
   <p>ログインに失敗しました</p>
   <a href="/docotsubu/">TOPへ</a>
  <% } %>
</body>
</html>
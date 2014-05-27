<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>本の検索</title>
    </head>
    <body>
        <h1>本の検索</h1><hr>

        本の検索を行います。<br>
        タイトルのキーワードを入力してください<br>
        <br>
        <form action="BookSeach" method="POST">
            <%
                String name = (String) session.getAttribute("name");
            %><br>
            <input name="name" type="text">
            <input type="submit" value="検索">

        </form>

    </body>
</html>
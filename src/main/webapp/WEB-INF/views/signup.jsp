<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/signup.css">
    <title>signup</title>
</head>
<body>
    <div id="container">
        <h1>회원가입 페이지</h1>
        <form action="/signup" method="post">
            <table>
                <tr>
                    <th>이름 </th>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>이메일 </th>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <th>아이디 </th>
                    <td><input type="text" class="username-input" name="username"></td>
                </tr>
                <tr>
                    <th>비밀번호 </th>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>
            <div class="button-group">
                <button type="submit" class="submit-button">가입하기</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </div>
</body>
</html>
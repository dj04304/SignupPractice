<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/signin.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js" ></script>
    <title>로그인</title>
</head>
<body>
    <div id="container">
        <h1>로그인</h1>
        <form action="">
            <div class="main-border">
                <div class="signin">
                    <table>
                        <tr>
                            <td><input type="text" name="username" placeholder="아이디"></td>
                        </tr>
                        <tr>
                            <td><input type="password" name="password" placeholder="비밀번호"></td>
                        </tr>
                    </table>
                    <button type="button" class="submit-button">로그인</button>
                </div>
                <ul>
                    <li class="signup">회원가입</li>
                    <li>아이디 찾기</li>
                    <li>비밀번호 찾기</li>
                </ul>
            </div>
        </form>
    </div>
    <script type="text/javascript" src="/static/js/signin.js"></script>
</body>
</html>
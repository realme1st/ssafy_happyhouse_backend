<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 수정</title>
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
 
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
    <!-- content start -->
    <form method="post" action="/user/update">
    <div class="bg-secondary p-5">
        <div class="container bg-light col-sm-6 rounded-lg p-4">
            <h3>정보 수정</h3>
            <label for="pw">비밀번호<span class="text-danger">*</span></label>
            <input type="password" class="form-control mb-2" name="pw" id="pw" placeholder="영문 숫자 포함 6자리 이상" value= "${user.pw }" required>
            <label for="name">이름<span class="text-danger">*</span></label>
            <input type="text" class="form-control mb-2" name="name" id="name" placeholder="User Name" value="${user.name }" required>
            <label for="addr">주소<span class="text-danger">*</span></label>
            <input type="text" class="form-control mb-2" name="address" id="addr" placeholder="address" value="${user.address }" required>
            <label for="phoneNm">전화번호<span class="text-danger">*</span></label>
            <input type="text" class="form-control mb-2" name="phoneNm" id="phoneNm" placeholder="010-xxx-xxxx" value="${user.phoneNm }" required>
            <div class="btn-group mt-2 btn-block">
                <button class="btn btn-primary" id="updateOk">수정 완료</button>
            </div>
        </div>
    </div>
    </form>
    <!-- content end-->

	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
<!-- fontawsome -->
<script src="https://kit.fontawesome.com/0481eabf73.js" crossorigin="anonymous"></script>
<!-- jQuery -->
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>
<script src="/js/info_update.js"></script>
</html>
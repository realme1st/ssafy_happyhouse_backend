<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보</title>
    <!-- bootstrap -->
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
    <!-- content -->
    <form method="post" action="/user/info" id="infoform">
    <div class="bg-secondary p-5">
        <div class="container bg-light col-sm-6 rounded-lg p-4">
            <h3>회원 정보</h3>
            <h2>${user.id }</h2>
            <label for="id">아이디</label>
            <input type="text" class="form-control mb-2" name="id" id="id"  value ="${user.id }" readonly>
            <label for="pw">비밀번호</label>
            <input type="password" class="form-control mb-2" name="pw" id="pw" value="${user.pw }" readonly>
            <label for="name">이름</label>
            <input type="text" class="form-control mb-2" name="name" id="name" value="${user.name }" readonly>
            <label for="addr">주소</label>
            <input type="text" class="form-control mb-2" name="addr" id="addr" value="${user.address }" readonly>
            <label for="phoneNm">전화번호</label>
            <input type="text" class="form-control mb-2" name="phoneNm" id="phoneNm" value="${user.phoneNm }" readonly>
            <div class="btn-group">
            
                <button type="button" id ="modify" class="btn btn-primary mr-3">수정</button>
                
                <button class="btn btn-success" id="user_Resign"
                                onclick="javascript: form.action='/user/resign';">탈퇴하기</button>
            </div>
        </div>
    </div>
    </form>
    <!-- content end-->

	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$("#modify").on("click", function() {
	
	$("#action").val("modifyform");
	$("#infoform").submit();
	
})
$("#delete").on("click", function() {
	$("#action").val("delete");
	$("#infoform").submit();
})
</script>



<!-- fontawsome -->
<script src="https://kit.fontawesome.com/0481eabf73.js" crossorigin="anonymous"></script>
<!-- jQuery -->
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>

</html>
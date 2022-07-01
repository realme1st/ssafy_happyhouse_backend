<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>happyhouse</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=070a3160964fea1eeeda8858dac29a89"></script>
    
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
    <section>
        <div class="container mt-3 mb-3">
            <ul class="nav justify-content-lg-center">
                <li class="nav-item mr-5">
                    <h2><a href="/house">실거래가</a></h2>
                </li>
                <li class="nav-item">
                    <h2><a href="hospital.jsp">안심병원</a></h2>
                </li>
            </ul>
            <div id="map" style="height:500px"></div> 
    	</div>
    </section>
    
	
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
<!-- fontawsome -->
<script src="https://kit.fontawesome.com/0481eabf73.js" crossorigin="anonymous"></script>
<!-- jQuery -->
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>
<script src="/js/main.js"></script>
</html>
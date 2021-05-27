<!DOCTYPE html>
<%@page import="com.ZhangZihao.model.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//.println(basePath);
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | E-Shopper</title>
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/prettyPhoto.css" rel="stylesheet">
    <link href="<%=basePath%>css/price-range.css" rel="stylesheet">
    <link href="<%=basePath%>css/animate.css" rel="stylesheet">
	<link href="<%=basePath%>css/main.css" rel="stylesheet">
	<link href="<%=basePath%>css/responsive.css" rel="stylesheet">

	<link href="<%=basePath%>css/userUpdate.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="<%=basePath%>js/html5shiv.js"></script>
    <script src="<%=basePath%>js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="<%=basePath%>images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=basePath%>images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=basePath%>images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=basePath%>images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->
<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> info@ecjtu.com</a></li>
								<li><a href="#"><i class="fa fa-user"></i> Welcome,${ empty sessionScope.user.userName ? "Guest":sessionScope.user.userName}
  									</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-md-4 clearfix">
						<div class="logo pull-left">
							<a href="Home"><img src="<%=basePath%>images/home/logo.png" alt="" /></a>
						</div>
						<div class="btn-group pull-right clearfix">
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									CN
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="">Canada</a></li>
									<li><a href="">UK</a></li>
								</ul>
							</div>
							
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									RMB
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="">Canadian Dollar</a></li>
									<li><a href="">Pound</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-md-8 clearfix">
						<div class="shop-menu clearfix pull-right">
							<ul class="nav navbar-nav">
								<li><a href="<%=basePath%>UpDateUser"><i class="fa fa-user"></i> Account</a></li>
								
								
								<li><a href="<%=basePath%>myCart"><i class="fa fa-shopping-cart"></i> Cart</a></li>
								<li><a href="<%=basePath%>register"><i class="fa fa-crosshairs"></i> Register</a></li>
								<li><a href="<%=basePath%>login"><i class="fa fa-lock"></i> Login</a></li>

								<%
									if(session.getAttribute("user")!=null)
									{
								%>
								<li><a href="<%=basePath%>logout"><i class="fa fa-unlock"></i> Logout</a></li>
								<%
									}
								%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="<%=basePath%>Home" class="active">Home</a></li>
								<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="<%=basePath%>shop">Products</a></li>
										<!--<li><a href="product-details.html">Product Details</a></li>  -->
										<li><a href="<%=basePath%>myCart">Cart</a></li> 
										<li><a href="<%=basePath%>order">Order</a></li>
										
										<%-- <li><a href="<%=basePath%>login">Login</a></li>  --%>
                                    </ul>
                                </li> 
								
								<!--<li><a href="404.html">404</a></li>-->
								<li><a href="<%=basePath%>contactUs">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
					<form method="get" target='_blank' action="<%=basePath%>search" style="width: 426px; ">
							<input type="text" name="search" placeholder="search"/>
							<select name="way" style="width:65px; ">
   										 <option value="Baidu">Baidu</option>
  										  <option value="Bing">Bing</option>
  										  <option value="Sogou">Sogou</option>

 									   </select>&nbsp;<button type="submit"><i class="fa fa-search"></i></button>
							 </form>
								<!--<input type="text" placeholder="Search"/>-->
						
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->

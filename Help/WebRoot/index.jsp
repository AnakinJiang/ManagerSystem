<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-us">
    <head>
    	<title>欢迎页面</title>

    	<!-- meta -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!-- stylesheet -->
        <link rel="stylesheet" href="guidePage/css/bootstrap.min.css">
        <link rel="stylesheet" href="guidePage/css/font-awesome.min.css">
        <link rel="stylesheet" href="guidePage/css/owl.carousel.css">
		<link rel="stylesheet" href="guidePage/css/owl.theme.min.css">
        <link rel="stylesheet" href="guidePage/css/animate.css">
		<link rel="stylesheet" href="guidePage/css/main.css">

		<!-- google font -->
        <link href='http://fonts.useso.com/css?family=Oswald:300,400' rel='stylesheet'>
        <link href='http://fonts.useso.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <link href='http://fonts.useso.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href='http://fonts.useso.com/css?family=Roboto+Condensed:400,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.useso.com/css?family=Oxygen:400,300' rel='stylesheet' type='text/css'>
        <link href="http://fonts.useso.com/css?family=Rouge+Script" rel="stylesheet" type="text/css">
        <link href='http://fonts.useso.com/css?family=Milonga' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="content-block" id="header">
            <div id="overlay-1">
                <header id="site-header" class="clearfix">
                    <div class="pull-left">
                        <h1><a href="#">Clouds Help</a></h1>
                    </div>
                    <div class="pull-right">
                        <nav class="navbar site-nav" role="navigation">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                    <i class="fa fa-bars fa-2x"></i>
                                </button>
                            </div>

                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav">
                                    <li class="active"><a href="#header" style="font-family:SimHei;color:white"><i class="fa fa-home"></i>&nbsp;主页</a></li>
                                 
                                </ul>
                            </div>  <!-- /.navbar-collapse -->
                        </nav>
                    </div>
                </header>	<!-- site-header -->
                
                <div class="middle text-center clearfix">
                    <div class="container"><!-- 大标题 -->
                        <h1 class="pro-name">Clouds Help</h1>
                        <p class="tagline">短时招募平台</p>
                        <br>
                        <div class="skills">
                        </div>  <!-- skills -->
                        <a href="MerchantLogin.jsp" target="_parent" class="btn btn-lg btn-hire wow animated zoomIn"> 商家入口 </a>
                        <br><br><br>
                        <a href="EmployeeLogin.jsp" target="_parent" class="btn btn-lg btn-hire wow animated zoomIn">受雇者入口</a>
                    </div>  <!-- container -->
                </div>  <!-- middle -->
                
                <div class="bottom text-center">
                    <a href="#portfolio"><i class="fa fa-angle-down fa-3x pulse"></i></a>
                </div>
            </div>  <!-- overlay-1 -->
        </div>  <!-- content-block -->

        

        <footer id="site-footer">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="copyright">
                        	<p>Copyright &copy; 2016 Clouds Help项目开发小组</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer><!-- site-footer -->

        <!-- js -->
        <script>
            new WOW().init();
        </script>

        <script src="guidePage/js/jquery-2.1.3.min.js"></script>
        <script src="guidePage/js/bootstrap.min.js"></script>
        <script src="guidePage/js/jquery.actual.min.js"></script>
        <script src="guidePage/js/isotope.pkgd.min.js"></script>
        <script src="guidePage/js/owl.carousel.min.js"></script>
        <script src="guidePage/js/jquery.isonscreen.js"></script>
        <script src="guidePage/js/main.js"></script>

        <script>
        	$(document).ready(function(){
  				$('.owl-carousel').owlCarousel({
    				loop:true,
    				margin:10,
    				autoplay:true,
    				autoplayTimeout:3000,
    				autoplayHoverPause:true,
    				responsiveClass:true,
    				responsive:{
        					0:{
					            items:1,
        					},
					        600:{
					            items:1,
					        },
					        1000:{
					            items:1,
					        }
    				}
				})
			});
        </script>
        
	</body>
</html>

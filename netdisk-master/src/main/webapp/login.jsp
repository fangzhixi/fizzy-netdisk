<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh">

<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <title>网盘盒子</title>

   <!-- Favicon -->
   <link rel="shortcut icon" href="/assets/images/favicon.ico" />

   <link rel="stylesheet" href="/assets/css/backend.min.css">
   <link rel="stylesheet" href="/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
   <link rel="stylesheet" href="/assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">
   <link rel="stylesheet" href="/assets/vendor/remixicon/fonts/remixicon.css">

   <!-- Viewer Plugin -->
   <!--PDF-->
   <link rel="stylesheet" href="/assets/vendor/doc-viewer/include/pdf/pdf.viewer.css">
   <!--Docs-->
   <!--PPTX-->
   <link rel="stylesheet" href="/assets/vendor/doc-viewer/include/PPTXjs/css/pptxjs.css">
   <link rel="stylesheet" href="/assets/vendor/doc-viewer/include/PPTXjs/css/nv.d3.min.css">
   <!--All Spreadsheet -->
   <link rel="stylesheet" href="/assets/vendor/doc-viewer/include/SheetJS/handsontable.full.min.css">
   <!--Image viewer-->
   <link rel="stylesheet"
      href="/assets/vendor/doc-viewer/include/verySimpleImageViewer/css/jquery.verySimpleImageViewer.css">
   <!--officeToHtml-->
   <link rel="stylesheet" href="/assets/vendor/doc-viewer/include/officeToHtml/officeToHtml.css">
</head>

<body class=" ">
   <!-- loader Start -->
   <div id="loading">
      <div id="loading-center">
      </div>
   </div>
   <!-- loader END -->



   <div class="wrapper">
      <section class="login-content">
         <div class="container h-100">
            <div class="row justify-content-center align-items-center height-self-center">
               <div class="col-md-5 col-sm-12 col-12 align-self-center">
                  <div class="sign-user_card">
                     <img src="/assets/images/logo.png" class="img-fluid rounded-normal light-logo logo" alt="logo">
                     <img src="/assets/images/logo-white.png" class="img-fluid rounded-normal darkmode-logo logo"
                        alt="logo">
                     <h3 class="mb-3">登入</h3>
                     <form id="loginForm" name="loginForm" action="AmainPage" method="post">
                        <div class="row">
                           <div class="col-lg-12">
                              <div class="floating-label form-group">
                                 <input id="user_id" class="text floating-input form-control" type="text" placeholder="">
                                 <label>邮箱 / 电话</label>
                              </div>
                           </div>
                           <div class="col-lg-12">
                              <div class="floating-label form-group">
                                 <input id="password" class="text floating-input form-control" type="password" placeholder="">
                                 <label>密码</label>
                              </div>
                           </div>
                           <div class="col-lg-6">
                              <div class="custom-control custom-checkbox mb-3 text-left">
                                 <input type="checkbox" class="custom-control-input" id="customCheck1">
                                 <label class="custom-control-label" for="customCheck1">保持登录</label>
                              </div>
                           </div>
                           <div class="col-lg-6">
                              <a href="auth-recoverpw.html" class="text-primary float-right">忘记密码?</a>
                           </div>
                        </div>
                        <a id="submit" class="act-but submit btn btn-primary btn-block" onclick="submit()" target="_self" style="color: #FFFFFF">登录</a>
                        <p class="mt-3">
                           创建一个帐户 <a href="/register" class="text-primary">注册</a>
                        </p>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </section>
   </div>
   <!-- Jquery JavaScript -->
   <script type="text/javascript" src="/assets/js/jquery.min.js"></script>

   <!-- Backend Bundle JavaScript -->
   <script src="/assets/js/backend-bundle.min.js"></script>

   <!-- Chart Custom JavaScript -->
   <script src="/assets/js/customizer.js"></script>

   <!-- Chart Custom JavaScript -->
   <script src="/assets/js/chart-custom.js"></script>

   <!--PDF-->
   <script src="/assets/vendor/doc-viewer/include/pdf/pdf.js"></script>
   <!--Docs-->
   <script src="/assets/vendor/doc-viewer/include/docx/jszip-utils.js"></script>
   <script src="/assets/vendor/doc-viewer/include/docx/mammoth.browser.min.js"></script>
   <!--PPTX-->
   <script src="/assets/vendor/doc-viewer/include/PPTXjs/js/filereader.js"></script>
   <script src="/assets/vendor/doc-viewer/include/PPTXjs/js/d3.min.js"></script>
   <script src="/assets/vendor/doc-viewer/include/PPTXjs/js/nv.d3.min.js"></script>
   <script src="/assets/vendor/doc-viewer/include/PPTXjs/js/pptxjs.js"></script>
   <script src="/assets/vendor/doc-viewer/include/PPTXjs/js/divs2slides.js"></script>
   <!--All Spreadsheet -->
   <script src="/assets/vendor/doc-viewer/include/SheetJS/handsontable.full.min.js"></script>
   <script src="/assets/vendor/doc-viewer/include/SheetJS/xlsx.full.min.js"></script>
   <!--Image viewer-->
   <script src="/assets/vendor/doc-viewer/include/verySimpleImageViewer/js/jquery.verySimpleImageViewer.js"></script>
   <!--officeToHtml-->
   <script src="/assets/vendor/doc-viewer/include/officeToHtml/officeToHtml.js"></script>
   <script src="/assets/js/doc-viewer.js"></script>
   <!-- app JavaScript -->
   <script src="/assets/js/app.js"></script>

   <script type="text/javascript">
      var int;//定时器

      document.getElementById("user_id").addEventListener("keyup", function(event) {
         event.preventDefault();
         if (event.keyCode === 13) {
            document.getElementById("submit").click();
         }
      });
      document.getElementById("password").addEventListener("keyup", function(event) {
         event.preventDefault();
         if (event.keyCode === 13) {
            document.getElementById("submit").click();
         }
      });

      function submit(){
         var user_id = document.getElementById("user_id");
         var password = document.getElementById("password");
         var submit = document.getElementById("submit")
         if(user_id.value.length <= 0){
            clearInterval(int);
            submit.style.background = "#eb445a";
            submit.style.borderColor = "#eb445a";
            submit.innerHTML = "账号不能为空";
            int = setInterval(function() {
               submit.style.background = "#8f93f6";
               submit.style.borderColor = "#8f93f6";
               submit.innerHTML = "登陆";
            }, 2000)
         }
         else if(password.value.length <= 0){
            clearInterval(int);
            submit.style.background = "#eb445a";
            submit.style.borderColor = "#eb445a";
            submit.innerHTML = "密码不能为空";
            int = setInterval(function() {
               submit.style.background = "#8f93f6";
               submit.style.borderColor = "#8f93f6";
               submit.innerHTML = "登陆";
            }, 2000)
         }
         //进行表单数据校验，校验成功提交到登录servlet，校验失败不提交
         else{
            sessionStorage.clear();
            sessionStorage.setItem("fizzy_netdisk_user_id", user_id.value);
            sessionStorage.setItem("fizzy_netdisk_password", password.value);
            var cookieValue = "user_id=" + sessionStorage.getItem("fizzy_netdisk_user_id") + "; password=" + sessionStorage.getItem("fizzy_netdisk_password");
            //alert("fizzy_netdisk_user_id" + sessionStorage.getItem("fizzy_netdisk_user_id") + "\nfizzy_netdisk_password" + sessionStorage.getItem("fizzy_netdisk_password") + "\nuser_id" + user_id.value + "\npassword" + password.value  + "\ncookieValue" + cookieValue);

            document.cookie = "user_id=" + sessionStorage.getItem("fizzy_netdisk_user_id");
            document.cookie = "password=" + sessionStorage.getItem("fizzy_netdisk_password");
            $("#loginForm").submit();//使用jQuery提交表单
         }
      }

      window.onload = function(){
         var phone_input = document.getElementById("user_id");
         var password = document.getElementById("password");
         var submit = document.getElementById("submit")
         var user_id = null;
         var notPass = false;
         // ${user_id }
         // ${notPass }
         if(notPass){
            phone_input.value = user_id;
            clearInterval(int);
            submit.style.background = "#eb445a";
            submit.style.borderColor = "#eb445a";
            submit.innerHTML = "账号或密码不正确";
            int = setInterval(function() {
               submit.style.background = "#8f93f6";
               submit.style.borderColor = "#8f93f6";
               submit.innerHTML = "登陆";
            }, 2000)
         }
      }
   </script>
</body>

</html>
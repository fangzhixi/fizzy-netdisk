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
                     <h3 class="mb-3">注册</h3>
                     <p style="color: #8f93f6;">创建专属你的个人用户</p>
                     <form action="/sign-in" method="post">
                        <div class="row">
                           <div class="col-lg-12">
                              <div class="floating-label form-group">
                                 <input name="user-id" class="floating-input form-control" type="text" placeholder=" ">
                                 <label>邮箱 / 电话</label>
                              </div>
                           </div>
                           <div class="col-lg-6">
                              <div class="floating-label form-group">
                                 <input id="user-id" name="password" class="floating-input form-control" type="password" placeholder=" ">
                                 <label>密码</label>
                              </div>
                           </div>
                           <div class="col-lg-6">
                              <div class="floating-label form-group">
                                 <input id="password" class="floating-input form-control" type="password" placeholder=" ">
                                 <label>确认密码</label>
                              </div>
                           </div>
                           <div class="col-lg-12">
                              <div class="custom-control custom-checkbox mb-3 text-left">
                                 <input type="checkbox" class="custom-control-input" id="customCheck1">
                                 <label class="custom-control-label" for="customCheck1">我已阅读并同意</label>
                                 <a href="auth-sign-in.html" class="text-primary">用户须知</a>
                              </div>
                           </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">注册</button>
                        <p class="mt-3">
                           已有账号? <a href="auth-sign-in.html" class="text-primary">&nbsp;前往登录</a>
                        </p>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </section>
   </div>

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
</body>
</html>
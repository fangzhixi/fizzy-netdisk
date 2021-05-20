﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <title>网盘盒子</title>
      
      <!-- Favicon -->
      <link rel="shortcut icon" href="assets/images/favicon.ico" />

      <link rel="stylesheet" href="assets/css/iconfont.css">
      <link rel="stylesheet" href="assets/css/backend.min.css">
      <link rel="stylesheet" href="assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
      <link rel="stylesheet" href="assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">
      <link rel="stylesheet" href="assets/vendor/remixicon/fonts/remixicon.css">
      
      <!-- Viewer Plugin -->
        <!--PDF-->
        <link rel="stylesheet" href="assets/vendor/doc-viewer/include/pdf/pdf.viewer.css">
        <!--Docs-->
        <!--PPTX-->
        <link rel="stylesheet" href="assets/vendor/doc-viewer/include/PPTXjs/css/pptxjs.css">
        <link rel="stylesheet" href="assets/vendor/doc-viewer/include/PPTXjs/css/nv.d3.min.css">
        <!--All Spreadsheet -->
        <link rel="stylesheet" href="assets/vendor/doc-viewer/include/SheetJS/handsontable.full.min.css">
        <!--Image viewer-->
        <link rel="stylesheet" href="assets/vendor/doc-viewer/include/verySimpleImageViewer/css/jquery.verySimpleImageViewer.css">
        <!--officeToHtml-->
        <link rel="stylesheet" href="assets/vendor/doc-viewer/include/officeToHtml/officeToHtml.css">  </head>
  <body class="  ">
    <!-- loader Start -->
    <div id="loading">
          <div id="loading-center">
          </div>
    </div>
    <!-- loader END -->
    <!-- Wrapper Start -->
    <div class="wrapper">

      <div class="iq-sidebar  sidebar-default ">
          <div class="iq-sidebar-logo d-flex align-items-center justify-content-between">
              <a href="main.jsp" class="header-logo">
                  <img src="assets/images/logo.png" class="img-fluid rounded-normal light-logo" alt="logo">
                  <img src="assets/images/logo-white.png" class="img-fluid rounded-normal darkmode-logo" alt="logo">
              </a>
              <div class="iq-menu-bt-sidebar">
                  <i class="las la-bars wrapper-menu"></i>
              </div>
          </div>
          <div class="data-scrollbar" data-scroll="1">
              <nav class="iq-sidebar-menu">
                  <ul id="iq-sidebar-toggle" class="iq-menu">
                       <li class="active">
                              <a href="main.jsp" class="">
                                  <i class="las la-home iq-arrow-left"></i><span>首页</span>
                              </a>
                          <ul id="dashboard" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                          </ul>
                       </li>
                       <li class=" ">
                              <a href="#files-list" class="collapsed" data-toggle="collapse" aria-expanded="false">
                                  <i class="lar la-file-alt iq-arrow-left"></i><span>文件分类</span>
                                  <i class="las la-angle-right iq-arrow-right arrow-active"></i>
                                  <i class="las la-angle-down iq-arrow-right arrow-hover"></i>
                              </a>
                          <ul id="files-list" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                              <li class=" ">
                                  <a href="page-alexa.html">
                                      <span class="icon iconfont iconword"></span><span>Word&nbsp;文档</span>
                                  </a>
                              </li>
                              <li class=" ">
                                  <a href="page-android.html">
                                      <span class="icon iconfont iconexcel"></span><span>Excel&nbsp;表格</span>
                                  </a>
                              </li>
                              <li class=" ">
                                  <a href="page-brightspot.html">
                                      <span class="icon iconfont iconpptx"></span><span>PPT&nbsp;幻灯片</span>
                                  </a>
                              </li>
                              <li class=" ">
                                  <a href="page-ionic.html">
                                      <span class="icon iconfont iconpdf"></span><span>PDF&nbsp;电子书</span>
                                  </a>
                              </li>
                              <li class=" ">
                                  <a href="page-ionic.html">
                                      <span class="icon iconfont iconmedia-photo"></span><span>Photo&nbsp;照片</span>
                                  </a>
                              </li>
                              <li class=" ">
                                  <a href="page-ionic.html">
                                      <span class="icon iconfont iconmedia"></span><span>Media&nbsp;视频</span>
                                  </a>
                              </li>
                              <li class=" ">
                                  <a href="page-ionic.html">
                                      <span class="icon iconfont iconaudio"></span><span>Audio&nbsp;音乐</span>
                                  </a>
                              </li>
                              <li class=" ">
                                  <a href="page-ionic.html">
                                      <span class="icon iconfont iconzip"></span><span>ZIP&nbsp;压缩包</span>
                                  </a>
                              </li>
                              <li class=" ">
                                  <a href="page-ionic.html">
                                      <span class="icon iconfont iconfolder"></span><span>Folder&nbsp;文件夹</span>
                                  </a>
                              </li>
                          </ul>
                       </li>
                       <li class=" ">
                              <a href="page-folders.html" class="">
                                  <i class="las la-stopwatch iq-arrow-left"></i><span>历史记录</span>
                              </a>
                          <ul id="page-folders" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                          </ul>
                       </li>
                       <li class=" ">
                              <a href="page-favourite.html" class="">
                                  <i class="lar la-star"></i><span>我的收藏</span>
                              </a>
                          <ul id="page-fevourite" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                          </ul>
                       </li>
                      <li class=" ">
                          <a href="#user" class="collapsed" data-toggle="collapse" aria-expanded="false">
                              <i class="las la-user-cog"></i><span>用户中心</span>
                              <i class="las la-angle-right iq-arrow-right arrow-active"></i>
                              <i class="las la-angle-down iq-arrow-right arrow-hover"></i>
                          </a>
                          <ul id="user" class="iq-submenu collapse" data-parent="#otherpage">
                              <li class=" ">
                                  <a href="user-profile.html">
                                      <i class="las la-id-card"></i><span>个人信息</span>
                                  </a>
                              </li>
                              <li class=" ">
                                  <a href="user-add.html">
                                      <i class="las la-user-plus"></i><span>添加好友</span>
                                  </a>
                              </li>
                              <li class=" ">
                                  <a href="user-list.html">
                                      <i class="las la-list-alt"></i><span>好友列表</span>
                                  </a>
                              </li>
                          </ul>
                      </li>
                      <li class=" ">
                          <a href="pages-maintenance.html">
                              <i class="las la-cubes"></i><span>文件共享</span>
                          </a>
                      </li>
                       <li class=" ">
                              <a href="page-delete.html" class="">
                                  <i class="las la-trash-alt iq-arrow-left"></i><span>回收站</span>
                              </a>
                          <ul id="page-delete" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                          </ul>
                       </li>
                       <li class=" ">
                          <a href="#otherpage" class="collapsed" data-toggle="collapse" aria-expanded="false">
                              <i class="lab la-wpforms iq-arrow-left"></i><span>发现</span>
                              <i class="las la-angle-right iq-arrow-right arrow-active"></i>
                              <i class="las la-angle-down iq-arrow-right arrow-hover"></i>
                          </a>
                          <ul id="otherpage" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                                  <li class=" ">
                                      <a href="#auth" class="collapsed" data-toggle="collapse" aria-expanded="false">
                                          <i class="las la-torah iq-arrow-left"></i><span>账号设置</span>
                                          <i class="las la-angle-right iq-arrow-right arrow-active"></i>
                                          <i class="las la-angle-down iq-arrow-right arrow-hover"></i>
                                      </a>
                                      <ul id="auth" class="iq-submenu collapse" data-parent="#otherpage">
                                              <li class=" ">
                                                  <a href="auth-recoverpw.html">
                                                      <i class="las la-unlock-alt"></i><span>重设密码</span>
                                                  </a>
                                              </li>
                                              <li class=" ">
                                                  <a href="auth-confirm-mail.html">
                                                      <i class="las la-envelope-square"></i><span>邮箱绑定</span>
                                                  </a>
                                              </li>
                                              <li class=" ">
                                                  <a href="auth-lock-screen.html">
                                                      <i class="las la-lock"></i><span>锁定账号</span>
                                                  </a>
                                              </li>
                                      </ul>
                                  </li>
                                  <li class=" ">
                                  <a href="https://www.speedtest.net/" class="" target="_blank">
                                      <span class="iconfont icondashboard"></span><span>网速测试</span>
                                  </a>
                                  <ul id="page-speed" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                                  </ul>
                              </li>
                          </ul>
                       </li>
                  </ul>
              </nav>
              <div class="sidebar-bottom">
                  <h4 class="mb-3"><i class="las la-cloud mr-2"></i>云端盒子</h4>
                  <p>17.1 GB / 20 GB 容量</p>
                  <div class="iq-progress-bar mb-3">
                      <span class="bg-primary iq-progress progress-1" data-percent="67">
                      </span>
                  </div>
                  <p>75% 已用 - 31.9 GB 空闲</p>
              </div>
              <div class="p-3"></div>
          </div>
          </div>       <div class="iq-top-navbar">
          <div class="iq-navbar-custom">
              <nav class="navbar navbar-expand-lg navbar-light p-0">
              <div class="iq-navbar-logo d-flex align-items-center justify-content-between">
                  <i class="ri-menu-line wrapper-menu"></i>
                  <a href="main.jsp" class="header-logo">
                      <img src="assets/images/logo.png" class="img-fluid rounded-normal light-logo" alt="logo">
                      <img src="assets/images/logo-white.png" class="img-fluid rounded-normal darkmode-logo" alt="logo">
                  </a>
              </div>
                  <div class="iq-search-bar device-search">
                      
                      <form>
                          <div class="input-prepend input-append">
                              <div class="btn-group">
                                  <label class="dropdown-toggle searchbox" data-toggle="dropdown">
                                  <input class="dropdown-toggle search-query text search-input" type="text"  placeholder="搜点什么吧..." value=""><span class="search-replace"></span>
                                  <a class="search-link" href="#"><i class="ri-search-line"></i></a>
                                  <span class="caret"><!--icon--></span>
                                  </label>
                                  <ul class="dropdown-menu">
                                      <li><a href="#"><div class="item"><i class="far fa-file-pdf bg-info"></i>PDF电子书</div></a></li>
                                      <li><a href="#"><div class="item"><i class="far fa-file-alt bg-primary"></i>文档</div></a></li>
                                      <li><a href="#"><div class="item"><i class="far fa-file-excel bg-success"></i>表格</div></a></li>
                                      <li><a href="#"><div class="item"><i class="far fa-file-powerpoint bg-danger"></i>幻灯片</div></a></li>
                                      <li><a href="#"><div class="item"><i class="far fa-file-image bg-warning"></i>图片</div></a></li>
                                      <li><a href="#"><div class="item"><i class="far fa-file-video bg-info"></i>视频</div></a></li>
                                  </ul>
                              </div>
                          </div>
                      </form>
                  </div>
      
                  <div class="d-flex align-items-center">
                      <div class="change-mode">
                          <div class="custom-control custom-switch custom-switch-icon custom-control-inline">
                              <div class="custom-switch-inner">
                                  <p class="mb-0"> </p>
                                  <input type="checkbox" class="custom-control-input" id="dark-mode" data-active="true">
                                  <label class="custom-control-label" for="dark-mode" data-mode="toggle">
                                      <span class="switch-icon-left"><i class="a-left"></i></span>
                                      <span class="switch-icon-right"><i class="a-right"></i></span>
                                  </label>
                              </div>
                          </div>
                      </div>
                      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"  aria-label="Toggle navigation">
                      <i class="ri-menu-3-line"></i>
                      </button>
                      <div class="collapse navbar-collapse" id="navbarSupportedContent">
                          <ul class="navbar-nav ml-auto navbar-list align-items-center">
                          <li class="nav-item nav-icon search-content">
                              <a href="#" class="search-toggle rounded" id="dropdownSearch" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  <i class="ri-search-line"></i>
                              </a>
                              <div class="iq-search-bar iq-sub-dropdown dropdown-menu" aria-labelledby="dropdownSearch">
                                  <form action="#" class="searchbox p-2">
                                      <div class="form-group mb-0 position-relative">
                                      <input type="text" class="text search-input font-size-12" placeholder="type here to search...">
                                      <a href="#" class="search-link"><i class="las la-search"></i></a> 
                                      </div>
                                  </form>
                              </div>
                          </li> 
                          <li class="nav-item nav-icon dropdown">
                              <a href="#" class="search-toggle dropdown-toggle" id="dropdownMenuButton01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <i class="ri-question-line"></i>
                              </a>
                              <div class="iq-sub-dropdown dropdown-menu" aria-labelledby="dropdownMenuButton01">
                                  <div class="card shadow-none m-0">
                                      <div class="card-body p-0 ">
                                          <div class="p-3">
                                              <a href="#" class="iq-sub-card"><i class="ri-refresh-line"></i>检查更新</a>
                                              <a href="#" class="iq-sub-card"><i class="ri-feedback-line"></i>反馈</a>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </li>
                          <li class="nav-item nav-icon dropdown"> 
                              <a href="#" class="search-toggle dropdown-toggle" id="dropdownMenuButton02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
                              <i class="ri-settings-3-line"></i>
                              </a>
                              <div class="iq-sub-dropdown dropdown-menu" aria-labelledby="dropdownMenuButton02">
                                  <div class="card shadow-none m-0">
                                      <div class="card-body p-0 ">
                                          <div class="p-3">
                                              <a href="#" class="iq-sub-card pt-0"><i class="ri-settings-3-line"></i> 设置</a>
                                              <a href="#" class="iq-sub-card"><i class="ri-hard-drive-line"></i> 设置桌面快捷图标</a>
                                          </div>                                
                                      </div>
                                  </div>
                              </div>
                          </li>
                          <li class="nav-item nav-icon dropdown caption-content">
                              <a href="#" class="search-toggle dropdown-toggle" id="dropdownMenuButton03" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
                                  <div class="caption bg-primary line-height">P</div>
                              </a>
                              <div class="iq-sub-dropdown dropdown-menu" aria-labelledby="dropdownMenuButton03">
                                  <div class="card mb-0">
                                      <div class="card-header d-flex justify-content-between align-items-center mb-0">
                                      <div class="close-data text-right badge badge-primary cursor-pointer "><i class="ri-close-fill"></i></div>
                                      </div>
                                      <div class="card-body">
                                          <div class="profile-header">
                                              <div class="cover-container text-center">
                                                  <div class="rounded-circle profile-icon bg-primary mx-auto d-block">
                                                      P                                                    
                                                      <a href="">
                                                          
                                                      </a>
                                                  </div>
                                                  <div class="profile-detail mt-3">
                                                  <h5><a href="user-profile-edit.html">Panny Marco</a></h5>
                                                  <p><a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="1c6c7d727265717d6e7f735c7b717d7570327f7371">邮箱&#160;尚未绑定</a></p>
                                                  </div>
                                                  <a href="auth-sign-in.html" class="btn btn-primary">登出</a>
                                              </div>
                                              <div class="profile-details mt-4 pt-4 border-top">
                                                  <div class="media align-items-center mb-3">
                                                      <div class="rounded-circle iq-card-icon-small bg-primary">
                                                          A
                                                      </div>
                                                      <div class="media-body ml-3">
                                                          <div class="media justify-content-between">
                                                              <h6 class="mb-0">Anna Mull</h6>
                                                              <a href="main.jsp" class="mb-0 font-size-12"><i>切换账户</i></a>
                                                          </div>
                                                          <p class="mb-0 font-size-12" style="color: #8f93f6;">[email&#160;protected]</p>
                                                      </div>                                                 
                                                  </div>
                                                  <div class="media align-items-center mb-3">
                                                      <div class="rounded-circle iq-card-icon-small bg-success">
                                                          K
                                                      </div>
                                                      <div class="media-body ml-3">
                                                          <div class="media justify-content-between">
                                                              <h6 class="mb-0">King Poilin</h6>
                                                              <a href="main.jsp" class="mb-0 font-size-12"><i>切换账户</i></a>
                                                          </div>
                                                          <p class="mb-0 font-size-12" style="color: #8f93f6;">[email&#160;protected]</p>
                                                      </div>
                                                  </div>
                                                  <div class="media align-items-center">
                                                      <div class="rounded-circle iq-card-icon-small bg-danger">
                                                          D
                                                      </div>
                                                      <div class="media-body ml-3">
                                                          <div class="media justify-content-between">
                                                              <h6 class="mb-0">Devid Worner</h6>
                                                              <a href="main.jsp" class="mb-0 font-size-12"><i>切换账户</i></a>
                                                          </div>
                                                          <p class="mb-0 font-size-12" style="color: #8f93f6;">[email&#160;protected]</p>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </li>
                          </ul>                     
                      </div> 
                  </div>
              </nav>
          </div>
      </div>
      <div class="content-page">
        <div class="container-fluid">
            <div class="row">
               <div class="col-sm-12 col-lg-12">




















                  <div class="card">
                    <div class="card-header d-flex justify-content-between">
                       <div class="header-title">
                          <h4 class="card-title">文件上传</h4>
                       </div>
                    </div>
                    <div class="card-body">



                        <div class="progress mb-3">
                            <div id="progressBar" class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="width: 0%"></div>
                         </div>

                        <span id="percentage"></span><span id="time"></span>
                    
                        <br /><br />
                    
                        <form enctype="multipart/form-data">
                            <input type="file" id="file" name="file" />

                            <input type="button" onclick="UpladFile()" value="上传" />

                            <input type="button" onclick="cancleUploadFile()" value="取消" />
                        </form>





                        
                    </div>
                 </div>




































               </div>
            </div>
         </div>
       </div>
    <!-- Wrapper End-->
    <footer class="iq-footer">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 text-right" >
                    <span>开源地址: </span>
                    <span><a href="https://github.com/fangzhixi/netdisk/"> GitHub.com</a></span>
                    <span>.fizzy 2021-04-28 毕设所作</span>
                </div>
            </div>
        </div>
    </footer>
    <!-- Upload JavaScript -->
    <script src="assets/js/upload.js"></script>

    <!-- Backend Bundle JavaScript -->
    <script src="assets/js/backend-bundle.min.js"></script>
    
    <!-- Chart Custom JavaScript -->
    <script src="assets/js/customizer.js"></script>
    
    <!-- Chart Custom JavaScript -->
    <script src="assets/js/chart-custom.js"></script>
    
    <!--PDF-->
    <script src="assets/vendor/doc-viewer/include/pdf/pdf.js"></script>
    <!--Docs-->
    <script src="assets/vendor/doc-viewer/include/docx/jszip-utils.js"></script>
    <script src="assets/vendor/doc-viewer/include/docx/mammoth.browser.min.js"></script>
    <!--PPTX-->
    <script src="assets/vendor/doc-viewer/include/PPTXjs/js/filereader.js"></script>
    <script src="assets/vendor/doc-viewer/include/PPTXjs/js/d3.min.js"></script>
    <script src="assets/vendor/doc-viewer/include/PPTXjs/js/nv.d3.min.js"></script>
    <script src="assets/vendor/doc-viewer/include/PPTXjs/js/pptxjs.js"></script>
    <script src="assets/vendor/doc-viewer/include/PPTXjs/js/divs2slides.js"></script>
    <!--All Spreadsheet -->
    <script src="assets/vendor/doc-viewer/include/SheetJS/handsontable.full.min.js"></script>
    <script src="assets/vendor/doc-viewer/include/SheetJS/xlsx.full.min.js"></script>
    <!--Image viewer-->
    <script src="assets/vendor/doc-viewer/include/verySimpleImageViewer/js/jquery.verySimpleImageViewer.js"></script>
    <!--officeToHtml-->
    <script src="assets/vendor/doc-viewer/include/officeToHtml/officeToHtml.js"></script>
    <script src="assets/js/doc-viewer.js"></script>
    <!-- app JavaScript -->
    <script src="assets/js/app.js"></script>
     <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
            <div class="modal-content">
                <div class="modal-header">
                  <h4 class="modal-title">Title</h4>
                    <div>
                        <a class="btn" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </a>
                    </div>
                </div>
                <div class="modal-body">
                    <div id="resolte-contaniner" style="height: 500px;" class="overflow-auto">
                        File not found
                    </div>
                </div>
            </div>
        </div>
    </div>
  </body>
</html>
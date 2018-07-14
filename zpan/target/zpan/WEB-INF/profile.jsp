<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="zh" class="default-style">
<head>
    <title>个人信息</title>

    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="icon" type="image/x-icon" href="favicon.ico">

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i,900"
          rel="stylesheet">

    <!-- Icon fonts -->
    <link rel="stylesheet" href="../assets/vendor/fonts/fontawesome.css">
    <link rel="stylesheet" href="../assets/vendor/fonts/ionicons.css">
    <link rel="stylesheet" href="../assets/vendor/fonts/linearicons.css">
    <link rel="stylesheet" href="../assets/vendor/fonts/open-iconic.css">
    <link rel="stylesheet" href="../assets/vendor/fonts/pe-icon-7-stroke.css">

    <!-- Core stylesheets -->
    <link rel="stylesheet" href="../assets/vendor/css/rtl/bootstrap.css" class="theme-settings-bootstrap-css">
    <link rel="stylesheet" href="../assets/vendor/css/rtl/appwork.css" class="theme-settings-appwork-css">
    <link rel="stylesheet" href="../assets/vendor/css/rtl/theme-corporate.css" class="theme-settings-theme-css">
    <link rel="stylesheet" href="../assets/vendor/css/rtl/colors.css" class="theme-settings-colors-css">
    <link rel="stylesheet" href="../assets/vendor/css/rtl/uikit.css">
    <link rel="stylesheet" href="../assets/css/demo.css">

    <script src="../assets/vendor/js/material-ripple.js"></script>
    <script src="../assets/vendor/js/layout-helpers.js"></script>

    <!-- Theme settings -->
    <!-- This file MUST be included after core stylesheets and layout-helpers.js in the <head> section -->
    <script src="../assets/vendor/js/theme-settings.js"></script>
    <!--
    <script>
      window.themeSettings = new ThemeSettings({
        cssPath: 'assets/vendor/css/rtl/',
        themesPath: 'assets/vendor/css/rtl/'
      });
    </script>
     -->

    <!-- Core scripts -->
    <script src="../assets/vendor/js/pace.js"></script>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- Libs -->
    <link rel="stylesheet" href="../assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" href="../assets/vendor/libs/select2/select2.css">
    <link rel="stylesheet" href="../assets/vendor/libs/bootstrap-tagsinput/bootstrap-tagsinput.css">

    <!-- Page -->
    <link rel="stylesheet" href="../assets/vendor/css/pages/account.css">

    <script src="../js/profile.js"></script>

</head>

<body>
<div class="page-loader">
    <div class="bg-primary"></div>
</div>

<!-- Layout wrapper -->
<div class="layout-wrapper layout-2">
    <div class="layout-inner">

        <!-- Layout container -->
        <div class="layout-container">
            <!-- Layout navbar -->
            <nav class="layout-navbar navbar navbar-expand-lg align-items-lg-center bg-white container-p-x"
                 id="layout-navbar">

                <div class="navbar-collapse collapse" id="layout-navbar-collapse">
                    <!-- Divider -->
                    <hr class="d-lg-none w-100 my-2">

                    <div class="navbar-nav align-items-lg-center ml-auto">

                        <!-- Divider -->
                        <div class="nav-item d-none d-lg-block text-big font-weight-light line-height-1 opacity-25 mr-3 ml-1">
                            |
                        </div>

                        <div class="demo-navbar-user nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
                                <span class="d-inline-flex flex-lg-row-reverse align-items-center align-middle">
                                    <span class="px-1 mr-lg-2 ml-2 ml-lg-0">${user.getUsername()}</span>
                                </span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right">
                                <a href="profile.action" class="dropdown-item">
                                    <i class="ion ion-ios-person text-lightest"></i> &nbsp; 个人信息</a>
                                <a href="logout.action" class="dropdown-item">
                                    <i class="ion ion-ios-log-out text-danger"></i> &nbsp; 退出</a>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
            <!-- / Layout navbar -->

            <!-- Layout content -->
            <div class="layout-content">

                <!-- Content -->
                <div class="container-fluid flex-grow-1 container-p-y">

                    <h4 class="font-weight-bold py-3 mb-4">
                        Account settings
                    </h4>

                    <div class="card overflow-hidden">
                        <div class="row no-gutters row-bordered row-border-light">
                            <div class="col-md-3 pt-0">
                                <div class="list-group list-group-flush account-settings-links">
                                    <a class="list-group-item list-group-item-action active" data-toggle="list"
                                       href="#account-general">基本信息</a>
                                    <a class="list-group-item list-group-item-action" data-toggle="list"
                                       href="#account-change-password">修改密码</a>
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="tab-content">
                                    <div class="tab-pane fade show active" id="account-general">
                                        <form name="form" action="modifyAccountGeneral.action">
                                            <div class="card-body">
                                                <div class="form-group">
                                                    <label class="form-label">邮箱</label>
                                                    <input type="text" class="form-control mb-1"
                                                           value=${user.getEmail()}
                                                                   disabled name="email">
                                                </div>
                                                <div class="form-group">
                                                    <label class="form-label">用户名</label>
                                                    <label class="form-label text-danger" id="user-name-label"></label>
                                                    <input type="text" class="form-control mb-1"
                                                           value=${user.getUsername()} name="username">
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="tab-pane fade" id="account-change-password">
                                        <form name="form" action="modifyAccountPassword.action">
                                            <div class="card-body pb-2">
                                                <div class="form-group">
                                                    <label class="form-label">当前密码</label>
                                                    <label class="form-label text-danger" id="password1-label"></label>
                                                    <input type="password" class="form-control" name="password1">
                                                </div>

                                                <div class="form-group">
                                                    <label class="form-label">新密码</label>
                                                    <label class="form-label text-danger" id="password2-label"></label>
                                                    <input type="password" class="form-control" name="password2">
                                                </div>

                                                <div class="form-group">
                                                    <label class="form-label">确认新密码</label>
                                                    <label class="form-label text-danger" id="password3-label"></label>
                                                    <input type="password" class="form-control" name="password3">
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="text-right mt-3">
                        <button type="button" class="btn btn-primary" onclick="save()">保存</button>&nbsp;
                        <button type="button" class="btn btn-default" onclick="cancel()">取消</button>
                    </div>

                </div>

                <nav class="layout-footer footer bg-footer-theme">
                    <div class="container-fluid d-flex flex-wrap justify-content-between text-center container-p-x pb-3">
                        <div class="pt-3">
                            <span class="footer-text font-weight-bolder">Appwork</span> ©
                        </div>
                        <div>
                            <a href="javascript:void(0)" class="footer-link pt-3">About Us</a>
                            <a href="javascript:void(0)" class="footer-link pt-3 ml-4">Help</a>
                            <a href="javascript:void(0)" class="footer-link pt-3 ml-4">Contact</a>
                            <a href="javascript:void(0)" class="footer-link pt-3 ml-4">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <div class="layout-overlay layout-sidenav-toggle"></div>
</div>

<!-- Core scripts -->
<script src="../assets/vendor/libs/popper/popper.js"></script>
<script src="../assets/vendor/js/bootstrap.js"></script>
<script src="../assets/vendor/js/sidenav.js"></script>

<!-- Libs -->
<script src="../assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="../assets/vendor/libs/select2/select2.js"></script>
<script src="../assets/vendor/libs/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>

<!-- Demo -->
<script src="../assets/js/demo.js"></script>
<script src="../assets/js/pages_account-settings.js"></script>
</body>

</html>
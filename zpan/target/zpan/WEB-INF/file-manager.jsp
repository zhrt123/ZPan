<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="default-style">

<head>
    <title>ZPan</title>


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


    <!-- Core scripts -->
    <script src="../assets/vendor/js/pace.js"></script>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- Libs -->
    <link rel="stylesheet" href="../assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" href="../assets/vendor/libs/bootstrap-sweetalert/bootstrap-sweetalert.css">
    <link rel="stylesheet" href="../assets/vendor/libs/nestable/nestable.css">
    <link rel="stylesheet" href="../assets/vendor/libs/jstree/themes/default/style.css">

    <!-- Page -->
    <link rel="stylesheet" href="../assets/vendor/css/pages/file-manager.css">

    <!-- myConfig-->
    <link rel="stylesheet" href="../css/my-input.css">
    <script src="../js/file-upload-download.js"></script>
    <script src="../js/file-operation.js"></script>
    <script src="../js/file-path-change.js"></script>

</head>

<body>
<div class="page-loader">
    <div class="bg-primary"></div>
</div>

<!-- Layout wrapper -->
<div class="layout-wrapper layout-2">
    <div class="layout-inner">

        <!-- Layout sidenav -->
        <div id="layout-sidenav" class="layout-sidenav sidenav sidenav-vertical bg-dark">

            <div class="app-brand demo">
                <span class="app-brand-logo demo bg-primary">
                    <svg viewBox="0 0 148 80" xmlns="http://www.w3.org/2000/svg"
                         xmlns:xlink="http://www.w3.org/1999/xlink">
                        <defs>
                            <linearGradient id="a" x1="46.49" x2="62.46" y1="53.39" y2="48.2"
                                            gradientUnits="userSpaceOnUse">
                                <stop stop-opacity=".25" offset="0"></stop>
                                <stop stop-opacity=".1" offset=".3"></stop>
                                <stop stop-opacity="0" offset=".9"></stop>
                            </linearGradient>
                            <linearGradient id="e" x1="76.9" x2="92.64" y1="26.38" y2="31.49"
                                            xlink:href="#a"></linearGradient>
                            <linearGradient id="d" x1="107.12" x2="122.74" y1="53.41" y2="48.33"
                                            xlink:href="#a"></linearGradient>
                        </defs>
                        <path style="fill: #fff;" transform="translate(-.1)"
                              d="M121.36,0,104.42,45.08,88.71,3.28A5.09,5.09,0,0,0,83.93,0H64.27A5.09,5.09,0,0,0,59.5,3.28L43.79,45.08,26.85,0H.1L29.43,76.74A5.09,5.09,0,0,0,34.19,80H53.39a5.09,5.09,0,0,0,4.77-3.26L74.1,35l16,41.74A5.09,5.09,0,0,0,94.82,80h18.95a5.09,5.09,0,0,0,4.76-3.24L148.1,0Z"></path>
                        <path transform="translate(-.1)"
                              d="M52.19,22.73l-8.4,22.35L56.51,78.94a5,5,0,0,0,1.64-2.19l7.34-19.2Z"
                              fill="url(#a)"></path>
                        <path transform="translate(-.1)" d="M95.73,22l-7-18.69a5,5,0,0,0-1.64-2.21L74.1,35l8.33,21.79Z"
                              fill="url(#e)"></path>
                        <path transform="translate(-.1)"
                              d="M112.73,23l-8.31,22.12,12.66,33.7a5,5,0,0,0,1.45-2l7.3-18.93Z" fill="url(#d)"></path>
                    </svg>
                </span>
                <a href="fileManager.action" class="app-brand-text demo sidenav-text font-weight-normal ml-2">ZPan</a>

                <a href="javascript:void(0)" class="layout-sidenav-toggle sidenav-link text-large ml-auto">
                    <i class="ion ion-md-menu align-middle"></i>
                </a>

            </div>
            <div class="sidenav-divider mt-5"></div>
            <div class="sidenav-divider mt-5"></div>

            <ul class="sidenav-inner py-1 nav nav-tabs">
                <li role="presentation" class="sidenav-item">
                    <a id="my-file-href" href="#my-file" class="sidenav-link sidenav-toggle" role="tab"
                       data-toggle="tab">
                        <i class="sidenav-icon ion ion-md-cube"></i>
                        <div>我的文件</div>
                    </a>
                </li>
                <li role="presentation" class="sidenav-item">
                    <a id="my-share-href" href="#my-share" class="sidenav-link sidenav-toggle" role="tab"
                       data-toggle="tab"
                       onclick="onChangeContent()">
                        <i class="sidenav-icon ion ion-ios-heart"></i>
                        <div>我的分享</div>
                    </a>
                </li>
                <li role="presentation" class="sidenav-item">
                    <a id="sharing-href" href="#sharing" class="sidenav-link sidenav-toggle" role="tab"
                       data-toggle="tab"
                       onclick="onChangeContent()">
                        <i class="sidenav-icon ion ion-md-switch"></i>
                        <div>分享区</div>
                    </a>
                </li>
                <li class="sidenav-divider mb-1"></li>
            </ul>
        </div>

        <div class="layout-container">
            <nav class="layout-navbar navbar navbar-expand-lg align-items-lg-center bg-white container-p-x"
                 id="layout-navbar">

                <!-- Brand demo (see assets/css/demo/demo.css) -->
                <a href="fileManager.action" class="navbar-brand app-brand demo d-lg-none py-0 mr-4">
                    <span class="app-brand-logo demo bg-primary">
                        <svg viewBox="0 0 148 80" xmlns="http://www.w3.org/2000/svg"
                             xmlns:xlink="http://www.w3.org/1999/xlink">
                            <defs>
                                <linearGradient id="a" x1="46.49" x2="62.46" y1="53.39" y2="48.2"
                                                gradientUnits="userSpaceOnUse">
                                    <stop stop-opacity=".25" offset="0"></stop>
                                    <stop stop-opacity=".1" offset=".3"></stop>
                                    <stop stop-opacity="0" offset=".9"></stop>
                                </linearGradient>
                                <linearGradient id="e" x1="76.9" x2="92.64" y1="26.38" y2="31.49"
                                                xlink:href="#a"></linearGradient>
                                <linearGradient id="d" x1="107.12" x2="122.74" y1="53.41" y2="48.33"
                                                xlink:href="#a"></linearGradient>
                            </defs>
                            <path style="fill: #fff;" transform="translate(-.1)"
                                  d="M121.36,0,104.42,45.08,88.71,3.28A5.09,5.09,0,0,0,83.93,0H64.27A5.09,5.09,0,0,0,59.5,3.28L43.79,45.08,26.85,0H.1L29.43,76.74A5.09,5.09,0,0,0,34.19,80H53.39a5.09,5.09,0,0,0,4.77-3.26L74.1,35l16,41.74A5.09,5.09,0,0,0,94.82,80h18.95a5.09,5.09,0,0,0,4.76-3.24L148.1,0Z"></path>
                            <path transform="translate(-.1)"
                                  d="M52.19,22.73l-8.4,22.35L56.51,78.94a5,5,0,0,0,1.64-2.19l7.34-19.2Z"
                                  fill="url(#a)"></path>
                            <path transform="translate(-.1)"
                                  d="M95.73,22l-7-18.69a5,5,0,0,0-1.64-2.21L74.1,35l8.33,21.79Z" fill="url(#e)"></path>
                            <path transform="translate(-.1)"
                                  d="M112.73,23l-8.31,22.12,12.66,33.7a5,5,0,0,0,1.45-2l7.3-18.93Z"
                                  fill="url(#d)"></path>
                        </svg>
                    </span>
                    <span class="app-brand-text demo font-weight-normal ml-2">ZPan</span>
                </a>

                <!-- Sidenav toggle (see assets/css/demo/demo.css) -->
                <div class="layout-sidenav-toggle navbar-nav d-lg-none align-items-lg-center mr-auto">
                    <a class="nav-item nav-link px-0 mr-lg-4" href="javascript:void(0)">
                        <i class="ion ion-md-menu text-large align-middle"></i>
                    </a>
                </div>

                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#layout-navbar-collapse">
                    <span class="navbar-toggler-icon"></span>
                </button>

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
                                <a href="javascript:void(0)" class="dropdown-item">
                                    <i class="ion ion-md-settings text-lightest"></i> &nbsp; 容量：${capacity}MB / 1000MB
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-striped progress-bar-animated"
                                             style="width: ${capacityPercent}%"></div>
                                    </div>
                                </a>
                                <a href="profile.action" class="dropdown-item">
                                    <i class="ion ion-ios-person text-lightest"></i> &nbsp; 个人信息</a>
                                <a href="logout.action" class="dropdown-item">
                                    <i class="ion ion-ios-log-out text-danger"></i> &nbsp; 退出</a>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
            <div class="tab-content layout-content">
                <div class="tab-pane fade show active" id="my-file">

                    <div class="container-fluid flex-grow-1 container-p-y">
                        <div class="bg-lightest container-m--x container-m--y mb-3">

                            <ol class="breadcrumb text-big container-p-x py-3 m-0" id="myFileDirectionHTML">
                                ${myFileDirectionHTML}
                            </ol>

                            <hr class="m-0">

                            <div class="file-manager-actions container-p-x py-2">
                                <div>
                                    <label class="custom-control custom-checkbox m-0">
                                        <input type="checkbox" class="custom-control-input select-all-files my-file">
                                        <span class="custom-control-label"></span>
                                    </label>
                                    <form id="file-upload" action="fileUpload.action" method="post"
                                          enctype="multipart/form-data">
                                        <input type="file" id="file-input" multiple="multiple" name="uploadFile"
                                               class="file_input"
                                               onchange="onUploadFile()"/>
                                        <button type="button" class="btn btn-primary mr-2"
                                                onclick="onSelectFile()">
                                            <i class="ion ion-md-cloud-upload">
                                            </i>&nbsp; Upload
                                        </button>
                                    </form>
                                    <button type="button" class="btn btn-secondary mr-2 file-download my-file">
                                        <i class="ion ion-md-cloud-download"></i>
                                        </i>&nbsp; Download
                                    </button>

                                    <div class="btn-group mr-2">
                                        <button type="button" class="btn btn-default md-btn-flat dropdown-toggle px-2"
                                                data-toggle="dropdown">
                                            <i class="ion ion-ios-settings"></i>
                                        </button>
                                        <div class="modal fade" id="modals-default">
                                            <div class="modal-dialog">
                                                <form class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title">新建文件夹</h5>
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-label="Close">×
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-row">
                                                            <div class="form-group col">
                                                                <label class="form-label">名称</label>
                                                                <input type="text" class="form-control"
                                                                       name="new_file_name">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default"
                                                                data-dismiss="modal">取消
                                                        </button>
                                                        <button type="button" class="btn btn-primary new-file my-file">
                                                            保存
                                                        </button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>

                                        <div class="modal fade" id="folder-list">
                                            <div class="modal-dialog">
                                                <form class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title">选择路径</h5>
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-label="Close">×
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="container-fluid flex-grow-1 container-p-y"
                                                             style="display: none">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="dd" id="nestable">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="dd" id="nestable2">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div id="jstree-example-1"
                                                             style="margin-top:20px;min-height:200px;border:1px solid #ddd;padding:20px;">
                                                            <ul id="myFileFolderListHTML">
                                                                ${myFileFolderListHTML}
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default"
                                                                data-dismiss="modal">取消
                                                        </button>
                                                        <button type="button"
                                                                class="btn btn-primary path-select my-file">
                                                            确认
                                                        </button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item my-file" href="javascript:void(0)"
                                               data-toggle="modal" data-target="#modals-default">新建文件夹</a>
                                            <a class="dropdown-item my-file" href="javascript:void(0)"
                                               data-toggle="modal" data-target="#folder-list"
                                               onclick="onClickMove()">移动</a>
                                            <a class="dropdown-item  my-file" href="javascript:void(0)"
                                               data-toggle="modal" data-target="#folder-list"
                                               onclick="onClickCopy()">复制</a>
                                            <a class="dropdown-item remove-selected-file my-file"
                                               href="javascript:void(0)">删除</a>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <label class="nav-item navbar-text navbar-search-box p-0 active">
                                        <i class="ion ion-ios-search navbar-icon align-middle"></i>
                                        <span class="navbar-search-input pl-2">
                                                <input type="text"
                                                       class="form-control navbar-text mx-2 my-file search-input"
                                                       placeholder="Search..." style="width:200px">
                                            </span>
                                    </label>
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-default icon-btn md-btn-flat active">
                                            <input type="radio" name="file-manager-view" value="file-manager-col-view"
                                                   class="file-manager-col-view">
                                            <span class="ion ion-md-apps"></span>
                                        </label>
                                        <label class="btn btn-default icon-btn md-btn-flat">
                                            <input type="radio" name="file-manager-view" value="file-manager-row-view"
                                                   checked class="file-manager-row-view">
                                            <span class="ion ion-md-menu"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <hr class="m-0">
                        </div>
                        <div class="file-manager-container file-manager-col-view" id="myFileFileItemsHTML">
                            ${myFileFileItemsHTML}
                        </div>
                    </div>

                </div>
                <div class="tab-pane fade" id="my-share">
                    <div class="container-fluid flex-grow-1 container-p-y">
                        <div class="bg-lightest container-m--x container-m--y mb-3">

                            <ol class="breadcrumb text-big container-p-x py-3 m-0" id="myShareDirectionHTML">
                                ${myShareDirectionHTML}
                            </ol>

                            <hr class="m-0">

                            <div class="file-manager-actions container-p-x py-2">
                                <div>
                                    <label class="custom-control custom-checkbox m-0">
                                        <input type="checkbox" class="custom-control-input select-all-files my-share">
                                        <span class="custom-control-label"></span>
                                    </label>
                                    <div class="btn-group mr-2">
                                        <button type="button" class="btn btn-default md-btn-flat dropdown-toggle px-2"
                                                data-toggle="dropdown">
                                            <i class="ion ion-ios-settings"></i>
                                        </button>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item remove-selected-file my-share"
                                               href="javascript:void(0)">取消分享</a>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <label class="nav-item navbar-text navbar-search-box p-0 active">
                                        <i class="ion ion-ios-search navbar-icon align-middle"></i>
                                        <span class="navbar-search-input pl-2">
                                                <input type="text"
                                                       class="form-control navbar-text mx-2 my-share search-input"
                                                       placeholder="Search..." style="width:200px">
                                            </span>
                                    </label>
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-default icon-btn md-btn-flat active">
                                            <input type="radio" name="file-manager-view" value="file-manager-col-view"
                                                   class="file-manager-col-view">
                                            <span class="ion ion-md-apps"></span>
                                        </label>
                                        <label class="btn btn-default icon-btn md-btn-flat">
                                            <input type="radio" name="file-manager-view" value="file-manager-row-view"
                                                   checked class="file-manager-row-view">
                                            <span class="ion ion-md-menu"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <hr class="m-0">
                        </div>
                        <div class="file-manager-container file-manager-col-view" id="myShareFileItemsHTML">
                            ${myShareFileItemsHTML}
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="sharing">
                    <div class="container-fluid flex-grow-1 container-p-y">
                        <div class="bg-lightest container-m--x container-m--y mb-3">

                            <ol class="breadcrumb text-big container-p-x py-3 m-0" id="sharingDirectionHTML">
                                ${sharingDirectionHTML}
                            </ol>

                            <hr class="m-0">

                            <div class="file-manager-actions container-p-x py-2">
                                <div>
                                    <label class="custom-control custom-checkbox m-0">
                                        <input type="checkbox" class="custom-control-input select-all-files sharing">
                                        <span class="custom-control-label"></span>
                                    </label>
                                    <button type="button" class="btn btn-secondary mr-2 file-download sharing">
                                        <i class="ion ion-md-cloud-download"></i>
                                        </i>&nbsp; Download
                                    </button>
                                </div>
                                <div>
                                    <label class="nav-item navbar-text navbar-search-box p-0 active">
                                        <i class="ion ion-ios-search navbar-icon align-middle"></i>
                                        <span class="navbar-search-input pl-2">
                                                <input type="text"
                                                       class="form-control navbar-text mx-2 sharing search-input"
                                                       placeholder="Search..." style="width:200px">
                                            </span>
                                    </label>
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-default icon-btn md-btn-flat active">
                                            <input type="radio" name="file-manager-view" value="file-manager-col-view"
                                                   class="file-manager-col-view">
                                            <span class="ion ion-md-apps"></span>
                                        </label>
                                        <label class="btn btn-default icon-btn md-btn-flat">
                                            <input type="radio" name="file-manager-view" value="file-manager-row-view"
                                                   checked class="file-manager-row-view">
                                            <span class="ion ion-md-menu"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <hr class="m-0">
                        </div>
                        <div class="file-manager-container file-manager-col-view" id="sharingFileItemsHTML">
                            ${sharingFileItemsHTML}
                        </div>
                    </div>
                </div>
                <nav class="layout-footer footer bg-footer-theme">
                    <div class="container-fluid d-flex flex-wrap justify-content-between text-center container-p-x pb-3">
                        <div class="pt-3">
                            <span class="footer-text font-weight-bolder">ZPan</span> ©
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

    <!-- Overlay -->
    <div class="layout-overlay layout-sidenav-toggle"></div>
</div>
<!-- / Layout wrapper -->


<!-- Core scripts -->
<script src="../assets/vendor/libs/popper/popper.js"></script>
<script src="../assets/vendor/js/bootstrap.js"></script>
<script src="../assets/vendor/js/sidenav.js"></script>

<!-- Libs -->
<script src="../assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="../assets/vendor/libs/bootbox/bootbox.js"></script>
<script src="../assets/vendor/libs/bootstrap-sweetalert/bootstrap-sweetalert.js"></script>
<script src="../assets/vendor/libs/nestable/nestable.js"></script>
<script src="../assets/vendor/libs/jstree/jstree.js"></script>

<!-- Demo -->
<script src="../assets/js/demo.js"></script>
<script src="../assets/js/pages_file-manager.js"></script>
<script src="../assets/js/ui_modals.js"></script>
<script src="../assets/js/ui_treeview.js"></script>

</body>

</html>
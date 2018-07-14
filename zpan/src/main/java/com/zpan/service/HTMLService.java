package com.zpan.service;

import com.zpan.vo.FileItems;

import java.io.File;
import java.util.List;

public class HTMLService {
    private FileService fileService;

    public String getClassType(String type) {
        if (type.equals("filePath")) return "my-file";
        else if (type.equals("mySharePath")) return "my-share";
        else if (type.equals("sharingPath")) return "sharing";
        return "";
    }

    public String getPathRoot(String type) {
        if (type.equals("filePath")) return "data";
        else if (type.equals("mySharePath")) return "sharing";
        else if (type.equals("sharingPath")) return "";
        return "";
    }

    public int getStartIndex(String type) {
        if (type.equals("sharingPath")) return 1;
        return 2;
    }

    public String getDirectionHTML(String path, String type) {
        StringBuilder sb = new StringBuilder();
        StringBuilder p = new StringBuilder();
        while (path.indexOf("\\") >= 0) path = path.replace("\\", "/");
        String[] d = path.split("/");
        p.append(getPathRoot(type));
        for (int i = getStartIndex(type); i < d.length; i++) {
            p.append("/" + d[i]);
            sb.append("<li class=\"breadcrumb-item\">");
            sb.append("<a href=\"javascript:void(0)\" class=\"" + getClassType(type) + " path-change\" name=\"" + p.toString() + "\">" + d[i] + "</a></li>");
        }
        return sb.toString();
    }

    public String getStyle(String type) {
        if (type.equals("application/msword")) return "fa-file-word";
        if (type.equals("application/vnd.ms-excel")) return "fa-file-excel";
        if (type.equals("application/vnd.ms-powerpoint")) return "fa-file-powerpoint";
        if (type.equals("text/plain")) return "fa-file-alt";
        if (type.equals("text/html")) return "fa-html5";
        if (type.equals("application/octet-stream")) return "fa-file";
        return "fa-file";
    }

    public String getFileItemsHTML(List<FileItems> flist, String type) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"file-manager-row-header\">");
        sb.append("<div class=\"file-item-name pb-2\">Filename</div>");
        sb.append("<div class=\"file-item-changed pb-2\">Changed</div>");
        sb.append("</div>\n");
        sb.append("<div class=\"file-item back-previous-page " + getClassType(type) + "\">");
        sb.append("<div class=\"file-item-icon file-item-level-up fas fa-level-up-alt text-secondary\"></div>");
        sb.append("<a href=\"javascript:void(0)\" class=\"file-item-name\" style=\"display: none\">..</a>");
        sb.append("</div>");
        for (FileItems f : flist) {
            sb.append("<div class=\"file-item " + getClassType(type) + "\">");
            sb.append("<div class=\"file-item-select-bg bg-primary\"></div>");
            sb.append("<label class=\"file-item-checkbox custom-control custom-checkbox\">");
            sb.append("<input type=\"checkbox\" class=\"custom-control-input\">");
            sb.append("<span class=\"custom-control-label\"></span>");
            sb.append("</label>");

            if (f.isFolder()) {
                sb.append("<div class=\"file-item-icon far fa-folder text-secondary " + getClassType(type) + " path-change\"></div>");
            } else if (f.getType() == null) {
                sb.append("<div class=\"file-item-icon far fa-file text-secondary\"></div>");
            } else if (f.getType().indexOf("image") >= 0) {
                sb.append("<div class=\"file-item-img\" style=\"background-image: url(" + f.getPath() + ")\"></div>");
            } else {
                sb.append("<div class=\"file-item-icon far " + getStyle(f.getType()) + " text-secondary\"></div>");
            }

            sb.append("<a href=\"javascript:void(0)\" name=\"" + f.getPath() + "\" class=\"file-item-name");
            if (f.isFolder()) sb.append(" " + getClassType(type) + " path-change\">");
            else sb.append("\">");
            sb.append(f.getName());
            sb.append("</a>");

            sb.append("<form id=\"rename-form\" method=\"post\" style=\"display:none\">");
            sb.append("<input type=\"text\" class=\"form-control form-control-sm\"");
            sb.append("style=\"display: inline;width: 50%\" name=\"newname\" value=\"" + f.getName() + "\"/>");
            sb.append("<button type=\"button\" class=\"btn btn-outline-primary icon-btn btn-sm rename-sumbit " + getClassType(type) + "\">");
            sb.append("<span class=\"far fa-paper-plane\"></span>");
            sb.append("</button>");
            sb.append("<button type=\"button\" class=\"btn btn-outline-danger icon-btn btn-sm rename-cancel\">");
            sb.append("<span class=\"ion ion-md-close\"></span>");
            sb.append("</button>");
            sb.append("</form>");

            sb.append("<div class=\"file-item-changed\">" + f.getChangeTime() + "</div>");
            if (type.equals("filePath")) {
                sb.append("<div class=\"file-item-actions btn-group\">");
                sb.append("<button type=\"button\"");
                sb.append("class=\"btn btn-default btn-sm btn-round icon-btn borderless md-btn-flat hide-arrow dropdown-toggle\"");
                sb.append("data-toggle=\"dropdown\">");
                sb.append("<i class=\"ion ion-ios-more\"></i>");
                sb.append("</button>");
                sb.append("<div class=\"dropdown-menu dropdown-menu-right\">");
                sb.append("<a class=\"dropdown-item click " + getClassType(type) + "\" href=\"javascript:void(0)\" data-toggle=\"modal\">分享</a>");
                sb.append("<a class=\"dropdown-item click " + getClassType(type) + "\" href=\"javascript:void(0)\" data-toggle=\"modal\">重命名</a>");
                sb.append("<a class=\"dropdown-item click " + getClassType(type) + "\" href=\"javascript:void(0)\" data-toggle=\"modal\" data-target=\"#folder-list\">移动</a>");
                sb.append("<a class=\"dropdown-item click " + getClassType(type) + "\" href=\"javascript:void(0)\" data-toggle=\"modal\" data-target=\"#folder-list\">拷贝</a>");

                sb.append("<a class=\"dropdown-item click " + getClassType(type) + "\" href=\"javascript:void(0)\" data-toggle=\"modal\">删除</a>");
                sb.append("</div>");
                sb.append("</div>");
            }
            sb.append("</div>");
        }
        return sb.toString();
    }


    public void getFolderListHTML(String path, String vpath, String folderName, StringBuilder sb) {
        File[] files = fileService.getFiles(path);
        sb.append("<li").append(" name=\"").append(vpath).append("\">").append(folderName).append("<ul>");
        for (File file : files) {
            if (file.isDirectory()) {
                getFolderListHTML(path + "\\" + file.getName(), vpath + "/" + file.getName(), file.getName(), sb);
            }
        }
        sb.append("</ul></li>");
    }


    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public FileService getFileService() {
        return fileService;
    }

}

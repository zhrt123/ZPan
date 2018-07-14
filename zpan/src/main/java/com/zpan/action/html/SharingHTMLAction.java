package com.zpan.action.html;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.FileService;
import com.zpan.service.HTMLService;
import net.sf.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SharingHTMLAction extends ActionSupport {
    private FileService fileService;
    private HTMLService htmlService;

    private String sharingDirectionHTML;
    private String sharingFileItemsHTML;
    private String result;

    public String excute() {
        String sharingPath = (String) ActionContext.getContext().getSession().get("sharingPath");
        File[] sharingFiles = fileService.getFiles(sharingPath);
        sharingFileItemsHTML = htmlService.getFileItemsHTML(fileService.getFileItemsList(sharingFiles), "sharingPath");
        sharingDirectionHTML = htmlService.getDirectionHTML(sharingPath, "sharingPath");
        Map map = new HashMap<String, Object>();
        map.put("sharingFileItemsHTML", sharingFileItemsHTML);
        map.put("sharingDirectionHTML", sharingDirectionHTML);
        JSONObject json = JSONObject.fromObject(map);
        result = json.toString();
        return SUCCESS;
    }

    public FileService getFileService() {
        return fileService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public HTMLService getHtmlService() {
        return htmlService;
    }

    public void setHtmlService(HTMLService htmlService) {
        this.htmlService = htmlService;
    }

    public String getSharingDirectionHTML() {
        return sharingDirectionHTML;
    }

    public void setSharingDirectionHTML(String sharingDirectionHTML) {
        this.sharingDirectionHTML = sharingDirectionHTML;
    }

    public String getSharingFileItemsHTML() {
        return sharingFileItemsHTML;
    }

    public void setSharingFileItemsHTML(String sharingFileItemsHTML) {
        this.sharingFileItemsHTML = sharingFileItemsHTML;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

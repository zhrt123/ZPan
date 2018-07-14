package com.zpan.action.html;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.FileService;
import com.zpan.service.HTMLService;
import net.sf.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MyShareHTMLAction extends ActionSupport {
    private FileService fileService;
    private HTMLService htmlService;

    private String myShareDirectionHTML;
    private String myShareFileItemsHTML;
    private String result;

    public String excute() {
        String mySharePath = (String) ActionContext.getContext().getSession().get("mySharePath");
        File[] mySharedFiles = fileService.getFiles(mySharePath);
        myShareFileItemsHTML = htmlService.getFileItemsHTML(fileService.getFileItemsList(mySharedFiles), "mySharePath");
        myShareDirectionHTML = htmlService.getDirectionHTML(mySharePath, "mySharePath");

        Map map = new HashMap<String, Object>();
        map.put("myShareFileItemsHTML", myShareFileItemsHTML);
        map.put("myShareDirectionHTML", myShareDirectionHTML);
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

    public String getMyShareDirectionHTML() {
        return myShareDirectionHTML;
    }

    public void setMyShareDirectionHTML(String myShareDirectionHTML) {
        this.myShareDirectionHTML = myShareDirectionHTML;
    }

    public String getMyShareFileItemsHTML() {
        return myShareFileItemsHTML;
    }

    public void setMyShareFileItemsHTML(String myShareFileItemsHTML) {
        this.myShareFileItemsHTML = myShareFileItemsHTML;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

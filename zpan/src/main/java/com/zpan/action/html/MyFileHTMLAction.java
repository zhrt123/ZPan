package com.zpan.action.html;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.FileService;
import com.zpan.service.HTMLService;
import com.zpan.vo.User;
import net.sf.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MyFileHTMLAction extends ActionSupport {
    private FileService fileService;
    private HTMLService htmlService;

    private String myFileFileItemsHTML;
    private String myFileDirectionHTML;
    private String myFileFolderListHTML;
    private String result;

    private long capacity;
    private long capacityPercent;

    public String excute() {
        String path = (String) ActionContext.getContext().getSession().get("filePath");
        capacity = (fileService.getCapacity(fileService.getPathRoot(path)) + 999999) / 1000000;
        capacityPercent = (100 * capacity + 999) / 1000;

        File[] files = fileService.getFiles(path);
        myFileFileItemsHTML = htmlService.getFileItemsHTML(fileService.getFileItemsList(files), "filePath");
        myFileDirectionHTML = htmlService.getDirectionHTML(path, "filePath");

        User user = (User) ActionContext.getContext().getSession().get("user");
        StringBuilder folderListHTMLBuilder = new StringBuilder();
        htmlService.getFolderListHTML("H:\\data\\" + user.getEmail(), "data/" + user.getEmail(), user.getEmail(), folderListHTMLBuilder);
        myFileFolderListHTML = folderListHTMLBuilder.toString();

        Map map = new HashMap<String, Object>();
        map.put("myFileFileItemsHTML", myFileFileItemsHTML);
        map.put("myFileDirectionHTML", myFileDirectionHTML);
        map.put("myFileFolderListHTML", myFileFolderListHTML);
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

    public String getMyFileFileItemsHTML() {
        return myFileFileItemsHTML;
    }

    public void setMyFileFileItemsHTML(String myFileFileItemsHTML) {
        this.myFileFileItemsHTML = myFileFileItemsHTML;
    }

    public String getMyFileDirectionHTML() {
        return myFileDirectionHTML;
    }

    public void setMyFileDirectionHTML(String myFileDirectionHTML) {
        this.myFileDirectionHTML = myFileDirectionHTML;
    }

    public String getMyFileFolderListHTML() {
        return myFileFolderListHTML;
    }

    public void setMyFileFolderListHTML(String myFileFolderListHTML) {
        this.myFileFolderListHTML = myFileFolderListHTML;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getCapacityPercent() {
        return capacityPercent;
    }

    public void setCapacityPercent(long capacityPercent) {
        this.capacityPercent = capacityPercent;
    }
}

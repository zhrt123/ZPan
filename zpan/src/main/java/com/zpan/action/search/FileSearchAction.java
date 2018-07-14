package com.zpan.action.search;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.FileService;
import com.zpan.service.HTMLService;
import net.sf.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSearchAction extends ActionSupport {
    private FileService fileService;
    private HTMLService htmlService;

    private String fileName;
    private String pathType;
    private String result;

    public String excute() {
        String path = (String) ActionContext.getContext().getSession().get(pathType);
        List<File> flist = fileService.getFiles(path, fileName);
        File[] files = new File[flist.size()];
        flist.toArray(files);
        String fileItemsHTML = htmlService.getFileItemsHTML(fileService.getFileItemsList(files), pathType);
        Map map = new HashMap<String, Object>();
        map.put("fileItemsHTML", fileItemsHTML);
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPathType() {
        return pathType;
    }

    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

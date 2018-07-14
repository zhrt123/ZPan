package com.zpan.action.manager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.FileService;
import com.zpan.service.HTMLService;
import net.sf.json.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileManagerAction extends ActionSupport {
    private FileService fileService;
    private HTMLService htmlService;

    private String fileName;
    private String filePath;
    private String pathType;
    private String newFileName;
    private String result;
    private String[] fileNames;

    public String excute() {
        if (pathType == null) return "load";
        return pathType;
    }

    public String changePath() {
        ActionContext.getContext().getSession().put(pathType, fileService.getRealPath(filePath));
        return SUCCESS;
    }

    public String makeDir() {
        String path = (String) ActionContext.getContext().getSession().get("filePath");
        File dir = new File(path + "\\" + newFileName);
        Map map = new HashMap<String, Object>();
        if (!dir.exists()) {
            dir.mkdir();
            map.put("status", "success");
        } else map.put("status", "error");
        JSONObject json = JSONObject.fromObject(map);
        result = json.toString();
        return SUCCESS;
    }

    public String backPrevoiousPage() {
        String path = (String) ActionContext.getContext().getSession().get(pathType);
        char[] p = path.toCharArray();
        int count = 0;
        for (int i = 0; i < p.length; i++) if (p[i] == '\\') count++;
        if (pathType.equals("sharingPath")) {
            if (count == 1) return SUCCESS;
        } else if (count == 2) return SUCCESS;

        for (int i = path.length() - 1; i >= 0; i--) {
            if (p[i] == '\\') {
                path = path.substring(0, i);
                ActionContext.getContext().getSession().put(pathType, path);
                break;
            }
        }
        return SUCCESS;
    }

    public String renameFile() {
        String path = (String) ActionContext.getContext().getSession().get("filePath");
        Map map = new HashMap<String, Object>();
        if (fileService.renameFile(fileName, path, newFileName)) {
            fileService.renameFile(fileName, fileService.getSharingPath(path), newFileName);
            map.put("status", "success");
        } else map.put("status", "error");
        JSONObject json = JSONObject.fromObject(map);
        result = json.toString();
        return SUCCESS;
    }

    public String shareFile() {
        String path = (String) ActionContext.getContext().getSession().get("filePath");
        String destPath = fileService.getSharingPath(path);
        fileService.shareFile(fileName, path, destPath);
        return SUCCESS;
    }

    public String removeFile() {
        String path = (String) ActionContext.getContext().getSession().get("filePath");
        fileService.removeFile(fileName, path);
        fileService.removeFile(fileName, fileService.getSharingPath(path));
        return SUCCESS;
    }

    public String removeSelectedFiles() {
        String path = (String) ActionContext.getContext().getSession().get(pathType);
        for (String fname : fileNames) {
            fileService.removeFile(fname, path);
            fileService.removeFile(fname, fileService.getSharingPath(path));
        }
        return SUCCESS;
    }

    public String moveSelectedFiles() {
        String path = (String) ActionContext.getContext().getSession().get("filePath");
        boolean flag = true;
        for (String fname : fileNames) {
            if (!fileService.moveFile(fname, path, fileService.getRealPath(filePath))) flag = false;
            else {
                fileService.moveFile(fname, fileService.getSharingPath(path), fileService.getSharingPath(fileService.getRealPath(filePath)));
            }
        }
        Map map = new HashMap<String, Object>();
        if (flag) map.put("status", "success");
        else map.put("status", "error");
        JSONObject json = JSONObject.fromObject(map);
        result = json.toString();
        return SUCCESS;
    }

    public String copySelectedFiles() {
        String path = (String) ActionContext.getContext().getSession().get("filePath");
        boolean flag = true;
        for (String fname : fileNames) {
            if (!fileService.copyFile(fname, path, fileService.getRealPath(filePath))) flag = false;
        }
        Map map = new HashMap<String, Object>();
        if (flag) map.put("status", "success");
        else map.put("status", "error");
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getPathType() {
        return pathType;
    }

    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String[] getFileNames() {
        return fileNames;
    }

    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }
}

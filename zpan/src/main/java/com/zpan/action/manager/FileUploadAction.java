package com.zpan.action.manager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.FileService;
import net.sf.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileUploadAction extends ActionSupport {
    private FileService fileService;

    private File[] uploadFile; //得到上传的文件
    private String[] uploadFileContentType; //得到文件的类型
    private String[] uploadFileFileName; //得到文件的名称

    private String result;

    public String fileUpload() {
        String path = (String) ActionContext.getContext().getSession().get("filePath");
        long capacity = 1000000000 - fileService.getCapacity(fileService.getPathRoot(path));
        Map map = new HashMap<String, Object>();

        for (File file : uploadFile) {
            capacity -= file.length();
            if (capacity < 0) {
                map.put("result", "超出容量，上传失败！");
                JSONObject json = JSONObject.fromObject(map);
                result = json.toString();
                return SUCCESS;
            }
        }
        for (int i = 0; i < uploadFile.length; i++) {
            fileService.saveFile(path, uploadFile[i], uploadFileContentType[i], uploadFileFileName[i]);
        }
        map.put("result", "上传成功");
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

    public File[] getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File[] uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String[] getUploadFileContentType() {
        return uploadFileContentType;
    }

    public void setUploadFileContentType(String[] uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    public String[] getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String[] uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

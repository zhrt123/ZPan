package com.zpan.action.manager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class FileDownloadAction extends ActionSupport {
    private String fileName;
    private String downloadTime;
    private String pathType;

    public String download() {
        return SUCCESS;
    }

    public InputStream getInputStream() {
        String path = (String) ActionContext.getContext().getSession().get(pathType);
        System.out.println(pathType + "  " + path);
        InputStream is = null;
        try {
            is = new FileInputStream(new File(path + "\\" + fileName));
            ActionContext.getContext().getSession().put("downloadTime", downloadTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }


    public String getFileName() throws UnsupportedEncodingException {
        return URLEncoder.encode(this.fileName, "UTF-8");
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(String downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getPathType() {
        return pathType;
    }

    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

}

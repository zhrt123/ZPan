package com.zpan.action.manager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class DownloadManagerAction extends ActionSupport {
    private String fileName;
    private String downloadTime;

    public String getFileName() {
        return fileName;
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

    public String afterDownload() {
        while (!downloadTime.equals(ActionContext.getContext().getSession().get("downloadTime"))) {
        }
        return SUCCESS;
    }
}

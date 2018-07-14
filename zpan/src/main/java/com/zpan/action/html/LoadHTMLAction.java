package com.zpan.action.html;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.FileService;
import com.zpan.service.HTMLService;
import com.zpan.vo.User;

import java.io.File;

public class LoadHTMLAction extends ActionSupport {
    private FileService fileService;
    private HTMLService htmlService;

    private String myFileFileItemsHTML;
    private String myFileDirectionHTML;
    private String myFileFolderListHTML;
    private String myShareDirectionHTML;
    private String myShareFileItemsHTML;
    private String sharingDirectionHTML;
    private String sharingFileItemsHTML;

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

        String mySharePath = (String) ActionContext.getContext().getSession().get("mySharePath");
        File[] mySharedFiles = fileService.getFiles(mySharePath);
        myShareFileItemsHTML = htmlService.getFileItemsHTML(fileService.getFileItemsList(mySharedFiles), "mySharePath");
        myShareDirectionHTML = htmlService.getDirectionHTML(mySharePath, "mySharePath");

        String sharingPath = (String) ActionContext.getContext().getSession().get("sharingPath");
        File[] sharingFiles = fileService.getFiles(sharingPath);
        sharingFileItemsHTML = htmlService.getFileItemsHTML(fileService.getFileItemsList(sharingFiles), "sharingPath");
        sharingDirectionHTML = htmlService.getDirectionHTML(sharingPath, "sharingPath");
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

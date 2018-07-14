package com.zpan.action.manager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.FileService;
import com.zpan.util.ZipFileUtil;
import net.sf.json.JSONObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MultiFileDownloadAction extends ActionSupport {
    private String fileNames;
    private String result;
    private String pathType;

    public String downloadMultiFile() {
        String date = new SimpleDateFormat("yyyyMMDDHHmmss").format(new Date());
        String path = (String) ActionContext.getContext().getSession().get(pathType);
        String fileName = date + ".zip";
        String[] fnames = fileNames.split(";");
        if (fnames != null && fnames.length > 0) {
            File[] files = new File[fnames.length];
            for (int i = 0; i < fnames.length; i++) {
                files[i] = new File(path + "\\" + fnames[i]);
            }

            if (fnames.length == 1 && files[0].isDirectory() == false) {
                Map map = new HashMap<String, Object>();
                map.put("file_name", fnames[0]);
                JSONObject json = JSONObject.fromObject(map);
                result = json.toString();
                return SUCCESS;
            }
            ZipFileUtil.zip(files, path + "\\" + fileName);
        }
        Map map = new HashMap<String, Object>();
        map.put("file_name", fileName);
        JSONObject json = JSONObject.fromObject(map);
        result = json.toString();
        return SUCCESS;
    }

    public String getFileNames() {
        return fileNames;
    }

    public void setFileNames(String fileNames) {
        this.fileNames = fileNames;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPathType() {
        return pathType;
    }

    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

}

package com.zpan.service;

import com.zpan.vo.FileItems;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public File[] getFiles(String path) {
        File file = new File(path);
        if (!file.exists()) file.mkdir();
        File[] fs = file.listFiles();
        File[] files = new File[fs.length];
        int size = 0;
        for (File f : fs) {
            if (f.isDirectory()) files[size++] = f;
        }
        for (File f : fs) {
            if (!f.isDirectory()) files[size++] = f;
        }
        return files;
    }

    public List<File> getFiles(String path, String fileName) {
        File file = new File(path);
        if (!file.exists()) file.mkdir();
        File[] files = file.listFiles();
        List<File> flist = new ArrayList<File>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().indexOf(fileName) >= 0) flist.add(files[i]);
            if (files[i].isDirectory()) flist.addAll(getFiles(path + "\\" + files[i].getName(), fileName));
        }
        return flist;
    }

    public String getRealPath(String path) {
        String[] p = path.split("/");
        StringBuilder sb = new StringBuilder();
        sb.append("H:");
        for (int i = 0; i < p.length; i++) sb.append("\\").append(p[i]);
        return sb.toString();
    }

    private String getVirtualPath(String path) {
        while (path.contains("\\")) path = path.replace("\\", "/");
        return path.substring(3, path.length());
    }

    public String getSharingPath(String path) {
        int index = path.indexOf("data");
        return path.substring(0, index) + "sharing" + path.substring(index + 4, path.length());
    }

    public String getPathRoot(String path) {
        char[] p = path.toCharArray();
        for (int i = 0, count = 0; i < p.length; i++) {
            if (p[i] == '\\') count++;
            if (count == 3) {
                path = path.substring(0, i);
                break;
            }
        }
        return path;
    }

    public void saveFile(String path, File uploadFile, String uploadFileContentType, String uploadFileFileName) {
        File file = new File(path);
        if (!file.exists()) file.mkdir();
        try {
            FileUtils.copyFile(uploadFile, new File(file, uploadFileFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FileItems> getFileItemsList(File[] files) {
        List<FileItems> flist = new ArrayList<FileItems>();
        if (files == null || files.length == 0) return flist;
        for (File file : files) {
            try {
                FileItems f = new FileItems();
                f.setName(file.getName());
                f.setPath(getVirtualPath(file.getParent() + "\\" + file.getName()));
                f.setChangeTime(new Date(file.lastModified()));
                f.setType(Files.probeContentType(Paths.get(file.getAbsolutePath())));
                f.setFolder(file.isDirectory());
                flist.add(f);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return flist;
    }

    private void removeAllFiles(String path) {
        File[] files = getFiles(path);
        for (File file : files) {
            if (file.isDirectory()) removeAllFiles(path + "\\" + file.getName());
            file.delete();
        }
    }

    public void removeFile(String fileName, String path) {
        File file = new File(path + "\\" + fileName);
        if (file.isDirectory()) removeAllFiles(path + "\\" + fileName);
        file.delete();
    }

    public boolean renameFile(String fileName, String path, String newFileName) {
        File file = new File(path + "\\" + fileName);
        File newFile = new File(path + "\\" + newFileName);
        if (!file.exists()) return false;
        if (newFile.exists()) return false;
        file.renameTo(newFile);
        return true;
    }

    private boolean doMove(String fileName, String sourcePath, String destPath) {
        File file = new File(sourcePath + "\\" + fileName);
        File newFile = new File(destPath + "\\" + fileName);
        File folder = new File(destPath);
        if (newFile.exists()) return false;
        if (!folder.exists()) folder.mkdir();
        file.renameTo(newFile);
        return true;
    }

    public boolean moveFile(String fileName, String sourcePath, String destPath) {
        File file = new File(sourcePath + "\\" + fileName);
        File newFile = new File(destPath + "\\" + fileName);
        boolean flag = true;
        if (file.isDirectory()) {
            if (!newFile.exists()) newFile.mkdir();
            File[] files = getFiles(sourcePath + "\\" + fileName);
            if (files != null && files.length > 0) {
                sourcePath += "\\" + fileName;
                destPath += "\\" + fileName;
                for (File f : files) {
                    if (f.isDirectory()) {
                        if (!moveFile(f.getName(), sourcePath, destPath)) flag = false;
                    } else {
                        if (!doMove(f.getName(), sourcePath, destPath)) flag = false;
                    }
                }
            }
            file.delete();
        } else {
            if (!doMove(fileName, sourcePath, destPath)) flag = false;
        }
        return flag;
    }

    private boolean doCopy(String fileName, String sourcePath, String destPath) {
        File file = new File(sourcePath + "\\" + fileName);
        File newFile = new File(destPath + "\\" + fileName);
        if (newFile.exists()) return false;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            byte[] buffer = new byte[1024];
            int n = 0;
            while ((n = fileInputStream.read(buffer)) != -1) fileOutputStream.write(buffer, 0, n);
            fileInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean copyFile(String fileName, String sourcePath, String destPath) {
        File file = new File(sourcePath + "\\" + fileName);
        File newFile = new File(destPath + "\\" + fileName);
        boolean flag = true;
        if (file.isDirectory()) {
            if (!newFile.exists()) newFile.mkdir();
            File[] files = getFiles(sourcePath + "\\" + fileName);
            if (files != null && files.length > 0) {
                sourcePath += "\\" + fileName;
                destPath += "\\" + fileName;
                for (File f : files) {
                    if (f.isDirectory()) {
                        if (!copyFile(f.getName(), sourcePath, destPath)) flag = false;
                    } else {
                        if (!doCopy(f.getName(), sourcePath, destPath)) flag = false;
                    }
                }
            }
        } else {
            if (!doCopy(fileName, sourcePath, destPath)) flag = false;
        }
        return flag;
    }

    public void shareFile(String fileName, String sourcePath, String destPath) {
        File dir = new File(destPath);
        if (!dir.exists()) dir.mkdir();
        copyFile(fileName, sourcePath, destPath);
    }

    public long getCapacity(String path) {
        File[] files = getFiles(path);
        long capacity = 0;
        if (files == null || files.length == 0) return 0;
        for (File file : files) {
            if (file.isDirectory()) capacity += getCapacity(path + "\\" + file.getName());
            else capacity += file.length();
        }
        return capacity;
    }
}

package com.zpan.vo;

import org.omg.PortableInterceptor.Interceptor;

public class Disk {
    private Integer id;
    private String email;
    private String diskPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiskPath() {
        return diskPath;
    }

    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }
}

package com.zpan.dao;

import com.zpan.vo.Disk;

public interface DiskDAO {
    public String getDiskPath(String email);

    public void addDisk(Disk disk);
}

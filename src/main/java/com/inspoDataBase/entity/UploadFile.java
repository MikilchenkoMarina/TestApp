package com.inspoDataBase.entity;

import javax.persistence.*;

/**
 * @author mmikilchenko on 12.03.2017.
 */
@Entity
@Table(name = "uploadfile")
public class UploadFile {
    private long id;
    private String fileName;
    private byte[] data; 
    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "filename")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "data")
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

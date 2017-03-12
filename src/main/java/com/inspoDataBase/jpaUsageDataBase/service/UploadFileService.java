package com.inspoDataBase.jpaUsageDataBase.service;


import com.inspoDataBase.entity.UploadFile;
import com.inspoDataBase.jpaUsageDataBase.jpaRepository.UploadFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mmikilchenko on 12.03.2017.
 */
@Service
public class UploadFileService {

    @Autowired
    UploadFileRepository uploadFileRepository;

    public void saveUploadedFile(UploadFile uploadFile) {
        uploadFileRepository.saveAndFlush(uploadFile);
    }

}

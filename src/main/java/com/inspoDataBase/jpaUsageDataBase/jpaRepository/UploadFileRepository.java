package com.inspoDataBase.jpaUsageDataBase.jpaRepository;



import com.inspoDataBase.entity.UploadFile;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by mmikilchenko on 12.03.2017.
 */
public interface UploadFileRepository extends JpaRepository<UploadFile, Integer> {
    UploadFile saveAndFlush(UploadFile uploadFile);

    UploadFile findById(int id);

}

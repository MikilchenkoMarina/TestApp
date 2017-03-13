package com.inspoweb.utils;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author mmikilchenko on 13.03.2017.
 */
@Component
public class FileUploadUtil {
    public String saveImageToAmazonS3(MultipartFile multipartFile, String userName) throws AmazonServiceException, IOException {
        String ACCESS_KEY = "AKIAJWY4NJKP3YZVN3HQ";
        String SECRET_KEY = "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";
        String END_POINT_URL = "https://s3.eu-central-1.amazonaws.com";// e.g http://s3.amazonaws.com

        String BUCKET = "inspominderbucket";
        // String IMAGE_LOCATION = "/userName/";
        String S3_CACHE = "xxx"; // e.g 60
        String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        try {

            AmazonS3 s3;


            BasicAWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
            //java.security.Security.setProperty("networkaddress.cache.ttl", S3_CACHE);

            s3 = new AmazonS3Client(credentials);
            System.setProperty(SDKGlobalConfiguration.ENABLE_S3_SIGV4_SYSTEM_PROPERTY, "true");
            s3.setRegion(Region.getRegion(Regions.US_EAST_1));
            s3.setEndpoint(END_POINT_URL);

            InputStream stream = multipartFile.getInputStream();

            ObjectMetadata objectMetadata = new ObjectMetadata();
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET,/* IMAGE_LOCATION +*/ fileName, stream, objectMetadata);

            //skip if do not want to access the image directly from S3
            putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);

            //skip if do not want to access the image directly from S3
            s3.putObject(putObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return END_POINT_URL + "/" + fileName;
    }

    public void saveFiletoLocalStorage(MultipartFile multipartFile) {
        try {
            BufferedWriter w = Files.newBufferedWriter(Paths.get("C:\\Java_Pro\\local_img_storage\\" + multipartFile.getOriginalFilename()));
            w.write(new String(multipartFile.getBytes()));
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

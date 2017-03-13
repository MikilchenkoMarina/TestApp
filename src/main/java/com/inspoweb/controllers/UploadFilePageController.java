package com.inspoweb.controllers;
import com.inspoDataBase.entity.UploadFile;
import com.inspoDataBase.jpaUsageDataBase.service.UploadFileService;
import com.inspoweb.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 * @author mmikilchenko on 12.03.2017.
 */
@Controller
public class UploadFilePageController {
    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private FileUploadUtil fileUploadUtil;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadForm(Model model) {
        model.addAttribute("uploadFile", new UploadFile());
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("user-file") MultipartFile multipartFile/*, UploadFile uploadFile*/) throws Exception {

        if (!multipartFile.isEmpty()) {
           // fileUploadUtil.saveFiletoLocalStorage(multipartFile);
        String amazonS3ImageUrl =    fileUploadUtil.saveImageToAmazonS3(multipartFile,"mikmar333");
        }

            /* if (uploadFile != null) {
           uploadFileService.saveUploadedFile(uploadFile);

        }*/
        //  multipartFile.transferTo(new File("myFile.jpg"));

        return "home";
    }





}

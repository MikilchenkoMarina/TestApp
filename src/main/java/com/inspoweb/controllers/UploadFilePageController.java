package com.inspoweb.controllers;

import com.inspoDataBase.entity.UploadFile;
import com.inspoDataBase.jpaUsageDataBase.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mmikilchenko on 12.03.2017.
 */
@Controller
public class UploadFilePageController {
    @Autowired
    private UploadFileService uploadFileService;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadForm(Model model) {
        model.addAttribute("uploadFile",new UploadFile());
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(UploadFile uploadFile) throws Exception {

        if (uploadFile != null) {
                uploadFileService.saveUploadedFile(uploadFile);

        }

        return "home";
    }
}

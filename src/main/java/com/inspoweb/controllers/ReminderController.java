package com.inspoweb.controllers;

import com.amazonaws.util.IOUtils;
import com.inspoDataBase.entity.Reminder;
import com.inspoDataBase.entity.User;
import com.inspoDataBase.jpaUsageDataBase.service.ReminderService;
import com.inspoDataBase.jpaUsageDataBase.service.UserService;
import com.inspoweb.utils.FileUploadUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URL;

/**
 * @author mmikilchenko on 27.02.2017.
 */
@Controller
@RequestMapping(value = "/user/{userName}/reminders")
public class ReminderController {

    @Autowired
    private FileUploadUtil fileUploadUtil;
    private UserService userService;
    private ReminderService reminderService;


    @Autowired
    public ReminderController(UserService userService, ReminderService reminderService) {
        this.userService = userService;
        this.reminderService = reminderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserReminders(@PathVariable String userName, Model model) {
        User user = userService.findUserByUsername(userName);
        model.addAttribute("user", user);
        model.addAttribute("reminderList", reminderService.findReminderByUser(user));
        model.addAttribute("reminder", new Reminder());

        return "reminders";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addNewReminder(@PathVariable String userName, @RequestParam("user-file") MultipartFile multipartFile, @Valid Reminder reminder, BindingResult resul, Model model) {
        User user = userService.findUserByUsername(userName);
        try {
            byte[] encodeBase64 = getImageEncodeBase64(multipartFile);
            String base64Encoded = new String(encodeBase64, "UTF-8");
            reminder.setImageLink(base64Encoded);

      /*   Amazon S3 usage temporary switched off
           String amazonS3ImageUrl = fileUploadUtil.saveImageToAmazonS3(multipartFile, userName);
                reminder.setImageLink(amazonS3ImageUrl);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!resul.hasErrors()) {
            reminderService.addReminder(reminder, user);
        } else {
            model.addAttribute("reminderList", reminderService.findReminderByUser(user));

            return "reminders";
        }
        return "redirect:/user/{userName}/reminders";
    }

    @RequestMapping(value = "/{reminderId}", method = RequestMethod.GET)
    public String getReminder(@PathVariable Integer reminderId, Model model) {
        Reminder userReminder = reminderService.findReminderById(reminderId);
        model.addAttribute("reminder", userReminder);

        return "reminder";
    }

    @RequestMapping(value = "/{reminderId}", method = {RequestMethod.DELETE})
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteReminder(@PathVariable Integer reminderId) {
        reminderService.deleteReminderById(reminderId);

        return "redirect:/user/{userName}/reminders";
    }

    private byte[] getImageEncodeBase64(MultipartFile multipartFile) throws IOException {
        return multipartFile.isEmpty() ?
                Base64.encodeBase64(IOUtils.toByteArray((new URL("http://www.yo-yoma.com/wp-content/themes/yym/assets/images/orangeWave.png")).openStream()), true)
                : Base64.encodeBase64(multipartFile.getBytes());
    }

}

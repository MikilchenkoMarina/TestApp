package com.inspoweb.utils.schedule;

import com.inspoDataBase.entity.Reminder;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.TimerTask;

/**
 * @author mmikilchenko on 15.03.2017.
 */
public class ReminderTimerTask extends TimerTask {
    private Reminder reminder;

    @Autowired
    public ReminderTimerTask(Reminder reminder) {
        this.reminder = reminder;
    }

    @Override
    public void run() {
        try {
            showReminderMessage(reminder);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void showReminderMessage(Reminder reminder) throws MalformedURLException {
        JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.requestFocusInWindow();
        jOptionPane.requestFocus();
        try {
            BufferedImage img = ImageIO.read(new URL(reminder.getImageLink()));
            ImageIcon icon = new ImageIcon(Thumbnails.of(img).forceSize(300, 300).asBufferedImage());
            System.setProperty("DISPLAY","0:0");
            jOptionPane.showMessageDialog(null, reminder.getText(), "Reminder", JOptionPane.DEFAULT_OPTION, icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

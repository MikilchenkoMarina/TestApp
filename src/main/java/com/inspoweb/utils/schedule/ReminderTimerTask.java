package com.inspoweb.utils.schedule;

import com.inspoDataBase.entity.Reminder;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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
/*        System.setProperty("java.awt.headless","true");
        System.setProperty("Djava.awt.headless","true");
        System.setProperty("-Djava.awt.headless","true");
        System.setProperty("DISPLAY","0.0 export DISPLAY");*/


/*        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            engine.eval("window.alert('MESSAGE')");
        } catch (ScriptException e) {
            e.printStackTrace();
        }*/


      JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.requestFocusInWindow();
        jOptionPane.requestFocus();
        try {
            BufferedImage img = ImageIO.read(new URL(reminder.getImageLink()));
            ImageIcon icon = new ImageIcon(Thumbnails.of(img).forceSize(300, 300).asBufferedImage());



            ;
      jOptionPane.showMessageDialog(null, reminder.getText(), "Reminder", JOptionPane.DEFAULT_OPTION, icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

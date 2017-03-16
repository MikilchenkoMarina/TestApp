package com.inspoDataBase.entity;

import org.springframework.stereotype.Component;

/**
 * @author mmikilchenko on 16.03.2017.
 */
@Component
public class RemindersAppearDelay {
    private int delay;

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}

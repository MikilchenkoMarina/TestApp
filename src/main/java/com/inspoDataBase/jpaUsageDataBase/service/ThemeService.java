package com.inspoDataBase.jpaUsageDataBase.service;

import com.inspoweb.model.Theme;
import com.inspoDataBase.jpaUsageDataBase.jpaRepository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mmikilchenko on 22.02.2017.
 */
@Service("themeService")
@Transactional
public class ThemeService {
    @Autowired
    ThemeRepository themeRepository;

    public void addTheme(Theme theme) {
        themeRepository.saveAndFlush(theme);
    }

    public List<Theme> findAllThemas() {
        return themeRepository.findAll();
    }


    public void printUserList(List<Theme> themeList) {
        for (Theme theme : themeList) {
            System.out.println(theme.toString());
        }
    }
}

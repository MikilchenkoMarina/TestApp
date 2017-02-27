package com.inspoDataBase.jpaUsageDataBase.jpaRepository;

import com.inspoDataBase.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author mmikilchenko on 24.02.2017.
 */
public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    Theme saveAndFlush(Theme theme);

    List<Theme> findAll();
}

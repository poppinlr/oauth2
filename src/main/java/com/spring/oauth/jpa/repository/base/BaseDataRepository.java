package com.spring.oauth.jpa.repository.base;


import com.spring.oauth.jpa.entity.base.BaseDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseDataRepository<T extends BaseDataEntity> extends JpaRepository<T, Long> {

    List<T> findByActive(boolean active);
}

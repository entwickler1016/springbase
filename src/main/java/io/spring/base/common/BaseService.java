package io.spring.base.common;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface BaseService<T> {

    @Transactional(readOnly = true)
    List<T> findAll();

    @Transactional(readOnly = true)
    T findById(String id);

    @Transactional
    T insert(T t);

    @Transactional
    T update(T t);

    @Transactional
    void delete(String id);
}
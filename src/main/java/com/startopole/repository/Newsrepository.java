package com.startopole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.startopole.entity.NewsEntity;


public interface Newsrepository extends JpaRepository<NewsEntity, Long> {
}

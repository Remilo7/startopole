package com.startopole.repository;

import com.startopole.entity.UzytkownikEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UzytkownikRepository extends JpaRepository<UzytkownikEntity, Long> {
}

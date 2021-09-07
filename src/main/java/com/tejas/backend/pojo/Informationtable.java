package com.tejas.backend.pojo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Informationtable extends JpaRepository<Information, Long> {

}

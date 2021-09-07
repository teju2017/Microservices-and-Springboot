package com.tejas.backend.pojo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityDetails extends JpaRepository<Activity,Long> {

}

package com.tejas.backend.pojo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {

}

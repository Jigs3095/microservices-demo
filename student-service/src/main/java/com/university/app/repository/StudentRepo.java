package com.university.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.app.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student , Long  >{

}

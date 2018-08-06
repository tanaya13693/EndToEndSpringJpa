package com.tanaya.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.tanaya.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}

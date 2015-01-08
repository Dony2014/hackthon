package com.oracle.hackthon.dao;

import com.oracle.hackthon.model.File;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<File, Long> {

}

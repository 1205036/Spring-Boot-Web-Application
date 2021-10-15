package com.repository.springbootwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repository.springbootwebapp.entity.FileRepository;

@Repository
public interface FileRepositoryRepository extends JpaRepository<FileRepository, Long> {

}

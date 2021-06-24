package com.nk.pma.pma.dao;

import java.util.List;

import com.nk.pma.pma.entities.Project;

import org.springframework.data.repository.CrudRepository;


public interface ProjectRepository extends CrudRepository<Project , Long >{
    @Override
    public List<Project> findAll();

    
    
}

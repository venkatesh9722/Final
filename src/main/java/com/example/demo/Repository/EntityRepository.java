package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Mini;

public interface EntityRepository extends JpaRepository<Mini, Integer>{

	

}

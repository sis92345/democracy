package com.democracy.sample.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

public interface TestRepository extends JpaRepository<TestData, Long> {
		
}
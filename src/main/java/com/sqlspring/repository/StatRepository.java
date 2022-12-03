package com.sqlspring.repository;

import com.sqlspring.sql.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, Long> {
}

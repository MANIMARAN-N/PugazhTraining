package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GstRepository extends JpaRepository<Gst, Integer> {

	@Query(value = "SELECT percentage FROM gst_api where hsn=:hsn",nativeQuery = true)
	public int getPriceByHsn(@Param("hsn") int hsn);
}

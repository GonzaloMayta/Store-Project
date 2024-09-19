package com.endesyc.project_store.Repository;

import com.endesyc.project_store.Entity.DetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DetailOrderRepository extends JpaRepository<DetailOrder, Integer> {


}

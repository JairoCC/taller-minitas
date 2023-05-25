package com.keycode.TallerMinitas.repository;
import com.keycode.TallerMinitas.models.DeminingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeminingTypeRepository extends JpaRepository<DeminingType, Integer> {

    List<DeminingType> findAll();

    Optional<DeminingType> findById(Integer id);

    List<DeminingType> findByRegion(String region);
}

package cau.capstone.ottitor.repository;

import cau.capstone.ottitor.domain.StationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationInfoRepository extends JpaRepository<StationInfo, Long> {

}


package cau.capstone.ottitor.repository;

import cau.capstone.ottitor.domain.Station;
import cau.capstone.ottitor.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByLineNumOrderByFrCodeAsc(String lineNum);
}


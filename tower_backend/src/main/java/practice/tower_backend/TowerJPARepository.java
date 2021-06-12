package practice.tower_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TowerJPARepository extends JpaRepository<TowerDto,Long> {
    
}

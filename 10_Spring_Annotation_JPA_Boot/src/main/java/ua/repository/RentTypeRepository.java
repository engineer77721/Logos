package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.RentType;

public interface RentTypeRepository extends JpaRepository<RentType, Integer>{

//	@Query("SELECT rt FROM RentType rt WHERE rt.name = ?1")
	RentType findByName(String name);
	
}

package ua.service.implementation;

import static ua.mapper.ApartmentMapper.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.domain.ApartmentIndex;
import ua.entity.Apartment;
import ua.repository.ApartmentRepository;
import ua.service.ApartmentService;

@Service
public class ApartmentServiceImpl extends CrudServiceImpl<Apartment, Integer> implements ApartmentService{

	private final ApartmentRepository repository;
	
	@Autowired
	public ApartmentServiceImpl(ApartmentRepository repository) {
		super(repository);
		this.repository = repository;
	}

//	@Override
//	public List<ApartmentIndex> findAllIndex() {
//		return toApartmentIndex(repository.findAllRentTypeAndAreaLoaded());
//	}
	
	@Override
	public List<ApartmentIndex> findAllIndex() {
		return repository.findApartmentIndex();
	}
}

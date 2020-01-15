package idv.tommy.jpa.dao.first;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import idv.tommy.jpa.entity.first.First;

@RepositoryRestResource
public interface FirstRepository extends JpaRepository<First, Integer> {
	
	
}

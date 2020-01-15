package idv.tommy.jpa.dao.second;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import idv.tommy.jpa.entity.second.Second;


@RepositoryRestResource
public interface SecondRepository extends JpaRepository<Second, Integer> {
	@Modifying   
	@Query(value = 
				"select * from test" 
		, nativeQuery = true)//?1表示第一個引數，?2表示第二個引數
		List<Second> findTestAll();
	
}

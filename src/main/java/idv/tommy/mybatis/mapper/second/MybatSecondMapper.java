package idv.tommy.mybatis.mapper.second;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import idv.tommy.jpa.entity.second.Second;

public interface MybatSecondMapper {
	List<Map<String,Object>> getAll();
	List<Map<String,Object>>  getOne(Integer id);
	void insert(@Param("testname") String testname,@Param("testauthor") String testauthor);
	void update(Second second);
	void delete(@Param("id") Integer id);
}

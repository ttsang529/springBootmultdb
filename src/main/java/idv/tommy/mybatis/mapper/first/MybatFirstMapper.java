package idv.tommy.mybatis.mapper.first;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import idv.tommy.jpa.entity.first.First;;

public interface MybatFirstMapper {
	List<First> getAll();
	First getOne(Integer bookid);
	void insert(@Param("name") String name,@Param("author")  String author);
	void update(@Param("bookid") Integer bookid,@Param("name") String name,@Param("author")  String author);
	void delete(@Param("id") Integer bookid);
}

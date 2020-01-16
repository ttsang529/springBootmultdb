package idv.tommy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idv.tommy.jpa.dao.first.FirstRepository;
import idv.tommy.jpa.dao.second.SecondRepository;
import idv.tommy.jpa.entity.first.First;
import idv.tommy.jpa.entity.second.Second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import idv.tommy.mybatis.mapper.second.MybatSecondMapper;
import idv.tommy.mybatis.mapper.first.MybatFirstMapper;


@RestController
//@RequestMapping("/first")
public class MultSQLController {
	
	@Autowired
    @Qualifier("firstJdbcTemplate")
    private JdbcTemplate firstJdbcTemplate;
	
	@RequestMapping("/jdbc/first")
	public List<Map<String, Object>> getBook() {

		String sql = "select * from book";
		List<Map<String, Object>> list = firstJdbcTemplate.queryForList(sql);

		return list;
	}
	
	
	
	@Autowired
    @Qualifier("secondJdbcTemplate")
    private JdbcTemplate secondJdbcTemplate;
	
	@RequestMapping("/jdbc/second")
	public List<Map<String, Object>> getTest() {

		String sql = "select * from test";
		List<Map<String, Object>> list = secondJdbcTemplate.queryForList(sql);

		return list;
	}
	
	
	@Autowired
    private FirstRepository firstRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "jpa/first")
    public List<First> getJpaFirst() {
        return firstRepository.findAll();
    }
    
	@Autowired
    private SecondRepository secondRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "jpa/second")
    public List<Second> getJpaSecond() {
        return secondRepository.findTestAll();
    }

    
    @Autowired
    private MybatFirstMapper MybatFirstMapper;

	@Autowired
	private MybatSecondMapper MybatSecondMapper;
	
	@RequestMapping("mybatis/first")
	public List<First> getfirst() {
		List<First> books=MybatFirstMapper.getAll();
		return books;
	}
	
	
	
	public static class GetFirstRequest {
	    private Integer bookid;
	    // getter, setter for name & number

		public Integer getFirstid() {
			return bookid;
		}

		public void setFirstid(Integer bookid) {
			this.bookid = bookid;
		}
	}
	
	
    @RequestMapping(value="/mybatis/first/id", method=RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public First getBook(@RequestBody GetFirstRequest request)throws IOException  {
    	System.out.println("Hello world");
		System.out.println(request.getFirstid());
    	First book=MybatFirstMapper.getOne(request.getFirstid());
        return book;
    }
    
    
	public static class InsertFirstRequest {
	    private String name;
	    private String author;
	    // getter, setter for name & number
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
	}
	
    @RequestMapping(value="/mybatis/first/insert", method=RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public String insertFirst(@RequestBody InsertFirstRequest request) throws IOException {
	    HashMap<String, String> map = new HashMap<>();
    	MybatFirstMapper.insert(request.getName(),request.getAuthor());
    	map.put("Insert", "Success");
    	return new Gson().toJson(map);
    }
    
    
	public static class UpdateFirstRequest {
		private Integer bookid;
	    private String name;
	    private String author;
	    // getter, setter for name & number
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Integer getBookid() {
			return bookid;
		}
		public void setBookid(Integer bookid) {
			this.bookid = bookid;
		}
	}
    @RequestMapping(value="/mybatis/first/update")
    @ResponseBody
    public String updateFirst(@RequestBody UpdateFirstRequest request) throws IOException {
    	HashMap<String, String> map = new HashMap<>();
    	System.out.println(request.getBookid());
    	MybatFirstMapper.update(request.getBookid(),request.getName(),request.getAuthor());
    	map.put("Update", "Success");
    	return new Gson().toJson(map);
    }
    
    @RequestMapping(value="/mybatis/first/delete/{bookid}")
    public String deleteFirst(@PathVariable("bookid") String bookid) {
    	HashMap<String, String> map = new HashMap<>();
//    	 System.out.println(bookid);
    	 MybatFirstMapper.delete(Integer.valueOf(bookid));
    	 map.put("Delete", "Success");
    	 return new Gson().toJson(map);
    }
    
    
    //Mybatis second db
	@RequestMapping("mybatis/second")
	public List<Map<String, Object>> getSecond() {
		List<Map<String, Object>>  tests=MybatSecondMapper.getAll();
		return tests;
	}
	
	public static class GetSecondRequest {
	    private Integer id;
	    // getter, setter for name & number

		public Integer getSecondid() {
			return id;
		}

		public void setSecondid(Integer id) {
			this.id = id;
		}
	}
	
	
    @RequestMapping(value="/mybatis/second/id", method=RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public   List<Map<String, Object>>  getBook(@RequestBody GetSecondRequest request)throws IOException  {
//		System.out.println(request.getSecondid());
    	return MybatSecondMapper.getOne(request.getSecondid());
    }
}

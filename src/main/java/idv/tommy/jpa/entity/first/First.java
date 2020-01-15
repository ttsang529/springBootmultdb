package idv.tommy.jpa.entity.first;

import javax.persistence.Id;  
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
@Entity
@Table(name = "book")
public class First {
    
    @Id
    @GeneratedValue
    private Integer bookid;
    private String name;
    private String author;

//    public First() {}

//    public First(Integer bookid,String name, String author) {
//    	this.bookid  = bookid;
//        this.name	 = name;
//        this.author	 = author;
//    }
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}   
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
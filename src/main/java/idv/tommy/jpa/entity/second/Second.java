package idv.tommy.jpa.entity.second;

import javax.persistence.Id;  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
//@Data
@Table(name = "test")
public class Second {
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    private String testname;

    private String testauthor;
    

    public Second() {}


	public String getTestname() {
		return testname;
	}


	public void setTestname(String testname) {
		this.testname = testname;
	}


	public String getTestauthor() {
		return testauthor;
	}


	public void setTestauthor(String testauthor) {
		this.testauthor = testauthor;
	}

//    public Second(String testname, String testauthor) {
//        this.testname	 = testname;
//        this.testauthor	 = testauthor;
//    }

}
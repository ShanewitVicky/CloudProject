/**
 * 
 */
package model;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;

/**
 * @author Shane
 *
 */
@Entity
@Index
public class User {

	@Id	private Long id;
	private String UserName;
	private String Email;
	private String Password;
	
	public User(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public User(String userName, String email, String password) {
		
		
		UserName = userName;
		Email = email;
		Password = password;
	}

}

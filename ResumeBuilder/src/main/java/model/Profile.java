package model;

import java.util.Date;

import com.google.appengine.api.blobstore.BlobKey;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;


@Entity
@Index
public class Profile {

	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private String street;
	private String city;
	private String country;
	private String website;
	private String gender;
	private Date dob;
	private String nationality;
	private String workCompanyName;
	private String workRole;
	private String technology;
	private String companyWebsite;
	private String collegeName;
	private String fieldOfStudy;
	private String gpa;
	private String collegeWebsite;
	private String skill;
	private BlobKey imageURL;
	@Parent Key<User> parent;
	
	
	
	
	public Key<User> getParent() {
		return parent;
	}

	public void setParent(Key<User> parent) {
		this.parent = parent;
	}

	public BlobKey getImageURL() {
		return imageURL;
	}

	public void setImageURL(BlobKey imageURL) {
		this.imageURL = imageURL;
	}

	public Profile() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getWorkCompanyName() {
		return workCompanyName;
	}

	public void setWorkCompanyName(String workCompanyName) {
		this.workCompanyName = workCompanyName;
	}

	public String getWorkRole() {
		return workRole;
	}

	public void setWorkRole(String workRole) {
		this.workRole = workRole;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public String getCollegeWebsite() {
		return collegeWebsite;
	}

	public void setCollegeWebsite(String collegeWebsite) {
		this.collegeWebsite = collegeWebsite;
	}

	public String getSkill() {
		return skill;
	}

	

	public void setSkill(String skill) {
		this.skill = skill;
	}

	

	public Profile(String firstName, String lastName, Long phoneNumber, String street, String city, String country,
			String website, String gender, Date dob, String nationality, String workCompanyName, String workRole,
			String technology, String companyWebsite, String collegeName, String fieldOfStudy, String gpa,
			String collegeWebsite, String skill, BlobKey imageURL, Key<User> parent) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.city = city;
		this.country = country;
		this.website = website;
		this.gender = gender;
		this.dob = dob;
		this.nationality = nationality;
		this.workCompanyName = workCompanyName;
		this.workRole = workRole;
		this.technology = technology;
		this.companyWebsite = companyWebsite;
		this.collegeName = collegeName;
		this.fieldOfStudy = fieldOfStudy;
		this.gpa = gpa;
		this.collegeWebsite = collegeWebsite;
		this.skill = skill;
		this.imageURL = imageURL;
		this.parent = parent;
	}
	
	
	

	

}

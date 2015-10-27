package org.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement(name = "student")
public class Student {

	private static final long serialVersionUID = 1L;
	@Id
  //  @GeneratedValue(strategy = IDENTITY)
	
	private int id=0;
	
	private String name;
	 private Date created = new Date();

	
    public Student() {
		super();
		
	}
    
    public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.created = new Date();
	}
	/**
	 * @return the id
	 */@XmlElement
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */@XmlElement
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the created
	 */@XmlElement
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */

	public void setCreated(Date created) {
		this.created = created;
	}

}

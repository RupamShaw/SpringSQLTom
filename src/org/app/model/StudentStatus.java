package org.app.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentStatus {
	private boolean status = false;

	public StudentStatus(boolean status) {
		super();
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public StudentStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

}

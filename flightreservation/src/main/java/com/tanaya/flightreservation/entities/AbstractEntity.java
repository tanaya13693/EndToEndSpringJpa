package com.tanaya.flightreservation.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
	
	@Id
	private long id;
	
	//Note: Add @GeneratedValue(strategy=GenerationType.AUTO) to id field to make field auto-incremented in DB

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

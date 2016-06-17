package com.javapapers.webservices.rest.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Animal {
	private String id;
	private String name;
	private String type;

	public Animal() {

	}

	public Animal(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
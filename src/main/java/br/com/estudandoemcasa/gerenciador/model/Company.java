package br.com.estudandoemcasa.gerenciador.model;

import java.util.Date;

public class Company {

	private Integer id;
	private String name;
	private Date dateOpen = new Date();
	public static Integer count;

	public Company() {
	}

	public Company(Integer id, String name, Date dateOpen) {
		this.id = id;
		this.name = name;
		this.dateOpen = dateOpen;
		count = this.id;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDateOpen(Date dateOpen) {
		this.dateOpen = dateOpen;
	}

	public Date getDateOpen() {
		return dateOpen;
	}

	@Override
	public String toString() {
		return this.name + " : " + this.id;
	}

}

package br.com.estudandoemcasa.gerenciador.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bank {

	private static List<Company> companys = new ArrayList<>();

	public Bank() {
	}

	static {
		Company company = new Company(1, "Company One", new Date());
		Company company2 = new Company(2, "Company Two", new Date());
		companys.add(company);
		companys.add(company2);
	}

	public void addCompany(Company company) {
		companys.add(company);
	}

	public List<Company> listCompany() {
		return companys;
	}

	public void setCompany(Company company) {
		Company aux = this.existCompanyId(company.getId());
		aux.setName(company.getName());
		aux.setDateOpen(company.getDateOpen());
	}

	public Company existCompanyId(Integer idCompany) {
		for (Company cp : this.listCompany()) {
			if (cp.getId().equals(idCompany)) { 
				return cp;
			}
		}
		return null;
	}

	public Boolean existCompanyName(String companyName) {
		for (Company cp : this.listCompany()) {
			if (cp.getName().equals(companyName)) {
				return true;
			}
		}
		return false;
	}

	public Company getCompany(Company company) {
		for (Company cp : this.listCompany()) {
			if (cp.getName().equals(company.getName())) {
				return company;
			}
		}
		return null;
	}
	
	public Boolean removeCompany(Company company) {
		return companys.remove(company);
	}

}

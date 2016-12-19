package com.emmaobo.expensetracker.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.emmaobo.expensetracker.enumeration.AccountType;

@Entity
@Table(name="USERS")
public class User 
{
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Enumerated(EnumType.STRING)
	private AccountType account;
	
	@OneToMany(targetEntity=ExpenseList.class, mappedBy="owner")
	private List<ExpenseList> list;

	
	public User(){}
	
	public User(String username, String password, String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AccountType getAccount() {
		return account;
	}

	public void setAccount(AccountType account) {
		this.account = account;
	}

	public List<ExpenseList> getList() {
		return list;
	}

	public void setList(List<ExpenseList> list) {
		this.list = list;
	}
	
	public void addList(ExpenseList newList)
	{
		this.list.add(newList);
	}
	
}

package com.emmaobo.expensetracker.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.emmaobo.expensetracker.enumeration.Priority;
import com.emmaobo.expensetracker.enumeration.Status;


@Entity
@Table(name="ITEM")
public class Item 
{
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="NOTE")
	private String note;
	
	@Column(name="COST")
	private BigDecimal cost;
	
	@Column(name="PRIORITY")
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LIST_ID")
	private ExpenseList list;

	public Item(){}
	
	public Item(String itemName, BigDecimal cost)
	{
		this.itemName = itemName;
		this.cost = cost;
		setStatus(Status.INCOMPLETE);
		setPriority(Priority.LOW);
	}
	
	public Item(String itemName, BigDecimal cost, Priority priority)
	{
		this.itemName = itemName;
		this.cost = cost;
		this.priority = priority;
		setStatus(Status.INCOMPLETE);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ExpenseList getList() {
		return list;
	}

	public void setList(ExpenseList list) {
		this.list = list;
	}

}

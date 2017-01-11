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
import com.emmaobo.expensetracker.jsonview.View;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="ITEM")
public class Item implements Comparable<Item>
{
	@Id @GeneratedValue
	private Long id;
	
	@JsonView(View.Public.class)
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@JsonView(View.Public.class)
	@Column(name="NOTE")
	private String note;
	
	@JsonView(View.Public.class)
	@Column(name="COST")
	private BigDecimal cost;
	
	@JsonView(View.Public.class)
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

	@Override
	public int compareTo(Item o) {
		if(this.priority == o.priority)
			return 0;
		
		if(this.priority == Priority.HIGH && o.priority != Priority.HIGH)
			return -1;
		
		if(this.priority == Priority.LOW && (o.priority == Priority.HIGH ||
				o.priority == Priority.MEDIUM))
			return 1;
		
		if(this.priority == Priority.MEDIUM && o.priority == Priority.HIGH)
			return 1;
		
		if(this.priority == Priority.MEDIUM && o.priority == Priority.LOW)
			return -1;
		
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (priority != other.priority)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	
}

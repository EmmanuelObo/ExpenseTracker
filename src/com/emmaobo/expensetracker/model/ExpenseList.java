package com.emmaobo.expensetracker.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EXPENSE_LIST")
public class ExpenseList 
{
	@Id @GeneratedValue
	private Long id;
	
	private String title;
	
	@Column(name = "TOTAL")
	private BigDecimal total;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="OWNER_ID")
	private User owner;
	
	@OneToMany(targetEntity = Item.class, mappedBy="list")
	private List<Item> items;
	
	private String dateCreated;
	
	public ExpenseList(){}
	
	public ExpenseList(String title)
	{
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		if(items != null && items.size() > 0)
		{
			for(Item item : items)
			{
				total = total.add(item.getCost());
			}
		}
		return total;
	}

	public void setTotal(BigDecimal total) {
	
		this.total = total;
	}

	public List<Item> getItems() {
		Collections.sort(items);
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public int listSize()
	{
		return items.size();
	}
	
	public void addItem(Item item)
	{
		items.add(item);
	}
}

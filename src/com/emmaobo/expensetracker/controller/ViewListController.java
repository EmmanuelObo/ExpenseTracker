package com.emmaobo.expensetracker.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emmaobo.expensetracker.model.ExpenseList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ViewListController 
{

	@RequestMapping("/view-list")
	public ExpenseList viewList(@RequestParam(value="listTitle")String title)
	{
		return new ExpenseList(title);
	}
	
	@RequestMapping(value="/view-list", method=RequestMethod.POST)
	public ExpenseList viewSelectedList(HttpServletRequest request, 
			@RequestBody String json) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		ExpenseList list = mapper.readValue(json, ExpenseList.class);
			
		return list;
	}
}


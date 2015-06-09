package com.ncs.gsyt.modules.model;

import java.io.Serializable;

public class Maps implements Serializable, Comparable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String value;
	private String value1;
	private String link;
	private String color;
	private long id;

	
	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
    public int compareTo(Object o){  
		Maps map = (Maps)o;
		return new Long(this.id - map.id).intValue();
	}
	
	@Override
    public boolean equals(Object o){
		boolean flag = false;
		if(o instanceof Maps){
			if(this.id == ((Maps)o).id) {
				 flag = true;
			}
		}
		return flag;
	}
}

package com.algorand.starter.demo.model;

public class TransferEntity {

	private String id;
	private String type;
	
	public TransferEntity(String id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}

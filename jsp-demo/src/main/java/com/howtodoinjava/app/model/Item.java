package com.howtodoinjava.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	private Long id;
	  private String name;

  public Item(long id, String name) {
	this.id=id;
	this.name= name;
	}

  
//  public Item() {
//	  
//  }
//  public Item(Long id, String name) {
//	  this.id=id;
//	  this.name=name;
//  }
}

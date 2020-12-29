package com.account.chaining.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product_details")
public class ProductDTO implements Serializable {
	@GenericGenerator(name="ref",strategy="increment")
	@GeneratedValue(generator="ref")
	@Id
	@Column(name = "prod_id")
	private int id;
	@Column(name = "prod_name")
	private String name;
	@Column(name = "prod_quantity")
	private int quantity;
	@Column(name = "prod_totalSum")
	private double totalSum;
}

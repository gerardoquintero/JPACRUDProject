package com.skilldistillery.pokemon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	private String name;
	private String description;
	@Column(name = "image_url")
	private String imageUrl;

	public Pokemon() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl + "]";
	}

}

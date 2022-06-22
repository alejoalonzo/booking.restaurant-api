package com.boot.booking.restaurantapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="NOTIFICATION")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "TEMPLATE")
	private String  template;
	
	@Column(name = "TEMPLATE_TYPE")
	private String  templateType;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getTemplate() {
		return template;
	}

	public final void setTemplate(String template) {
		this.template = template;
	}

	public final String getTemplateType() {
		return templateType;
	}

	public final void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
}

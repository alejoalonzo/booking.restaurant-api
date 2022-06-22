package com.boot.booking.restaurantapi.dtos;

public class EmailTemplateDto {

	private Long id;
	private String template;
	private String subject;
	private String templateType;
	
	
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
	public final String getSubject() {
		return subject;
	}
	public final void setSubject(String subject) {
		this.subject = subject;
	}
	public final String getTemplateType() {
		return templateType;
	}
	public final void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
}

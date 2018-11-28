package com.gsk.web.platform.gsk_aem_web_platform.core.objects;

/**
 * AccordianItem DTO
 *
 * @author TechChefz (TCZ Consulting LLP)
 *
 */
public class AccordianItem {

	private String heading;
	private String styleClass;
	private String expanded;
	private String bodyType;
	private String bodyText;
	private String parsysId;
	
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getStyleClass() {
		return styleClass;
	}
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	public String getExpanded() {
		return expanded;
	}
	public void setExpanded(String expanded) {
		this.expanded = expanded;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getBodyText() {
		return bodyText;
	}
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}
	public String getParsysId() {
		return parsysId;
	}
	public void setParsysId(String parsysId) {
		this.parsysId = parsysId;
	}
	
}

package com.gsk.web.platform.gsk_aem_web_platform.core.objects;

import java.util.List;

/**
 * MenuItem DTO
 *
 * @author Photon Infotech
 *
 */
public class MenuItem {
	
	private String text;
	private String url;
	private String openInNewWindow;
	private String mode;
	private String type;
	private String icon;
	private String color;
	private String parentPagePath;
	private List<MenuItem> subLinks;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOpenInNewWindow() {
		return openInNewWindow;
	}
	public void setOpenInNewWindow(String openInNewWindow) {
		this.openInNewWindow = openInNewWindow;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getParentPagePath() {
		return parentPagePath;
	}
	public void setParentPagePath(String parentPagePath) {
		this.parentPagePath = parentPagePath;
	}
	public List<MenuItem> getSubLinks() {
		return subLinks;
	}
	public void setSubLinks(List<MenuItem> subLinks) {
		this.subLinks = subLinks;
	}
		
}
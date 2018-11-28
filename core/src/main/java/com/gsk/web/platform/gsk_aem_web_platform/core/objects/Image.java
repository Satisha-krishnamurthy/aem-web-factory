package com.gsk.web.platform.gsk_aem_web_platform.core.objects;

import com.gsk.web.platform.gsk_aem_web_platform.core.utils.LinkUtil;

/**
 * Image DTO
 *
 * @author TechChefz (TCZ Consulting LLP)
 *
 */
public class Image extends Asset {
	
	private String altText;
	private String screenReaderText;
	private String hyperlink;
	
	public String getAltText() {
		return altText;
	}

	public void setAltText(String altText) {
		this.altText = altText;
	}

	public String getScreenReaderText() {
		return screenReaderText;
	}

	public void setScreenReaderText(String screenReaderText) {
		this.screenReaderText = screenReaderText;
	}

	public String getHyperlink() {
		return LinkUtil.getFormattedURL(hyperlink);
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}
	
}
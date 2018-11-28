package com.gsk.web.platform.gsk_aem_web_platform.core.models.common;

import org.osgi.annotation.versioning.ConsumerType;

/**
 * Header Model
 *
 * @author Photon Infotech
 *
 */

@ConsumerType
public interface HeaderModel {

	public String getIncludeLogo();
	
	public String getBrandLogoImage();
	
	public String getBrandLogoImageAltText();
	
	public String getBrandLogoUrl();
	
	public String getIncludeNavigation();
	
	public String getIncludeLogin();
	
	public String getIncludeSearch();
	
	public String getIncludeLangSelector();
	
	public String getSticky();
	
}

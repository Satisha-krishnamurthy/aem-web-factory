package com.gsk.web.platform.gsk_aem_web_platform.core.models.common;

import org.osgi.annotation.versioning.ConsumerType;

/**
 * Search Input Model
 *
 * @author Photon Infotech
 *
 */
@ConsumerType
public interface SearchInputModel {	
	
	public String getSearchAPI();
	
	public String getSearchResultPage();
	
	public String getEnableAutoSuggest();
	
	public int getAutoSuggestMinCharCount();
	
	public int getAutoSuggestMaxResultCount();
	
	public String getSearchLabelText();
	
	public String getPlaceholderText();
	
	public String getSearchLogoClass();
	
	public String getSearchLogoImage();
	
	public String getLogoImageAltText();
	
	public String getCtaLabel();
	
}

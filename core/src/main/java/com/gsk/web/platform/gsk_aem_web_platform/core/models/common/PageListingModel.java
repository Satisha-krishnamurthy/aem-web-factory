package com.gsk.web.platform.gsk_aem_web_platform.core.models.common;

import java.util.List;
import org.osgi.annotation.versioning.ConsumerType;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.PageObject;

/**
 * Page Listing Model
 *
 * @author Photon Infotech
 *
 */
@ConsumerType
public interface PageListingModel {
	
	public List<PageObject> getPages();
	
	public String getHeading();
	
	public String getCtaLabel();
	
	public String getLimitResult();

	public int getMaxResultLimit();
	
	public String getLoadMoreText();
	
	public String getLoadMoreLink();
	
}

package com.gsk.web.platform.gsk_aem_web_platform.core.models.common;

import org.osgi.annotation.versioning.ConsumerType;

/**
 * Tab Menu Model
 *
 * @author Photon Infotech
 *
 */
@ConsumerType
public interface TabMenuModel {
	
	public String getViewType();
	
	public String getSectionHeading();
	
}

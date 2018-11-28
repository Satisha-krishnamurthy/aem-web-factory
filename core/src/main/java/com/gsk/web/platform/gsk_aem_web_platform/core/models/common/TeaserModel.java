package com.gsk.web.platform.gsk_aem_web_platform.core.models.common;

import org.osgi.annotation.versioning.ConsumerType;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.Image;

/**
 * Teaser Model
 *
 * @author Photon Infotech
 *
 */
@ConsumerType
public interface TeaserModel {
	
	public String getTitle();
	
	public Image getImage();
	
	public String getDescription();
	
	public String getCtaText();
	
	public String getCtaOpenInNewWindow();
	
	public String getLink();
	
}

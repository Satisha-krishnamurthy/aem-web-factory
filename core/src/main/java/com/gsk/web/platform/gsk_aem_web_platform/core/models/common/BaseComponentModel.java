package com.gsk.web.platform.gsk_aem_web_platform.core.models.common;

import org.osgi.annotation.versioning.ConsumerType;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.WCMComponent;

/**
 * Base Component Model
 *
 * @author TechChefz (TCZ Consulting LLP)
 *
 */
@ConsumerType
public interface BaseComponentModel {
	
	public WCMComponent getComponent();
	
}

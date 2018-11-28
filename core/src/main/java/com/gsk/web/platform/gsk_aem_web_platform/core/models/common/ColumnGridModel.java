package com.gsk.web.platform.gsk_aem_web_platform.core.models.common;

import java.util.List;
import org.osgi.annotation.versioning.ConsumerType;

/**
 * Column Grid Model
 *
 * @author Photon Infotech
 *
 */
@ConsumerType
public interface ColumnGridModel {
	
	public String getSectionHeading();
	
	public List<String> getColumnList();
	
}

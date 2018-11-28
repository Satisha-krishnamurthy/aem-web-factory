package com.gsk.web.platform.gsk_aem_web_platform.core.models.common;

import java.util.List;
import org.osgi.annotation.versioning.ConsumerType;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.MenuItem;

/**
 * List Of Links Model
 *
 * @author Photon Infotech
 *
 */
@ConsumerType
public interface ListOfLinksModel {
	
	public String getSectionHeading();
	
	public List<MenuItem> getListItems();

}

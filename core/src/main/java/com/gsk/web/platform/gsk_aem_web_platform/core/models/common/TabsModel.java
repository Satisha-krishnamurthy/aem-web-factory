package com.gsk.web.platform.gsk_aem_web_platform.core.models.common;

import java.util.List;
import org.osgi.annotation.versioning.ConsumerType;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.TabItem;

/**
 * Tab Menu Model
 *
 * @author Photon Infotech
 *
 */
@ConsumerType
public interface TabsModel {
	
	public String getViewType();
	
	public List<TabItem> getTabItems();
	
}

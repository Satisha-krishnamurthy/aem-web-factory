package com.gsk.web.platform.gsk_aem_web_platform.core.services;

import java.util.Map;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.WCMComponent;

public interface ComponentsUtilService {

	public Map<String,WCMComponent> getComponents();
	
	public WCMComponent getComponentDetails(String componentName, String customHeight, String customStyleClass, String hideOnMobile, String hideOnTablet);
	
}

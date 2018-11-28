package com.gsk.web.platform.gsk_aem_web_platform.core.services.impl;

import org.osgi.framework.Constants;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.WCMComponent;
import com.gsk.web.platform.gsk_aem_web_platform.core.services.ComponentsUtilService;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Implementation of Components Configuration Service
 */
@Component(
		immediate = true,
		service = { ComponentsUtilService.class },
		enabled = true,
		property = {
				Constants.SERVICE_DESCRIPTION + "=" + "Components Util Service Implementation"
		}
	)
public class ComponentsUtilServiceImpl implements ComponentsUtilService {

    private static final Logger log = LoggerFactory.getLogger(ComponentsUtilServiceImpl.class);
    
    @Activate
    protected final void activate(final Map<Object, Object> config) {
        log.info("Activated ComponentsConfigurationServiceImpl");
    }

    @Deactivate
    protected void deactivate(ComponentContext ctx) throws Exception {
        log.info("Deactivated ComponentsConfigurationServiceImpl");
    }
    
    @Override
    public Map<String,WCMComponent> getComponents(){
    	
    	Map<String,WCMComponent> components = new HashMap<>();
    	
    	WCMComponent component = new WCMComponent();
    	component.setName("login");
    	component.setPath("re-platform/components/content/common/login");
    	components.put("login", component);
    	
		return components;
    }
    
    @Override 
    public WCMComponent getComponentDetails(String componentName, String customHeight, String customStyleClass, String hideOnMobile, String hideOnTablet) {
		
		WCMComponent componentDetails = new WCMComponent();
		
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		
		componentDetails.setName(componentName);
		componentDetails.setId(componentName + randomNumber);
		componentDetails.setCustomHeight(customHeight);
		componentDetails.setCustomStyleClass(customStyleClass);
		componentDetails.setHideOnMobile(hideOnMobile);
		componentDetails.setHideOnTablet(hideOnTablet);
		componentDetails.setRandomNumber(Integer.toString(randomNumber));
		
		return componentDetails;	
	}
    
}
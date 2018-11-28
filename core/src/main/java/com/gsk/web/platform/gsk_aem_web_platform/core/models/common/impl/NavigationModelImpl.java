package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.NavigationModel;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.MenuItem;

/**
 * Sling Model Implementation of Navigation Model
 *
 * @author Photon Infotech
 *
 */
@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = NavigationModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class NavigationModelImpl implements NavigationModel {
	
	private static final Logger log = LoggerFactory.getLogger(NavigationModelImpl.class);
	
	@SlingObject
	private ResourceResolver resourceResolver;
		
	@ValueMapValue @Optional
	@Default(values = "{}")
	private String[] menuItems;
	
	@ValueMapValue @Optional
	private String hamburgerMenuText;
	
	private List<MenuItem> menuList;
	
    @PostConstruct
    public void init() { 
    	
    	try {
    	
    		menuList = new LinkedList<>();
    		Gson gson = new Gson();
    		
    		for (String itemString : menuItems) {
    			MenuItem menuItem = gson.fromJson(itemString, MenuItem.class);
    			
    			if(menuItem.getMode().equalsIgnoreCase("auto")) {
	    			Resource parentPageResource = resourceResolver.getResource(menuItem.getParentPagePath());

					if((parentPageResource != null) && (parentPageResource instanceof Resource)) {
						//$(parentPageResource).listChildren(“cq:Page”);
					}
    			} else if(menuItem.getMode().equalsIgnoreCase("manual")) {
    				
    			}
    			
    			menuList.add(menuItem);
    		}
    	} catch(Exception e) {
        	log.error("Exception in init method of NavigationModelImpl :: " + e.getMessage());
    	}
    }
    
	@Override
	public List<MenuItem> getMenuList() {
		return menuList;
	}
	
	@Override
	public String getHamburgerMenuText() {
		return hamburgerMenuText;
	}
	
}
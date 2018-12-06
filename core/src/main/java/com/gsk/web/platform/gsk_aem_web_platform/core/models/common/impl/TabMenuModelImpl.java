package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

import com.google.gson.Gson;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.TabMenuModel;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.TabItem;

import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = TabMenuModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class TabMenuModelImpl implements TabMenuModel {

	/** Logger. **/
	private static final Logger log = LoggerFactory.getLogger(TabMenuModelImpl.class);
	
	@ValueMapValue @Optional
	@Default(values="tabs")
	private String viewType;
	
	@ValueMapValue @Optional
	private String sectionHeading;
	
	@ValueMapValue @Optional
	@Default(values="{}")
	private String[] tabItems;
	
	List<TabItem> tabItemList;
	
    @PostConstruct
    private void init() {
        log.info("inside init of tab menu");
        
        tabItemList = new LinkedList<>();
        
        Gson gson = new Gson();
        for(String itemString : tabItems) {
        	TabItem tabItem = gson.fromJson(itemString, TabItem.class);
        	tabItemList.add(tabItem);
        }
    }

    @Override
    public String getViewType() {
        return viewType;
    }
    
    @Override
    public String getSectionHeading() {
        return sectionHeading;
    }

}
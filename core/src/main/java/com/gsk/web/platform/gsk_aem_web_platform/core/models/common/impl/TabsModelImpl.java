package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import com.google.gson.Gson;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.TabsModel;
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
		adapters = TabsModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class TabsModelImpl implements TabsModel {

	/** Logger. **/
	private static final Logger log = LoggerFactory.getLogger(TabsModelImpl.class);
	
	@ValueMapValue @Optional
	@Default(values="tabs")
	private String viewType;
	
	@ValueMapValue @Optional
	@Default(values="{}")
	private String[] tabItems;
	
	List<TabItem> tabItemList;
	
    @PostConstruct
    private void init() {
        
        tabItemList = new LinkedList<>();
        
        Gson gson = new Gson();
        int count = 0;
        for(String itemString : tabItems) {
        	TabItem tabItem = gson.fromJson(itemString, TabItem.class);
        	count++;
        	tabItem.setParsysId("tab-par-" + count);
        	tabItemList.add(tabItem);
        }
    }

    @Override
    public String getViewType() {
        return viewType;
    }
    
    @Override
    public List<TabItem> getTabItems() {
        return tabItemList;
    }

}
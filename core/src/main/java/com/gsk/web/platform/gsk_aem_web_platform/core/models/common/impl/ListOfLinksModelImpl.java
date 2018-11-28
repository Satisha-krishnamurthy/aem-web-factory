package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.ListOfLinksModel;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.MenuItem;

/**
 * Sling Model Implementation of List Of Links Model
 *
 * @author Photon Infotech
 *
 */
@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = ListOfLinksModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class ListOfLinksModelImpl implements ListOfLinksModel {

	Logger logger = LoggerFactory.getLogger(ListOfLinksModelImpl.class);
	
	@Inject @Optional
	private String customHeight;
	
	@Inject @Optional
	private String customStyleClass;
	
	@Inject @Optional
	private String hideOnMobile;
	
	@Inject @Optional
	private String hideOnTablet;
	
	@Inject
	private String sectionHeading;
	
	@Inject
	@Default(values = "{}")
	private String[] listofLinks;

	private List<MenuItem> listItems;
	
	@PostConstruct
	protected void init() {
				
		Gson gson = new Gson();
		
		listItems = new LinkedList<MenuItem>();
		
		for (String linkString : listofLinks) {
			MenuItem menuItem = gson.fromJson(linkString, MenuItem.class);
			listItems.add(menuItem);
		}
	}
	
	@Override
	public String getSectionHeading() {
		return sectionHeading;
	}
	
	@Override
	public List<MenuItem> getListItems() {
		return listItems;
	}
	
}
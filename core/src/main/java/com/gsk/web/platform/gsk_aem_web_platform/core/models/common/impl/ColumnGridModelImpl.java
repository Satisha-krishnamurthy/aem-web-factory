package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import java.util.ArrayList;
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
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.ColumnGridModel;

/**
 * Sling Model Implementation of Column Grid Model
 *
 * @author Photon Infotech
 *
 */
@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = ColumnGridModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class ColumnGridModelImpl implements ColumnGridModel { 
	
	/** Logger. **/
	private static final Logger log = LoggerFactory.getLogger(ColumnGridModelImpl.class);
	
	@ValueMapValue @Optional
	private String sectionHeading;
	
	@ValueMapValue @Optional
	@Default(intValues=1)
	private int columns;
	
	private List<String> columnList;
	
	@PostConstruct
	public void init() {
				
		columnList = new ArrayList<>();
		
		for(int count=0; count<columns; count++) {
			columnList.add("col-par-"+count+1);
		}
	}
	
	@Override
	public String getSectionHeading() {
		return sectionHeading;
	}
	
	@Override
	public List<String> getColumnList() {
		return columnList;
	}
	
}
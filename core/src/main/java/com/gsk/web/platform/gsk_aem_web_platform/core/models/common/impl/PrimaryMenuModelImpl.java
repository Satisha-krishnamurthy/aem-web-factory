package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import javax.annotation.PostConstruct;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.PrimaryMenuModel;

/**
 * Sling Model Implementation of Primary Menu Model
 *
 * @author Photon Infotech
 *
 */
@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = PrimaryMenuModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class PrimaryMenuModelImpl implements PrimaryMenuModel {
	
	/** Logger. **/
	private static final Logger log = LoggerFactory.getLogger(PrimaryMenuModelImpl.class);

	@PostConstruct
	public void init() {
		
		log.info("inside breadcrumb model");
		
	}
	
	@Override
	public String getA() {
		return "";
	}
	
}

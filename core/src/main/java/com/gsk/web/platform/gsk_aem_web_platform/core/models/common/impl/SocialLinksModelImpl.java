package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.SearchInputModel;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.SocialLinksModel;

/**
 * Sling Model Implementation of Social Links Model
 *
 * @author Photon Infotech
 *
 */

@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = SocialLinksModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class SocialLinksModelImpl implements SocialLinksModel {

	/** Logger. **/
	private static final Logger log = LoggerFactory.getLogger(SocialLinksModel.class);
	
	@PostConstruct
	public void init() {
		
			
	}
	
}

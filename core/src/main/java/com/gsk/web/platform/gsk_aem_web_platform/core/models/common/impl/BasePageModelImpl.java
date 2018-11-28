package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.BasePageModel;

/**
 * Sling Model Implementation of Base Page Model
 *
 * @author Photon Infotech
 *
 */
@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = BasePageModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class BasePageModelImpl implements BasePageModel {

	/** Logger. **/
	private static final Logger log = LoggerFactory.getLogger(BasePageModelImpl.class);

	@Self
    private SlingHttpServletRequest request;

    @Self
    private Resource resource;

	@PostConstruct
	public void init() {
		try {
			log.info("inside base page model");

		} catch (Exception e) {
			log.error("Exception in init method of BasePageModelImpl :: " + e.getMessage());
		}
	}

}
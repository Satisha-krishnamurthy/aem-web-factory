package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.BaseComponentModel;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.WCMComponent;
import com.gsk.web.platform.gsk_aem_web_platform.core.services.ComponentsUtilService;

/**
 * Sling Model Implementation of Base Page Model
 *
 * @author Photon Infotech
 *
 */
@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = BaseComponentModel.class,
        resourceType = "gskwebplatform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class BaseComponentModelImpl implements BaseComponentModel {

	/** Logger. **/
	private static final Logger log = LoggerFactory.getLogger(BaseComponentModelImpl.class);

	@OSGiService
	ComponentsUtilService componentUtilService;
	
	@Self
	Resource resource;
	
	@ValueMapValue @Optional
	private String customHeight;
	
	@ValueMapValue @Optional
	private String customStyleClass;
	
	@ValueMapValue @Optional
	private String hideOnMobile;
	
	@ValueMapValue @Optional
	private String hideOnTablet;
	
	private WCMComponent wcmComponent;

	@PostConstruct
	public void init() {
		try {
			
			wcmComponent = componentUtilService.getComponentDetails(resource.getName(), customHeight, customStyleClass, hideOnMobile, hideOnTablet);

		} catch (Exception e) {
			log.error("Exception in init method of BaseComponentModelImpl :: " + e.getMessage());
		}
	}
	
	@Override
	public WCMComponent getComponent() {
		return wcmComponent;
	}

}
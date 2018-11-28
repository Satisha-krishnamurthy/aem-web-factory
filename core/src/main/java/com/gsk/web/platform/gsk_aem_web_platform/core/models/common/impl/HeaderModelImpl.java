package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import javax.annotation.PostConstruct;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.HeaderModel;
import com.gsk.web.platform.gsk_aem_web_platform.core.utils.LinkUtil;

/**
 * Sling Model Implementation of Header Model
 *
 * @author Photon Infotech
 *
 */
@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = HeaderModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class HeaderModelImpl implements HeaderModel {
	
	/** Logger. **/
	private static final Logger log = LoggerFactory.getLogger(HeaderModelImpl.class);
	
	@ValueMapValue @Optional
	@Default(values="true")
	private String includeLogo;
	
	@ValueMapValue @Optional
	private String brandLogoImage;
	
	@ValueMapValue @Optional
	private String brandLogoAltText;
	
	@ValueMapValue @Optional
	private String brandLogoUrl;
	
	@ValueMapValue @Optional
	@Default(values="true")
	private String includeSearch;
	
	@ValueMapValue @Optional
	@Default(values="true")
	private String includeNavigation;
	
	@ValueMapValue @Optional
	@Default(values="true")
	private String includeLogin;
	
	@ValueMapValue @Optional
	@Default(values="true")
	private String includeLangSelector;
	
	@ValueMapValue @Optional
	@Default(values="true")
	private String sticky;
	

	@PostConstruct
	public void init() {
		
		
	}
	
	@Override
	public String getIncludeLogo() {
		return includeLogo;
	}
	
	@Override
	public String getBrandLogoImage() {
		return brandLogoImage;
	}
	
	@Override
	public String getBrandLogoImageAltText() {
		return brandLogoAltText;
	}
	
	@Override
	public String getBrandLogoUrl() {
		return LinkUtil.getFormattedURL(brandLogoUrl);
	}
	
	@Override
	public String getIncludeNavigation() {
		return includeNavigation;
	}
	
	@Override
	public String getIncludeLogin() {
		return includeLogin;
	}
	
	@Override
	public String getIncludeSearch() {
		return includeSearch;
	}
	
	@Override
	public String getIncludeLangSelector() {
		return includeLangSelector;
	}
	
	@Override
	public String getSticky() {
		return sticky;
	}

}

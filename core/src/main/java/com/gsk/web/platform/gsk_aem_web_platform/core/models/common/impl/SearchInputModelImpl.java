package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import javax.annotation.PostConstruct;
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
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.SearchInputModel;
import com.gsk.web.platform.gsk_aem_web_platform.core.utils.LinkUtil;

/**
 * Sling Model Implementation of Search Input Model
 *
 * @author Photon Infotech
 *
 */
@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = SearchInputModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class SearchInputModelImpl implements SearchInputModel {
	
	/** Logger. **/
	private static final Logger log = LoggerFactory.getLogger(SearchInputModelImpl.class);
	
	@ValueMapValue @Optional
	@Default(values="global")
	private String searchContentType;
	
	@ValueMapValue @Optional
	private String searchResultPage;
	
	@ValueMapValue @Optional
	@Default(values="false")
	private String enableAutoSuggest;
	
	@ValueMapValue @Optional
	@Default(intValues=3)
	private int autoSuggestMinCharCount;
	
	@ValueMapValue @Optional
	@Default(intValues=10)
	private int autoSuggestMaxResultCount;
	
	@ValueMapValue @Optional
	private String searchLabelText;
	
	@ValueMapValue @Optional
	private String placeholderText;
	
	@ValueMapValue @Optional
	private String searchLogoClass;
	
	@ValueMapValue @Optional
	private String searchLogoImage;
	
	@ValueMapValue @Optional
	private String logoImageAltText;
	
	@ValueMapValue @Optional
	private String ctaLabel;
	
	private String searchAPI;
	
    @PostConstruct
    public void init() {    
    	
    }
	
	@Override
	public String getSearchAPI() {
		return searchAPI;
	}
	
	@Override
	public String getSearchResultPage() {
		return LinkUtil.getFormattedURL(searchResultPage);
	}
	
	@Override
	public String getEnableAutoSuggest() {
		return enableAutoSuggest;
	}
	
	@Override
	public int getAutoSuggestMinCharCount() {
		return autoSuggestMinCharCount;
	}
	
	@Override
	public int getAutoSuggestMaxResultCount() {
		return autoSuggestMaxResultCount;
	}
	
	@Override
	public String getSearchLabelText() {
		return searchLabelText;
	}
	
	@Override
	public String getPlaceholderText() {
		return placeholderText;
	}
	
	@Override
	public String getSearchLogoClass() {
		return searchLogoClass;
	}
	
	@Override
	public String getSearchLogoImage() {
		return searchLogoImage;
	}
	
	@Override
	public String getLogoImageAltText() {
		return logoImageAltText;
	}
	
	@Override
	public String getCtaLabel() {
		return ctaLabel;
	}
	
}
package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.TeaserModel;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.Image;
import com.gsk.web.platform.gsk_aem_web_platform.core.utils.LinkUtil;

/**
 * Sling Model Implementation of Teaser Model
 *
 * @author Photon
 *
 */
@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = TeaserModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class TeaserModelImpl implements TeaserModel { 
	
	/** Logger. **/
	private static final Logger log = LoggerFactory.getLogger(TeaserModelImpl.class);
		
	@ValueMapValue @Optional
	private String imagePath;
	
	@ValueMapValue @Optional
	private String imageAltText;
	
	@ValueMapValue @Optional
	private String title;
	
	@ValueMapValue @Optional
	private String description;
	
	@ValueMapValue @Optional
	private String ctaText;
	
	@ValueMapValue @Optional
	private String ctaOpenInNewWindow;
	
	@ValueMapValue @Optional
	private String link;
	
	private Image image;
	
	@PostConstruct
	public void init() {
		
		image = new Image();
		image.setSrcPath(imagePath);
		image.setAltText(imageAltText);
		
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public Image getImage() {
		return image;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public String getCtaText() {
		return ctaText;
	}
	
	@Override
	public String getCtaOpenInNewWindow() {
		return ctaOpenInNewWindow;
	}
	
	@Override
	public String getLink() {
		return LinkUtil.getFormattedURL(link);
	}
	
}
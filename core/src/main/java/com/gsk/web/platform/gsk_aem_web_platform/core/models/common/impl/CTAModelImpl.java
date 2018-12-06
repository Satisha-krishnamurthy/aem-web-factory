package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.export.json.ExporterConstants;
import com.google.gson.Gson;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.CTAModel;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.MenuItem;

/**
 * Sling Model Implementation of 
 *
 * @author Photon Infotech
 *
 */
@Model(
		adaptables = Resource.class,
		adapters = CTAModel.class,
		resourceType = "gskwebplatform/components/content/common/cta",
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, selector = ExporterConstants.SLING_MODEL_SELECTOR,
		extensions = ExporterConstants.SLING_MODEL_EXTENSION, options = {
				@ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
		        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
		})
public class CTAModelImpl implements CTAModel {
	
	//static final String RESOURCE_TYPE = "gskwebplatform/components/content/common/cta";
	
	/**Static Logger*/
	private static Logger log = LoggerFactory.getLogger(CTAModelImpl.class);
	
	/*@ValueMapValue @Optional*/
	
	@Inject @Optional
	@Default(values="{}")
	private String[] ctaItems;
	
	List<MenuItem> ctaList;
		
	@PostConstruct
	public void init() {
		log.info("Inside init of CTA Model");
		
		ctaList = new ArrayList<>();
		
		Gson gson = new Gson();
		for(String eachString : ctaItems) {
			MenuItem eachItem = gson.fromJson(eachString, MenuItem.class);
			ctaList.add(eachItem);
		}
		
	}

	@Override
	public List<MenuItem> getCtaList() {
		return ctaList;
	}

	/*@Override
	public String getExportedType() {
		return RESOURCE_TYPE;
	}*/

}

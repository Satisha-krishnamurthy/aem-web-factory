package com.gsk.web.platform.gsk_aem_web_platform.core.models.common.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.wcm.api.Page;
import com.google.gson.Gson;
import com.gsk.web.platform.gsk_aem_web_platform.core.models.common.PageListingModel;
import com.gsk.web.platform.gsk_aem_web_platform.core.objects.PageObject;
import com.gsk.web.platform.gsk_aem_web_platform.core.utils.LinkUtil;

/**
 * Sling Model Implementation of Page Listing Model
 *
 * @author Photon Infotech
 *
 */
@Model(
		adaptables = { SlingHttpServletRequest.class },
		adapters = PageListingModel.class,
        resourceType = "gsk-web-platform/components/content/sling-model",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value="false")
})
public class PageListingModelImpl implements PageListingModel {
	
	Logger log = LoggerFactory.getLogger(PageListingModelImpl.class);
	
	@SlingObject @Optional
	private ResourceResolver resourceResolver;

	@Inject @Optional
	private String heading;

	@Inject @Optional
	private String itemsCommonCtaLabel;
	
	@Inject @Optional
	@Default(values="fixed")
	private String listingType;
	
	@Inject @Optional
	@Default(values= "{}")
	private String[] fixedPages;
	
	@Inject @Optional
	private String parentPagePath;
	
	@Inject @Optional
	@Default(values = "hierarchy")
	private String orderBy;
	
	@Inject @Optional
	@Default(values = "false")
	private String limitResult;
	
	@Inject @Optional
	@Default(intValues = 9)
	private int maxResultLimit;
	
	@Inject @Optional
	private String loadMoreText;
	
	@Inject @Optional
	private String loadMoreLink;
	
	private List<PageObject> pages;
	
	@PostConstruct
	protected void init() {
		
		try {
		
			if(StringUtils.isNotEmpty(listingType)) {
				if(listingType.equalsIgnoreCase("fixed")) {
					pages = new LinkedList<>();
					Gson gson = new Gson();
					for(String itemString : fixedPages) {
						PageObject pageObject = gson.fromJson(itemString, PageObject.class);
						Resource pageResource = resourceResolver.getResource(pageObject.getPagePath());
						if((pageResource != null) && (pageResource instanceof Resource)) {
							Page page = pageResource.adaptTo(Page.class);
							if(page != null) {
								ValueMap pageProperties = page.getProperties();
								pageObject.setTitle(pageProperties.get("jcr:title",pageProperties.get("title",String.class)));
								pageObject.setDescription(pageProperties.get("jcr:description",pageProperties.get("description",String.class)));
								pageObject.setSummary(pageProperties.get("summary",""));
								pageObject.setThumbnailImagePath(pageProperties.get("thumbnailImagePath",pageProperties.get("imagePath",String.class)));
								pageObject.setThumbnailImageAltText(pageProperties.get("thumbnailImageAltText",pageProperties.get("imageAltText",String.class)));
								pages.add(pageObject);
							}
						}
					}
				} else if(listingType.equalsIgnoreCase("child-pages")) {
					pages = new ArrayList<>();
					Resource parentResource = resourceResolver.getResource(parentPagePath);
					if((parentResource != null) && (parentResource instanceof Resource)) {
						Page parentPage = parentResource.adaptTo(Page.class);
						if(parentPage != null) {
							Iterable<Resource> childResources = parentResource.getChildren();
							for(Resource childResource : childResources) {
								if(!childResource.getName().equalsIgnoreCase("jcr:content")) {
									Page childPage = childResource.adaptTo(Page.class);
									if(childPage != null) {
										ValueMap pageProperties = childPage.getProperties();
										PageObject pageObject = new PageObject();
										pageObject.setTitle(pageProperties.get("title",pageProperties.get("jcr:title",String.class)));
										pageObject.setDescription(pageProperties.get("summary",pageProperties.get("jcr:description",String.class)));
										pageObject.setImagePath(pageProperties.get("thumbnailImage",pageProperties.get("imagePath",String.class)));
										pageObject.setImagePath(pageProperties.get("thumbnailImageAltText",pageProperties.get("imageAltText",String.class)));
										pages.add(pageObject);
										sortPages();
									}
								}
							}
						}
					}
				}
			} 
		} catch(Exception e) {
			log.error("Exception in init method of PageListingModelImpl :: " + e.getMessage()); 
		}
	}

	private void sortPages() {
		if(StringUtils.isNotEmpty(orderBy)) {
			if(orderBy.equalsIgnoreCase("title")) {
				Comparator<? super PageObject> byName = (PageObject pageBean1, PageObject pageBean2) -> pageBean1.getTitle()
						.compareTo(pageBean1.getTitle());
				pages.sort(byName);
			} else if(orderBy.equalsIgnoreCase("date")) {
				pages.sort(new Comparator<PageObject>() {
					@Override
					public int compare(PageObject pageBean1, PageObject pageBean2) {
						return (int) (pageBean1.getPageModifiedTime().getTimeInMillis() - pageBean1.getPageModifiedTime().getTimeInMillis());
					}
				});
			}
		}
	}
	
	@Override
	public List<PageObject> getPages() {
		return pages;
	}

	@Override
	public String getHeading() {
		return heading;
	}
	
	@Override
	public String getLimitResult() {
		return limitResult;
	}

	@Override
	public int getMaxResultLimit() {
		return maxResultLimit;
	}
	
	@Override
	public String getLoadMoreText() {
		return loadMoreText;
	}
	
	@Override
	public String getLoadMoreLink() {
		return LinkUtil.getFormattedURL(loadMoreLink);
	}

	@Override
	public String getCtaLabel() {
		return itemsCommonCtaLabel;
	}
	
}
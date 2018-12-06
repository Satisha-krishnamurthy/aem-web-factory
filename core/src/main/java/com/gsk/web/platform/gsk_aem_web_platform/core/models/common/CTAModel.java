package com.gsk.web.platform.gsk_aem_web_platform.core.models.common;

import java.util.List;

import org.osgi.annotation.versioning.ConsumerType;

import com.gsk.web.platform.gsk_aem_web_platform.core.objects.MenuItem;

@ConsumerType
public interface CTAModel {
	
	public List<MenuItem> getCtaList();

}

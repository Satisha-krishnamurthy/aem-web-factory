package com.gsk.web.platform.gsk_aem_web_platform.core.utils;

import org.apache.sling.api.resource.Resource;

public final class JCRUtil {
	
	/** 
	 * Method is going to return jcr:content resource
	 * 
	 * @param Resource
	 * @return
	 */
	public static Resource getDynamicResource(Resource resource) {

		Resource parentResource = resource.getParent();

		if((parentResource != null) && (parentResource instanceof Resource)) {
			if(parentResource.getName().contains("jcr:content")) {
				resource = parentResource;
			} else {
				resource = getDynamicResource(parentResource);
			}
		}
		return resource;
	}
}
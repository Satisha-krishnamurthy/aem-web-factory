package com.gsk.web.platform.gsk_aem_web_platform.core.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gsk.web.platform.gsk_aem_web_platform.core.objects.Asset;

public class AssetUtils {
	private static final String JPG = "jpg";
	private static final String JPEG = "jpeg";
	private static final Logger LOGGER = LoggerFactory.getLogger(AssetUtils.class);
	private static final String ATTRIBUTE_NAME = "assetDetailBean";
	private static final String ORIENTATION_LANDSCAPE = "landscape";
	private static final String ORIENTATION_PORTRAIT = "portrait";
	private static final String HTML_FILE_EXTENSION = ".html";
	private static final String ERROR_PAGE_BASE_FORMAT = "/content/hmgroup/groupsite/%s/error-pages/404.html";
	private static final String DEFAULT_LANGUAGE = "en";
	private static final String LANGUAGE_COOKIE_NAME = "hmgroup-lang";
	private String assetPath = "";
	private Asset asset = null;
	private ResourceResolver resourceResolver = null;
	private Boolean directedToErrorPage = false;

	/**
	 * This method is used to return the valid extension corresponding to the
	 * mime type.
	 * 
	 * @param mimeType
	 *            This is the mimeType String.
	 * @return The valid extension.
	 */
	public static String getExtensionFromMimeType(String mimeType) {

		String extension = StringUtils.EMPTY;
		if (StringUtils.isNotEmpty(mimeType)) {
			if (StringUtils.containsIgnoreCase(mimeType, JPEG) || StringUtils.containsIgnoreCase(mimeType, JPG)) {
				extension = JPG;
			} else if (StringUtils.containsIgnoreCase(mimeType, "gif")) {
				extension = "gif";
			} else if (StringUtils.containsIgnoreCase(mimeType, "png")) {
				extension = "png";
			}
		}
		return extension;
	}

	/**
	 * This method is used to fetch the image name.
	 * 
	 * @param fileReference
	 *            the image path
	 * @return the file name
	 */
	public static String fetchImageFileName(String fileReference) {
		String fileName = StringUtils.EMPTY;
		if (StringUtils.isNotEmpty(fileReference) && StringUtils.contains(fileReference, "/")
				&& StringUtils.contains(fileReference, ".")) {
			fileName = fileReference.substring(fileReference.lastIndexOf("/") + 1, fileReference.lastIndexOf("."));
		}
		return fileName;
	}

	/**
	 * Gets the file extension.
	 * 
	 * @param fileReference
	 *            the file reference
	 * @return the file extension
	 */
	public static String getFileExtension(String fileReference) {
		String extn = null;
		if (StringUtils.isNotBlank(fileReference) && StringUtils.contains(fileReference, ".")) {
			extn = fileReference.substring(fileReference.lastIndexOf(".") + 1, fileReference.length());
		} else {
			extn = StringUtils.EMPTY;
		}
		return extn;
	}

}

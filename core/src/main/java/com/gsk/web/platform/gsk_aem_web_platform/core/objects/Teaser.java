package com.gsk.web.platform.gsk_aem_web_platform.core.objects;

import com.gsk.web.platform.gsk_aem_web_platform.core.utils.LinkUtil;

/**
 * Teaser DTO
 *
 * @author Photon Infotech
 *
 */
public class Teaser {
	
	private String teaserPagePath;
	private String imagePath;
	private String imageAltText;
	private String title;
	private String description;
	private String ctaText;
	private String ctaLink;
	private String ctaOpenInNewWindow;
	private String testimonialName;
	private String viewImageText;
	private String viewPdfText;
	private String pdfLink;
	private String srcPath;
	
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getPdfLink() {
		return pdfLink;
	}
	public void setPdfLink(String pdfLink) {
		this.pdfLink = pdfLink;
	}
	public String getViewImageText() {
		return viewImageText;
	}
	public void setViewImageText(String viewImageText) {
		this.viewImageText = viewImageText;
	}
	public String getViewPdfText() {
		return viewPdfText;
	}
	public void setViewPdfText(String viewPdfText) {
		this.viewPdfText = viewPdfText;
	}
	public String getTestimonialName() {
		return testimonialName;
	}
	public void setTestimonialName(String testimonialName) {
		this.testimonialName = testimonialName;
	}
	public String getTeaserPagePath() {
		return teaserPagePath;
	}
	public void setTeaserPagePath(String teaserPagePath) {
		this.teaserPagePath = teaserPagePath;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getImageAltText() {
		return imageAltText;
	}
	public void setImageAltText(String imageAltText) {
		this.imageAltText = imageAltText;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCtaText() {
		return ctaText;
	}
	public void setCtaText(String ctaText) {
		this.ctaText = ctaText;
	}
	public String getCtaLink() {
		return LinkUtil.getFormattedURL(ctaLink);
	}
	public void setCtaLink(String ctaLink) {
		this.ctaLink = ctaLink;
	}
	public String getCtaOpenInNewWindow() {
		return ctaOpenInNewWindow;
	}
	public void setCtaOpenInNewWindow(String ctaOpenInNewWindow) {
		this.ctaOpenInNewWindow = ctaOpenInNewWindow;
	}
	
}

package com.gsk.web.platform.gsk_aem_web_platform.core.objects;

import java.util.List;

/**
 * TabItem DTO
 *
 * @author Photon Infotech
 *
 */

public class TabItem {

	private String tabTitle;
	private String bodyType;
	private List<ListItem> listItems;
	private String bodyText;
	private String assetType;
	private String image;
	private String imageAltText;
	private String imageCaption;
	private String video;
	private String videoType;
	private String alignmentType;
	private String parsysId;
	
	public String getTabTitle() {
		return tabTitle;
	}
	public void setTabTitle(String tabTitle) {
		this.tabTitle = tabTitle;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public List<ListItem> getListItems() {
		return listItems;
	}
	public void setListItems(List<ListItem> listItems) {
		this.listItems = listItems;
	}
	public String getBodyText() {
		return bodyText;
	}
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImageAltText() {
		return imageAltText;
	}
	public void setImageAltText(String imageAltText) {
		this.imageAltText = imageAltText;
	}
	public String getImageCaption() {
		return imageCaption;
	}
	public void setImageCaption(String imageCaption) {
		this.imageCaption = imageCaption;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public String getAlignmentType() {
		return alignmentType;
	}
	public void setAlignmentType(String alignmentType) {
		this.alignmentType = alignmentType;
	}
	public String getParsysId() {
		return parsysId;
	}
	public void setParsysId(String parsysId) {
		this.parsysId = parsysId;
	}
}

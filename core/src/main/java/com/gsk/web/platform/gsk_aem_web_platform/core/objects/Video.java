package com.gsk.web.platform.gsk_aem_web_platform.core.objects;

import java.util.Map;
import org.apache.sling.api.resource.Resource;

/**
 * Video DTO
 *
 * @author TechChefz (TCZ Consulting LLP)
 *
 */
public class Video extends Asset {
	
	private String isExternalVideo;
	private String videoType;
	private String autoPlay;
	private String loop;
	private Map<String,String> videoRenditions;
	private Map<String,String> thumbnailRenditions;
	private String thumbnailImagePath;
	private String thumbnailImageAltText;
	private String bgVideoThumbnailMobile;
	private String posterImage;
	
	public Video() {
		
	}
	
	public Video(Resource resource) {
		if((resource != null) && (resource instanceof Resource)) {
			
		}
	}
	
	public String getPosterImage() {
		return posterImage;
	}
	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}
	public String getBgVideoThumbnailMobile() {
		return bgVideoThumbnailMobile;
	}

	public void setBgVideoThumbnailMobile(String bgVideoThumbnailMobile) {
		this.bgVideoThumbnailMobile = bgVideoThumbnailMobile;
	}
	
	public String getIsExternalVideo() {
		return isExternalVideo;
	}

	public void setIsExternalVideo(String isExternalVideo) {
		this.isExternalVideo = isExternalVideo;
	}

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	
	public String getAutoPlay() {
		return autoPlay;
	}

	public void setLoop(String loop) {
		this.loop = loop;
	}
	
	public String getLoop() {
		return loop;
	}

	public void setAutoPlay(String autoPlay) {
		this.autoPlay = autoPlay;
	}

	public Map<String, String> getVideoRenditions() {
		return videoRenditions;
	}

	public void setVideoRenditions(Map<String, String> videoRenditions) {
		this.videoRenditions = videoRenditions;
	}

	public Map<String, String> getThumbnailRenditions() {
		return thumbnailRenditions;
	}

	public void setThumbnailRenditions(Map<String, String> thumbnailRenditions) {
		this.thumbnailRenditions = thumbnailRenditions;
	}

	public String getThumbnailImagePath() {
		return thumbnailImagePath;
	}

	public void setThumbnailImagePath(String thumbnailImagePath) {
		this.thumbnailImagePath = thumbnailImagePath;
	}
	
	public String getThumbnailImageAltText() {
		return thumbnailImageAltText;
	}

	public void setThumbnailImageAltText(String thumbnailImageAltText) {
		this.thumbnailImageAltText = thumbnailImageAltText;
	}

}

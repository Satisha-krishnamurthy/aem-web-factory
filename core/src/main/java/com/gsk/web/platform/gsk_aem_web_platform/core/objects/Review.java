package com.gsk.web.platform.gsk_aem_web_platform.core.objects;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Review DTO
 *
 * @author Photon Infotech
 *
 */

public class Review {
	
	private String reviewId;
	private String reviewCategory;
	private double reviewRating;
	private List<Review> reviewList;
	private Integer resultLimit;
	private double reviewRatingPercentage;
	private String reviewText;
	private String reviewDescription;
	private Map<String,String> extraInformation;
	private Date reviewDate;
	private String reviewDateText;
	private String entityId;
	private String reviewCriteria;
	private String reviewCriteriaLabel;
	private double averageRating;
	private double averageRatingPercentage;
	private Map<String,Review> reviewCriterias;
	private String dealerUrl;


	public String getDealerUrl() {
		return dealerUrl;
	}
	public void setDealerUrl(String dealerUrl) {
		this.dealerUrl = dealerUrl;
	}
	public Integer getResultLimit() {
		return resultLimit;
	}
	public void setResultLimit(Integer resultLimit) {
		this.resultLimit = resultLimit;
	}
	public List<Review> getReviewList() {
		return reviewList;
	}
	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewCategory() {
		return reviewCategory;
	}
	public void setReviewCategory(String reviewCategory) {
		this.reviewCategory = reviewCategory;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	public String getReviewDescription() {
		return reviewDescription;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public Map<String, String> getExtraInformation() {
		return extraInformation;
	}
	public void setExtraInformation(Map<String, String> extraInformation) {
		this.extraInformation = extraInformation;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewDateText() {
		return reviewDateText;
	}
	public void setReviewDateText(String reviewDateText) {
		this.reviewDateText = reviewDateText;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getReviewCriteria() {
		return reviewCriteria;
	}
	public void setReviewCriteria(String reviewCriteria) {
		this.reviewCriteria = reviewCriteria;
	}
	public String getReviewCriteriaLabel() {
		return reviewCriteriaLabel;
	}
	public void setReviewCriteriaLabel(String reviewCriteriaLabel) {
		this.reviewCriteriaLabel = reviewCriteriaLabel;
	}
	public double getReviewRating() {
		return reviewRating;
	}
	public void setReviewRating(double reviewRating) {
		this.reviewRating = reviewRating;
	}
	public double getReviewRatingPercentage() {
		return reviewRatingPercentage;
	}
	public void setReviewRatingPercentage(double reviewRatingPercentage) {
		this.reviewRatingPercentage = reviewRatingPercentage;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	public double getAverageRatingPercentage() {
		return averageRatingPercentage;
	}
	public void setAverageRatingPercentage(double averageRatingPercentage) {
		this.averageRatingPercentage = averageRatingPercentage;
	}
	public Map<String, Review> getReviewCriterias() {
		return reviewCriterias;
	}
	public void setReviewCriterias(Map<String, Review> reviewCriterias) {
		this.reviewCriterias = reviewCriterias;
	}

}
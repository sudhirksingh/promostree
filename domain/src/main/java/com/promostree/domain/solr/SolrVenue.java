package com.promostree.domain.solr;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.geo.GeoLocation;

public class SolrVenue {

	@Field("id")
	private String id;
	@Field
	private String entity_id;
	@Field
	private GeoLocation geolocation;
	@Field
	private String fs_id;
	@Field
	private String name;
	@Field
	private String description;
	@Field
	private String created_dt;
	@Field
	private String updated_dt;
	@Field
	private String created_by;
	@Field
	private String updated_by;
	@Field
	private String active;
	@Field
	private String img_url;
	@Field
	private String verified;
	@Field
	private String search_field;
	

	@Field
	private String address_id;
	@Field
	private String country;
	@Field
	private String state;
	@Field
	private String city;
	@Field
	private String region;
	@Field
	private String zip;
	@Field
	private String location_id;

	@Field
	private String cat_id;
	@Field
	private String cat_name;
	@Field
	private String sub_cat_name;

	@Field
	private String offer_id;
	@Field
	private String offer;
	@Field
	private String offer_desc;
	@Field
	private String start_dt;
	@Field
	private String end_dt;
	@Field
	private String offer_created_dt;
	@Field
	private String offer_updated_dt;
	@Field
	private String offer_created_by;
	@Field
	private String offer_updated_by;
	@Field
	private String offer_active;

	@Field
	private String shout_id;
	@Field
	private String shout;
	@Field
	private String shout_created_dt;
	@Field
	private String shout_updated_dt;
	@Field
	private String shout_created_by;
	@Field
	private String shout_updated_by;
	@Field
	private String shout_active;

	@Field
	private String business_group_id;
	@Field
	private String business_group;

	@Field
	private String merchant_id;
	@Field
	private String merchant_name;

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getOffer_active() {
		return offer_active;
	}

	public void setOffer_active(String offer_active) {
		this.offer_active = offer_active;
	}

	public String getShout_active() {
		return shout_active;
	}

	public void setShout_active(String shout_active) {
		this.shout_active = shout_active;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntity_id() {
		return entity_id;
	}

	public void setEntity_id(String entity_id) {
		this.entity_id = entity_id;
	}

	public String getFs_id() {
		return fs_id;
	}

	public void setFs_id(String fs_id) {
		this.fs_id = fs_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreated_dt() {
		return created_dt;
	}

	public void setCreated_dt(String created_dt) {
		this.created_dt = created_dt;
	}

	public String getUpdated_dt() {
		return updated_dt;
	}

	public void setUpdated_dt(String updated_dt) {
		this.updated_dt = updated_dt;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getSub_cat_name() {
		return sub_cat_name;
	}

	public void setSub_cat_name(String sub_cat_name) {
		this.sub_cat_name = sub_cat_name;
	}

	public String getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(String offer_id) {
		this.offer_id = offer_id;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getOffer_desc() {
		return offer_desc;
	}

	public void setOffer_desc(String offer_desc) {
		this.offer_desc = offer_desc;
	}

	public String getStart_dt() {
		return start_dt;
	}

	public void setStart_dt(String start_dt) {
		this.start_dt = start_dt;
	}

	public String getEnd_dt() {
		return end_dt;
	}

	public void setEnd_dt(String end_dt) {
		this.end_dt = end_dt;
	}

	public String getOffer_created_dt() {
		return offer_created_dt;
	}

	public void setOffer_created_dt(String offer_created_dt) {
		this.offer_created_dt = offer_created_dt;
	}

	public String getOffer_updated_dt() {
		return offer_updated_dt;
	}

	public void setOffer_updated_dt(String offer_updated_dt) {
		this.offer_updated_dt = offer_updated_dt;
	}

	public String getOffer_created_by() {
		return offer_created_by;
	}

	public void setOffer_created_by(String offer_created_by) {
		this.offer_created_by = offer_created_by;
	}

	public String getOffer_updated_by() {
		return offer_updated_by;
	}

	public void setOffer_updated_by(String offer_updated_by) {
		this.offer_updated_by = offer_updated_by;
	}

	public String getShout_id() {
		return shout_id;
	}

	public void setShout_id(String shout_id) {
		this.shout_id = shout_id;
	}

	public String getShout() {
		return shout;
	}

	public void setShout(String shout) {
		this.shout = shout;
	}

	public String getShout_created_dt() {
		return shout_created_dt;
	}

	public void setShout_created_dt(String shout_created_dt) {
		this.shout_created_dt = shout_created_dt;
	}

	public String getShout_updated_dt() {
		return shout_updated_dt;
	}

	public void setShout_updated_dt(String shout_updated_dt) {
		this.shout_updated_dt = shout_updated_dt;
	}

	public String getShout_created_by() {
		return shout_created_by;
	}

	public void setShout_created_by(String shout_created_by) {
		this.shout_created_by = shout_created_by;
	}

	public String getShout_updated_by() {
		return shout_updated_by;
	}

	public void setShout_updated_by(String shout_updated_by) {
		this.shout_updated_by = shout_updated_by;
	}

	public String getBusiness_group_id() {
		return business_group_id;
	}

	public void setBusiness_group_id(String business_group_id) {
		this.business_group_id = business_group_id;
	}

	public String getBusiness_group() {
		return business_group;
	}

	public void setBusiness_group(String business_group) {
		this.business_group = business_group;
	}

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public GeoLocation getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(GeoLocation geolocation) {
		this.geolocation = geolocation;
	}

	public String getSearch_field() {
		return search_field;
	}

	public void setSearch_field(String search_field) {
		this.search_field = search_field;
	}
 
}

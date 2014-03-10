package solr;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

public class Venue {

	@Field("id")
	private String id;
	@Field
	private String fs_id;
	@Field
	private String name;
	@Field
	private String description;

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
	private String lat;
	@Field
	private String lng;

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
	private String shout_id;
	@Field
	private String shout;

	@Field
	private String business_group_id;
	@Field
	private String business_group;
	
	@Field
	private String merchant_id;
	@Field
	private String merchant_name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
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

	

}

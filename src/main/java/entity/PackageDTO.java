package entity;

import java.awt.Image;
import java.util.Arrays;

//CREATE TABLE TRAVEL_PACKAGE 
//(
//  ID NUMBER(10) 
//, IMAGEPATH VARCHAR2(255) 
//, TITLE VARCHAR2(255) 
//, travelloc VARCHAR2(255) 
//, traveldays NUMBER(10) 
//, price NUMBER(20) 
//, detailtext VARCHAR2(255) 
//);
//

public class PackageDTO {
	private int id;
	private byte[] image;
	private String title;
	private String travelLoc;
	private String travelDays; 
	private int price;
	private String detailText;
	public int getId() {
		return id;
	}
	public String getTravelDays() {
		return travelDays;
	}
	public void setTravelDays(String travelDays) {
		this.travelDays = travelDays;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTravelLoc() {
		return travelLoc;
	}
	public void setTravelLoc(String travelLoc) {
		this.travelLoc = travelLoc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetailText() {
		return detailText;
	}
	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}
	@Override
	public String toString() {
		return "PackageDTO [id=" + id + ", image=" + image + ", title=" + title + ", travelLoc="
				+ travelLoc + ", travelDays=" + travelDays + ", price=" + price + ", detailText=" + detailText + "]";
	}
}

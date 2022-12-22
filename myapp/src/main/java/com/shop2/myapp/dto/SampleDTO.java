package com.shop2.myapp.dto;

//@Data
public class SampleDTO {
	private String id;
	private String pw;
	private int point;
	
	
	public SampleDTO() {}
	
	public SampleDTO(String id, String pw, int point) {
		this.id = id;
		this.pw = pw;
		this.point = point;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	
	@Override
	public String toString() {
		return "SampleDTO [id=" + id + ", pw=" + pw + ", point=" + point + "]";
	}
}

package com.shop2.myapp.dto;

public class ProductsDTO {
    private String pname;
    private String pcomment;
    private String img;
    private long price;
    private String designer;
    private String regdate;
    
    
    public ProductsDTO() {}
	public ProductsDTO(String pname, String pcomment, String img, long price, String designer, String regdate) {
		super();
		this.pname = pname;
		this.pcomment = pcomment;
		this.img = img;
		this.price = price;
		this.designer = designer;
		this.regdate = regdate;
	}
	
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcomment() {
		return pcomment;
	}
	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}

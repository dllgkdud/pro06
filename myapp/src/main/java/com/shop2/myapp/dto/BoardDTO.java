package com.shop2.myapp.dto;

public class BoardDTO {
	private int vno;
    private String vtitle;
    private String vcontent;
    private String id;
    private String regdate;
    private int hits;
    private String moddate;
    
    
    public BoardDTO() {}
    
	public BoardDTO(int vno, String vtitle, String vcontent, String id, String regdate, int hits, String moddate) {
		super();
		this.vno = vno;
		this.vtitle = vtitle;
		this.vcontent = vcontent;
		this.id = id;
		this.regdate = regdate;
		this.hits = hits;
		this.moddate = moddate;
	}
	
	
	public int getVno() {
		return vno;
	}
	public void setVno(int vno) {
		this.vno = vno;
	}
	public String getVtitle() {
		return vtitle;
	}
	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}
	public String getVcontent() {
		return vcontent;
	}
	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getModdate() {
		return moddate;
	}
	public void setModdate(String moddate) {
		this.moddate = moddate;
	}
}

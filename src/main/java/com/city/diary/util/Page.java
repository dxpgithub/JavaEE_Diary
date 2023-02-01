package com.city.diary.util;

import java.util.List;

/*
 * 分页工具类
 */
public class Page<T> {
	private int pagenum;//当前页，(前端传递，默认为1)
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(long totalcount) {
		this.totalcount = totalcount;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getPrepage() {
		return prepage;
	}
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public int getStartnavpage() {
		return startnavpage;
	}
	public void setStartnavpage(int startnavpage) {
		this.startnavpage = startnavpage;
	}
	public int getEndnavpage() {
		return endnavpage;
	}
	public void setEndnavpage(int endnavpage) {
		this.endnavpage = endnavpage;
	}
	public List<T> getDatalist() {
		return datalist;
	}
	public void setDatalist(List<T> datalist) {
		this.datalist = datalist;
	}
	private int pagesize;//显示数量
	private long totalcount;//总记录
	private int totalpage;//总页数(总记录/每页显示)
	private int prepage;//上一页
	private int nextpage;//下一页
	
	private int startnavpage;//导航开始页
	private int endnavpage;//导航结束页
	private List<T>datalist;//当前页数据集合
	
	
	
	
	public Page(int pagenum,int pagesize,long totalcount) {
		this.pagenum=pagenum;
		this.pagesize=pagesize;
		this.totalcount=totalcount;
		
		this.totalpage=(int)Math.ceil(totalcount/(pagesize*1.0));
		this.prepage=pagenum-1<1?1:pagenum-1;
		this.nextpage=pagenum+1>totalpage?totalpage:pagenum+1;
		
		this.startnavpage=pagenum-5;
		this.endnavpage=pagenum+4;
		if(this.startnavpage<1) {
			this.startnavpage=1;
			this.endnavpage=this.startnavpage+9>totalpage?totalpage:this.startnavpage+9;
			
		}
		if(this.endnavpage>totalpage) {
			this.endnavpage=totalpage;
			this.startnavpage=this.endnavpage-9<1?1:this.endnavpage-9;
		}
	}
}

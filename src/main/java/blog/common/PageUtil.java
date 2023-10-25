package blog.common;

import blog.entity.PageInfo;

public class PageUtil<T> {
	public static <T> PageInfo<T> getPageInfo(int pageSize,int pageIndex,int rowCount) {
		PageInfo<T> p = new PageInfo<T>();
		p.setPageSize(pageSize==0?10:pageSize);
		p.setPageIndex(pageIndex<1?1:pageIndex);
		p.setRowCount(rowCount);
		p.setBeginRow(p.getPageSize()*(p.getPageIndex()-1));
		p.setPageCount((p.getRowCount()+p.getPageSize()-1)/p.getPageSize());
		p.setHasPre(p.getPageIndex()>1);
		p.setHasNext(p.getPageIndex()<p.getPageCount());
		return p;
	}
}

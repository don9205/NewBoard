package kr.green.springtest.pagenation;


/* 페이지 조건 처리 클래스 */
public class Criteria {
	private int perPagenum; // 한 페이지 당 보여지는 게시글 수
	private int page; // 현재 페이지

	public Criteria() {
    page = 1; 
    perPagenum = 10;
  }
	
	public int getPerPagenum() {
		return perPagenum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0)
			this.page = 1;
		else
			this.page = page;
	}

	public int getStartPage() {
		return (page - 1) * perPagenum;
	}

	@Override
	public String toString() {
		return "Criteria [perPagenum=" + perPagenum + ", page=" + page + "]";
	}

}
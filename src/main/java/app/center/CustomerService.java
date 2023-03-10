package app.center;

import java.util.List;

import app.AppService;
import app.AppView;
import app.SubApp;
import entity.BoardVO;

public class CustomerService extends SubApp {
	private BoardDao dao = new BoardDao();
	private BoardList boardList = new BoardList(this);
	private BoardInsert boardInsert = new BoardInsert(this);
	private BoardUpdate boardUpdate = new BoardUpdate(this);
	
	{ index = -2; }
	
	public void openUpdate(BoardVO vo) {
		boardUpdate.setData(vo);
		AppService.instance().openView(boardUpdate);
	}
	
	public void openInsert() {
		boardInsert.initRootPanel();
		AppService.instance().openView(boardInsert);
	}
	
	public void openList(List<BoardVO> voList) {
		AppService.instance().closeView(boardInsert, boardUpdate);
		boardList.createTable(voList);
		AppService.instance().openView(boardList);
	}

	public void openList() {
		openList(null);
	}
	
	public BoardDao dao() {
		return dao;
	}
	
	@Override
	public AppView requestView() {
		openList(null);
		return null;
	}
	
	public String getTitle() {
		return "고객센터";
	}
}
package master.member;

import dbcommon.DBCommon;
import javafx.scene.Parent;

public class MasterMemberModController {
	int rs;
	static Parent root1;
	MasterMemModCtlService mmmcs = new MasterMemModCtlService();
	
	public void modify() {      //수정하기
		rs = mmmcs.modify(mmmcs.getmodify());
		if(rs == 1) DBCommon.getAlert("수정 성공");
		else DBCommon.getAlert("수정 실패");
	}
	
	public void memberBack() { // 뒤로 
		DBCommon.closeStage(root1);
	}

	public void setRoot(Parent root1) {
		// TODO Auto-generated method stub
		this.root1 = root1;
	}
}

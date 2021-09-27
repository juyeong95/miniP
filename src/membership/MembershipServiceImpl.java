package membership;

import dbcommon.DBCommon;
import dbservice.DBService;
import dbservice.DBserviceImpl;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MembershipServiceImpl implements MembershipService{
	Parent root;
	DBService db;
	public MembershipServiceImpl() {
		db = new DBserviceImpl();
	}
	@Override
	public void setRoot(Parent root) {
		this.root=root;
	}

	@Override
	public void confirm() { //확인 버튼
		TextField id = (TextField)root.lookup("#fxId");		
		TextField name = (TextField)root.lookup("#fxName");
		PasswordField pwd = (PasswordField)root.lookup("#fxPwd");
		PasswordField pwdc = (PasswordField)root.lookup("#fxPwdC");
		TextField pn = (TextField)root.lookup("#fxPN");
		//전달받은 root값을 통해 각각의 값들을 받아온다.
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id.getText());
		dto.setName(name.getText());
		dto.setPwd(pwd.getText());
		dto.setpNumber(pn.getText());
		//dto를 선언하고 받아온 값을 dto에 전달한다
		
		if( pwd.getText().equals(pwdc.getText()) ) { //pwd에 입력한 값 (패스워드 입력)과 pwdc에 입력한 값(패스워드 확인)이 일치했을때 실행
			int result = db.insertMember(dto);
			//DBservice에 있는 insertmember에 dto값을 전달해서 result값을 성공 시 1 실패 시 0을 받아온다.
			if(result == 1) { //성공 시 1을 받아온다
				DBCommon.getAlert("회원가입이 완료되었습니다.");
				DBCommon.closeStage(root);
			}else { //기본키인 id값이 겹치면 실패가 된다.
				DBCommon.getAlert("동일한 아이디가 존재합니다..");
			}
		}else { //패스워드입력값과 확인값이 다를 때 실행
			DBCommon.getAlert("비밀번호를 다시 확인해주세요.");
		}
		
		
	}

	@Override
	public void cancel() {
		DBCommon.closeStage(root);
	}

}

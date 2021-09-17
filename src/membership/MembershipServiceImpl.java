package membership;

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
	public void confirm() {
		TextField id = (TextField)root.lookup("#fxId");		
		TextField name = (TextField)root.lookup("#fxName");
		PasswordField pwd = (PasswordField)root.lookup("#fxPwd");
		PasswordField pwdc = (PasswordField)root.lookup("#fxPwdC");
		TextField pn = (TextField)root.lookup("#fxPN");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id.getText());
		dto.setName(name.getText());
		dto.setPwd(pwd.getText());
		dto.setpNumber(pn.getText());
		
		if( pwd.getText().equals(pwdc.getText()) ) {
			int result = db.insertMember(dto);
			if(result == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("회원가입이 완료되었습니다.");
				alert.show();
				Stage s = (Stage)root.getScene().getWindow();
				s.close();
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("동일한 아이디가 존재합니다.");
				alert.show();
			}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("비밀번호를 다시 확인해주세요.");
			alert.show();
		}
		
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

}

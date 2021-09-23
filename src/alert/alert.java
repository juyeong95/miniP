package alert;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class alert {
	public static void getAlert(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
}

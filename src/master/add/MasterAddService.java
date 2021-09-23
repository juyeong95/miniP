package master.add;

import java.util.ArrayList;

import javafx.scene.Parent;

public interface MasterAddService {

	public void setRoot(Parent root);
	public void BookAdd();
	public ArrayList<MasterBookDTO> BookList();
}

package master.add;

import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.control.TextField;

public interface MasterAddService {

	public void setRoot(Parent root);
	public int BookAdd(MasterBookDTO dto);
	public MasterBookDTO BookAdd1();
	
	
	
	
}

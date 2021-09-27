package master.del;

import javafx.scene.Parent;
import master.add.MasterBookDTO;

public interface MasterDelService {

	public void setRoot(Parent root);
	public MasterBookDTO getDelList(String bookNum);
	public void masterDel();
	public void identify();
}

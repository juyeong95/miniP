package dbservice;

import membership.MemberDTO;
import memdto.MemDTO;

public interface DBService {
	public int insertMember(MemberDTO dto);
	public MemDTO loginCheck(String id);
}

import java.util.ArrayList;

//CList (CoordList) Class
public class CList {
	ArrayList<C> list;

	public CList(C... coords){
		list = new ArrayList<>();

		for (C c : coords){
			list.add(c);
		}
	}
}

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class Stat_history extends StaticFile{
	
	ArrayList <History> history = new ArrayList<History>();//������ ��� ������ ������� ������� 

	String str() {
		history.sort(Comparator.comparing(History::getdata_buy).reversed());
		String str="";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_HH-mm") ;
		for(History i : history){
			str = str + dateFormat.format(i.data_buy)+" - "+i.name_pr+" - "+i.price + System.getProperty("line.separator");
		}
		return str;
	}
	
	String nameFile(){
		return "history_";
	}
	String headline(){
		return "���� � ����� ������� - �������� ������ - ����";
	}
}

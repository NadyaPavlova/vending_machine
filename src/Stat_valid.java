import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Stat_valid extends StaticFile{
	
	ArrayList <Expir_date> stValid = new ArrayList<>();
	
	Stat_valid(Avtomate avt){
		for(Tray i : avt.mTray){
			for(Date d : i.exp_date) { 
				Expir_date n = new Expir_date(i.name_prod,d);
				stValid.add(n);
			}
		}
		stValid.sort(Comparator.comparing(Expir_date::getdate));
	}
	
	String str() {
		String str= "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_HH-mm") ;
		for(Expir_date i : stValid){
			str=str+i.name_pr+" - "+dateFormat.format(i.data_val)+System.getProperty("line.separator");
		}
		return str;
	}
	
	String headline(){
		return "ÍÀÇÂÀÍÈÅ ÒÎÂÀĞÀ - ÄÀÒÀ ÈÑÒÅ×ÅÍÈß ÑĞÎÊÀ ÃÎÄÍÎÑÒÈ";
	}
	
	String nameFile(){
		return "stat_valid_";
	}
}


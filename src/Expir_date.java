import java.util.Date;

public class Expir_date {
	
	String name_pr;
	Date data_val;	
	
	Expir_date(String n, Date data_v){
		name_pr = n;
		data_val = data_v;
	} 
	Date getdate(){
		return data_val;
	}
}

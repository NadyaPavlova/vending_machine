import java.util.Date;

public class StaticValid {
	String name_pr;
	Date data_val;	
	
	StaticValid(String n, Date data_v){
		name_pr = n;
		data_val = data_v;
	} 
	Date getdate(){
		return data_val;
	}
}

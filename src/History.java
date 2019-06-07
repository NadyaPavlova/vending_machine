import java.util.Date;

public class History  {
	Date data_buy;
	String name_pr;
	int price;
		
	History(Date d, String n, int p){
		data_buy = d;
		name_pr = n;
		price = p;
	}
	
	String getname() {
		return name_pr;
	}
	
	Date getdata_buy() {
		return data_buy;
	}
}

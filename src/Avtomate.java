import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Avtomate {
		Tray a1 = new Tray("A1","Coca-Cola");
		Tray a2 = new Tray("A2","Sprite");
		Tray a3 = new Tray("A3","Fanta");
		Tray b1 = new Tray("B1","Lays");
		Tray b2 = new Tray("B2","Cheetos");
		Tray b3 = new Tray("B3","Oreo");
		Tray c1 = new Tray("C1","Kit-Kat");
		Tray c2 = new Tray("C2","Twix");
		Tray c3 = new Tray("C3","Snikers");
		ArrayList <Tray> mTray = new ArrayList<Tray>(9); //Массив для хранения ячеек
		Stat_history s = new Stat_history();

		
		Avtomate(){
		mTray.add(a1);
		mTray.add(a2);
		mTray.add(a3);
		mTray.add(b1);
		mTray.add(b2);
		mTray.add(b3);
		mTray.add(c1);
		mTray.add(c2);
		mTray.add(c3);
		}
		
	//Вывод всех товаров	
	void print(){
		System.out.println("НАЗВАНИЕ ЯЧЕЙКИ - НАЗВАНИЕ ТОВАРА - ЦЕНА - ОСТАВШЕЕСЯ КОЛИЧЕСТВО");
		 for(Tray t : mTray){ 
		System.out.println(t.name+" - "+t.name_prod+" - "+ t.kol+" - "+t.price);
		}
	}
	
	//покупка товара
	void buy(String n_tray, int n_price, String n_date, String n_time){
		 SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yy HH:mm");
	     Date dateBuy;
	     String str= n_date+" "+n_time;
	     try {
	    	 dateBuy = ft.parse(str); 
	         System.out.println(dateBuy);
		     for(Tray i : mTray){ 
			    if(i.name.equals(n_tray)) {
			    	if(n_price>=i.price) {
			    		 if(dateBuy.before(i.exp_date.get(0))) {
			    			 i.exp_date.remove(0);
			    			 i.kol=i.kol-1;
			    			 History h = new History(dateBuy,i.name_prod,i.price);
			    			 s.history.add(h);
			    		 }
			    		 else {
			    			 System.out.println("Ошибка. Товар с истекшим сроком годности");
				    	 }				    		
			    	}
			    	else {
			    		 System.out.println("Ошибка. Товар стоит дороже");
			    	 }
		    	 }  	 
		 	}
	     }catch (ParseException e) { 
	         System.out.println("Нераспаршена с помощью " + ft); 
	      }
	}
	

	void write_stat_price(){
		Stat_price st_pr = new Stat_price (s);
		st_pr.stat();
		
	}
	
	void statValid(){
		Stat_valid st_v= new Stat_valid (this);
		st_v.stat();
	}	
	
}
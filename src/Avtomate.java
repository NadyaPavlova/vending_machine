import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		ArrayList <History> history = new ArrayList<History>();//Массив для записи истории покупок 
		
		
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
		System.out.println(a1.name+" - "+a1.name_prod+" - "+ a1.kol+" - "+a1.price);
		System.out.println(a2.name+" - "+a2.name_prod+" - "+ a2.kol+" - "+a2.price);
		System.out.println(a3.name+" - "+a3.name_prod+" - "+ a3.kol+" - "+a3.price);
		System.out.println(b1.name+" - "+b1.name_prod+" - "+ b1.kol+" - "+b1.price);
		System.out.println(b2.name+" - "+b2.name_prod+" - "+ b2.kol+" - "+b2.price);
		System.out.println(b3.name+" - "+b3.name_prod+" - "+ b3.kol+" - "+b3.price);
		System.out.println(c1.name+" - "+c1.name_prod+" - "+ c1.kol+" - "+c1.price);
		System.out.println(c2.name+" - "+c2.name_prod+" - "+ c2.kol+" - "+c2.price);
		System.out.println(c3.name+" - "+c3.name_prod+" - "+ c3.kol+" - "+c3.price);
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
			    			 history.add(h);
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
	
	//запись истории покупок в файл
	void write_history() {
		history.sort(Comparator.comparing(History::getdata_buy).reversed());
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_HH-mm") ;
		File file = new File("history_" + dateFormat.format(date) + ".log") ;
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));
			for(History i : history){
				out.write(dateFormat.format(i.data_buy)+" - "+i.name_pr+" - "+i.price + System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			System.out.println("Ошибка. Файл не открывается");
		}
		finally{
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
	
	//статистику покупок построчно, сгруппированную по товарам, 
	void write_stat_price(){
		history.sort(Comparator.comparing(History::getname).reversed());
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_HH-mm") ;
		File file = new File("stat_price_" + dateFormat.format(date) + ".log") ;
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));
			for(Tray t : mTray){
				int s_price=0;
				for(History i : history){
					if(t.name_prod.equals(i.name_pr)) {
						s_price=s_price+i.price;
					}
				}
				out.write(t.name_prod+" - "+s_price + System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			System.out.println("Ошибка. Файл не открывается");
		}
		finally{
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}

	//статистика оставшихся в автомате товаров
	void statValid(){
		ArrayList <StaticValid> stValid = new ArrayList<>();
		for(Tray i : mTray){
			for(Date d : i.exp_date) { 
				StaticValid n = new StaticValid(i.name_prod,d);
				stValid.add(n);
			}
		}
		stValid.sort(Comparator.comparing(StaticValid::getdate));
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_HH-mm") ;
		File file = new File("stat_valid_" + dateFormat.format(date) + ".log") ;
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));
			for(StaticValid i : stValid){
				out.write(i.name_pr+" - "+dateFormat.format(i.data_val)+System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			System.out.println("Ошибка. Файл не открывается");
		}
		finally{
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
}

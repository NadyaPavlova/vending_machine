import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class Tray {
	String name; //имя ячейки
	String name_prod; //имя продукта
	int kol; //количество
	int price; //цена 
	ArrayList<Date> exp_date = new ArrayList<Date>(); 
	
	Tray(String n, String n_p) {
		name = n;
		name_prod = n_p;
		final Random random = new Random();
		price = random.nextInt(99) + 1;
		kol = random.nextInt(5) + 5;
		random_date();
	}

	void random_date() {
		Date date_t = new Date();
		final Random random = new Random();
		Calendar instance = Calendar.getInstance();
		int t=0;
		for(int i=1; i<=kol; i++) {
			instance.setTime(date_t); //устанавливаем дату, с которой будет производить операции
			t = random.nextInt(6)+1;
			instance.add(Calendar.DAY_OF_MONTH, t);// прибавляем 3 дня к установленной дате
			exp_date.add(instance.getTime());
		}
		Collections.sort(exp_date);
	}
}

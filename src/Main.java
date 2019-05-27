import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Avtomate avt = new Avtomate();
		
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			System.out.println("Выберите операцию: \n"+
					"1. Вывести меню аппарата \n"+
					"2. Купить товар  \n"+
					"3. Записать файл c историей покупок  \n"+
					"4. Записать файл c историей прибыли от каждого типа товара \n"+
					"5. Записать файл c остатком товара, рассортированного по сроку годности \n"+
					"6. Выход"
					);
			int n = sc.nextInt();
			switch (n) {
				case 1:
					avt.print();
					break;
				case 2:
					System.out.println("Введите номер ячейки:");
					
					String n_tray = sc.next();
					
					System.out.println("Введите сумму:");

					int n_price = sc.nextInt();
					
					System.out.println("Введите дату:");

					String n_date = sc.next();
					
					System.out.println("Введите время покупки:");

					String n_time = sc.next();
					
					avt.buy(n_tray, n_price, n_date, n_time);
					break;
				case 3:
					avt.write_history();
					break;
				case 4:
					avt.write_stat_price();
					break;
				case 5:
					avt.statValid();
					break;
				case 6: 
					sc.close();
					System.exit(0);
				default:
					System.out.println("Ошибка. Неверный номер операции");
					break;

			}
			
		}
	}
}


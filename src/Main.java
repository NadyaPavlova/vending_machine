import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Avtomate avt = new Avtomate();
		
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			System.out.println("�������� ��������: \n"+
					"1. ������� ���� �������� \n"+
					"2. ������ �����  \n"+
					"3. �������� ���� c �������� �������  \n"+
					"4. �������� ���� c �������� ������� �� ������� ���� ������ \n"+
					"5. �������� ���� c �������� ������, ����������������� �� ����� �������� \n"+
					"6. �����"
					);
			int n = sc.nextInt();
			switch (n) {
				case 1:
					avt.print();
					break;
				case 2:
					System.out.println("������� ����� ������:");
					
					String n_tray = sc.next();
					
					System.out.println("������� �����:");

					int n_price = sc.nextInt();
					
					System.out.println("������� ����:");

					String n_date = sc.next();
					
					System.out.println("������� ����� �������:");

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
					System.out.println("������. �������� ����� ��������");
					break;

			}
			
		}
	}
}


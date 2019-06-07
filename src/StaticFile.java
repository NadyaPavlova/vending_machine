import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class StaticFile {

	void stat() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_HH-mm") ;
		File file = new File(nameFile() + dateFormat.format(date) + ".log") ;
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));
			out.write(headline()+ System.getProperty("line.separator")+str());
			
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
	
	
 String nameFile() {
		String s="";
		return s;
 }
 String headline() {
		String s="";
		return s;
 }
 
 String str() {
		String s="";
		return s;
}
}

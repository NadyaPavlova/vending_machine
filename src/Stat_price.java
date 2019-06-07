import java.util.HashMap;
import java.util.Map;


public class Stat_price extends StaticFile{
	Map<String, Integer> hashMap = new HashMap<String, Integer>();
	Stat_price(Stat_history b){
		for(History t : b.history){
			hashMap.put(t.name_pr, t.price);
		}
		for(String h : hashMap.keySet()){
			int s_price=0;
			for(History i : b.history){
				if(h.equals(i.name_pr)) {
					s_price=s_price+i.price;
				}
			}
			hashMap.put(h, s_price);
		}
	}
	
	String str() {
			
			String str="";
			for(Map.Entry entry : hashMap.entrySet()) {
				str= str+entry.getKey()+" - "+entry.getValue() + System.getProperty("line.separator");	
			}
			return str;
	}
		
	String headline(){
		return "Õ¿«¬¿Õ»≈ “Œ¬¿–¿ - Œ¡Ÿ¿ﬂ œ–»¡€À‹";
	}
	
	String nameFile(){
		return "history_price_";
	}	
}

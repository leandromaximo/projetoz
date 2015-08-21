package br.com.projetoz.util;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DataUtil {

	public static void main(String[] args) {
		
		System.out.println(somarDia(new Date(), 2));
	}

	public static long intervaloDias(Date dtIni,Date dtFim){
		return (dtFim.getTime() - dtIni.getTime()) / (1000*60*60*24);
	}

	public static Date somarDia(Date data,Integer qtdDias){
		if(data != null && qtdDias != null){
			Calendar cal = Calendar.getInstance();  
	        
	        cal.setTime(data);
	        cal.add(Calendar.DAY_OF_MONTH, qtdDias);
	        
			return cal.getTime();
		}
		return null;
	}
	
	public static String removeAcentos(String str) {
		  str = Normalizer.normalize(str, Normalizer.Form.NFD);
		  str = str.replaceAll("[^\\p{ASCII}]", "");
		  return str;
	}
	
	public static Date getDataSomarDiasUteis(Date dataInicial,int qtdDias){
		Date data = new Date();
		int qtdDiasUteisSoma = 0;
		
		Calendar cal = Calendar.getInstance();  
		cal.setTime(data);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		for (int i = 0; i < qtdDias; i++) {
			day++;
			if(day == 1 || day == 7){
				qtdDiasUteisSoma++;
			}
			if(day==7)day = 0;
		}
		data.setDate(dataInicial.getDate() + (qtdDias+qtdDiasUteisSoma));
		return data;
	}
	
	public static Date somarAno(Date data,int qtdAno){
		Calendar cal = Calendar.getInstance();  
        
        cal.setTime(data);
        cal.add(Calendar.YEAR, qtdAno);
        
		return cal.getTime();
	}
	
	public static Date subtrairAno(Date data,int qtdAno){
		Calendar cal = Calendar.getInstance();  
        
        cal.setTime(data);
        cal.add(Calendar.YEAR, qtdAno * -1);
        
		return cal.getTime();
	}
	
	public static int getAno(Date data){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return Integer.parseInt(sdf.format(data));
	}
	
	
}

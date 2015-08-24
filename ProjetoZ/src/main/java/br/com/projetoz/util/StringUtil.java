package br.com.projetoz.util;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class StringUtil {

	public static void main(String[] args) {
		System.out.println(getNomeUnicoCurtoArquivo("D:\\asdf\\qwer\\dfgh\\arquivo.jpg"));
	}
	
	public static String getNomeUnicoArquivoIndex(String nome,Integer index){
		String nomeUnico = getNomeUnicoArquivo(nome);
		int i = nomeUnico.lastIndexOf(".");
		return nomeUnico.substring(0,i)+index+nomeUnico.substring(i);
	}
	
	public static String getNomeUnicoCurtoArquivo(String nome){
		String nomeUnico = "";
		
		String nomeSplit[] = getNomeArquivo(nome).split("\\.");
		String dataSplit[] = new Date().toString().split(" ");
		
		
		for (int i = 0; i < nomeSplit.length-1; i++) {
			nomeUnico += nomeSplit[i];
		}
		
		return nomeUnico.substring(0,6)+dataSplit[2]+dataSplit[1]+dataSplit[5]
						+dataSplit[3].replace(":", "")+"."+getExtensao(nome);
	}
	
	public static String getNomeUnicoArquivo(String nome){
		String nomeUnico = "";
		
		String nomeSplit[] = getNomeArquivo(nome).split("\\.");
		String dataSplit[] = new Date().toString().split(" ");
		
		
		for (int i = 0; i < nomeSplit.length-1; i++) {
			nomeUnico += nomeSplit[i];
		}
		
		return nomeUnico+"_"+dataSplit[2]+dataSplit[1]+dataSplit[5]
						+dataSplit[3].replace(":", "")+"."+getExtensao(nome);
	}
	
	public static String getNomeArquivo(String nome){
		String nomeSplit[] = nome.split("\\\\");
		return nomeSplit[nomeSplit.length-1];
	}
	
	public static String getExtensao(String nome){
		String nomeSplit[] = nome.split("\\.");
		return nomeSplit[nomeSplit.length-1];
	}
	
	public static String removeAcentos(String str) {
		 
	  str = Normalizer.normalize(str, Normalizer.Form.NFD);
	  str = str.replaceAll("[^\\p{ASCII}]", "");
	  return str;
	 
	}
	
	public String maskMoeda(BigDecimal moeda){
		return NumberFormat.getCurrencyInstance(new Locale("pt","BR")).format(moeda);
    }
	
}

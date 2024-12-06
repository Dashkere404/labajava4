import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Main {
    public static void make_url(String ur){
        try {
            UrlMaker u = new UrlMaker(ur);//создание объекта формата URL
            URL tmp=u.getUrlMaker(); //получение его и проверка на сущестование
            System.out.println("Parsing url:");//парсинг (разбитие на части) ссылки
            System.out.println("The protocol is " + tmp.getProtocol() + "\nThe host is " + tmp.getHost() + "\nThe port is " + tmp.getPort() + "\nThe file is " + tmp.getFile() + "\nThe anchor is " + tmp.getRef());
            Data url =new Data (tmp);
            url.getData();//вывод информации
        }
        catch (MalformedURLException me){//если не существует ссылка
            System.err.println("Failed with error: " + me.getMessage());
        }
    }
    public static void main(String[] args) {
        try{
            System.out.println("THE FIRST RESULT:");
            make_url("https://mp8000239c7a5d9301b5.free.beeceptor.com/response1");//вывод первой ссылки
            System.out.println("\nTHE SECOND RESULT:");
            make_url("https://mp8000239c7a5d9301b5.free.beeceptor.com/response2");//вывод второй ссылки
            make_url("hello");//вывод несуществующей ссылки

        }
        catch (Exception e) {//если было поймано хоть какое исключение
            System.err.println("General Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
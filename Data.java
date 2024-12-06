import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Data {
    private URL url;
    public Data (){
        try {
            this.url = new URL("http://www.google.com");
        }
        catch(MalformedURLException me){
            System.err.println("Error: " + me.getMessage());
        }
    }
    public Data(URL url){
        this.url=url;
    }
    public void setUrl(URL url){
        this.url=url;
    }
    public void getData() {
        try {
            HttpURLConnection uc = (HttpURLConnection) this.url.openConnection();//открытие соединения с ресурсом
            uc.setRequestMethod("GET");//указываем, что хотим именно получить данные с сервера
            uc.setRequestProperty("Content-Type", "application/json");//обоозначаем, что обрабатываем именно json файл
            int statusCode = uc.getResponseCode();//получение кода ответа от сервера
            System.out.println("\nHeaders:");//вывод заголовков
            for (Map.Entry<String, List<String>> header : uc.getHeaderFields().entrySet()) {
                System.out.println(header.getKey() + ": " + String.join(", ", header.getValue()));
            }
            System.out.println("Response Code: " + statusCode + "\n\nInfo about clients:");//вывод кода ответа
            if (statusCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.replaceAll("[\"\\[\\]{},]", "");//ручной парсинг строк
                    line=line.trim();//удаление табубуляции
                    String[] parts = line.split(",");//парсинг по запятой
                    if (line.isEmpty()){//пустые строки пропускаем
                        continue;
                    }
                    else {
                        System.out.println(line);
                    }
                }
                reader.close();
            }
            else{
                System.err.println("Failed with status code: "+ statusCode);
            }
        } catch (IOException ie) {
            System.err.println(ie);
        }
    }
}

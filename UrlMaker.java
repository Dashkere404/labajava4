import java.net.MalformedURLException;
import java.net.URL;

public class UrlMaker {
    private String url;
    public UrlMaker(){
        this.url = "https://www.google.com";
    }
    public UrlMaker(String url){
        this.url=url;
    }
    public void setUrlMaker(String url){
        this.url=url;
    }
    public URL getUrlMaker() throws MalformedURLException{ //на случай если не существует ссылка
        return new URL(this.url);
    }

}

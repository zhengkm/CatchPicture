/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IndexCartoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import sun.net.www.protocol.http.HttpURLConnection;
/**
 *
 * @author zhengkaiming
 */
public class IndexedCartoonModel {
    private String pictureTag;
    private String pictureURL;
    
     public void doFlickrSearch(String searchTag) {
         pictureTag = searchTag;
         String response = "";
        try {
            // Create a URL for the desired page            
            URL url = new URL("http://www.thisisindexed.com/category/"+searchTag+"/");
            System.out.println(url);
            // Create an HttpURLConnection.  This is useful for setting headers.
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
             connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.11 Safari/536.11");
            System.out.println(connection);
             try ( // Read all the text returned by the server
                     BufferedReader in = new BufferedReader
                            (new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
                 System.out.println(in);
                 String str;
                 while ((str = in.readLine()) != null) {
                     // str is one line of text readLine() strips newline characters
                     response += str;
                     
                 }
                 System.out.println(response);
             }
        } catch (IOException e) {
            System.out.println("fuck");
            // Do something reasonable.  This is left for students to do.
        }
        
        int endfarm=0;
        int startfarm=0;
          int i=0;
        ArrayList<String> m = new ArrayList<String>();
        while(response.indexOf("href=\"http://thisisindexed.com/wp-content/uploads/",endfarm+2)!=-1){
        // find the picture URL to scrape
        startfarm = response.indexOf("href=\"http://thisisindexed.com/wp-content/uploads/",startfarm+1);
        
        // only start looking after the quote before http
        endfarm = response.indexOf("\"", startfarm+6);
        
        m.add("src=\""+response.substring(startfarm+6,endfarm+1));
        endfarm++;
        System.out.println(m);
        }
       //System.out.println(m);
        // only start looking after the quote before http
        //pictureURL = response.substring(startfarm,endfarm+1);
        int number = new Random().nextInt(m.size());
        pictureURL = m.get(number);
        //System.out.println(pictureURL);
        // +1 to include the quote
    }
   
    
     public String indexPictureSize(String picsize) {
        int finalDot = pictureURL.lastIndexOf(".");
        String sizeLetter = (picsize.equals("mobile")) ? "m" : "z";
        return (pictureURL.substring(0, finalDot)+pictureURL.substring(finalDot));
    }

    public String getPictureTag() {
        return (pictureTag);
    }
}

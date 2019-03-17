package cn.ict.onedbcore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class httpclientTest {

    public static String HttpPostWithJson(String url, String json) {
		String returnValue = "这是默认返回值，接口调用失败";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		try{
			//第一步：创建HttpClient对象
			httpClient = HttpClients.createDefault();
		 	
		 	//第二步：创建httpPost对象
	        HttpPost httpPost = new HttpPost(url);
	        
	        //第三步：给httpPost设置JSON格式的参数
	        StringEntity requestEntity = new StringEntity(json,"utf-8");
	        requestEntity.setContentEncoding("UTF-8");    	        
	        httpPost.setHeader("Content-type", "application/json");
	        httpPost.setEntity(requestEntity);
	       
	       //第四步：发送HttpPost请求，获取返回值
	        returnValue = httpClient.execute(httpPost,responseHandler); //调接口获取返回值时，必须用此方法
	        System.out.println(returnValue);
		}
		 catch(Exception e)
		{
			 e.printStackTrace();
		}
		
		finally {
	       try {
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
		 //第五步：处理返回值
	     return returnValue;
	}

    public static void inputStreamUpload(String url, String path, String filename) throws FileNotFoundException {
            //创建HttpClient对象
            CloseableHttpClient client = HttpClients.createDefault();
            //构建POST请求   请求地址请更换为自己的。
            //1)
            HttpPost httpPost = new HttpPost(url);
            InputStream inputStream = new FileInputStream(path);
            try {
                //文件路径请换成自己的
                //2)
            	File file = new File(path);
                InputStreamEntity reqEntity = new InputStreamEntity(
                        new FileInputStream(file), -1);
                reqEntity.setContentType("application/json");
                reqEntity.setChunked(true);
            	// HttpEntity httpEntity = EntityBuilder.create().
            	//		setStream(inputStream).
            	//		setContentType(ContentType.APPLICATION_JSON).setContentEncoding("UTF-8").build();
                httpPost.setEntity(reqEntity);
                //发送请求
                HttpResponse response = client.execute(httpPost);
                HttpEntity httpEntity = response.getEntity();
                if(httpEntity != null){
                    inputStream = httpEntity.getContent();
                    //转换为字节输入流
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, Consts.UTF_8));
                    String body = null;
                    while ((body = br.readLine()) != null) {
                        System.out.println(body);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {  
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 
    }
    
    public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {
    	String read_url = "http://10.17.18.46:8080/api/read/track/id/3437128736768";
    	String url = "http://10.17.18.46:8080/api/write/domain";
    	String json = "[{\r\n" + 
    			"	\"id\": 1103283444331446272,\r\n" + 
    			"	\"name\": \"中期检查南海\",\r\n" + 
    			"	\"desc\": \"\",\r\n" + 
    			"	\"parentId\": null,\r\n" + 
    			"	\"trs\": \"onegis:1001\",\r\n" + 
    			"	\"srs\": \"epsg:4326\",\r\n" + 
    			"	\"geoBox\": [9.5633739553, 112.8742978183, -20000.0, 9.5359255392, 112.9093809111, 4.0E7],\r\n" + 
    			"	\"etime\": null,\r\n" + 
    			"	\"stime\": null\r\n" + 
    			"}]";
    	String path = "D:\\jjq\\Example for OneGIS Data\\test.domain";
    	
    	// 读数据
    	HttpPostWithJson(read_url, "");
    	// 写数据库-测试为domain。 body为String
    	HttpPostWithJson(url, json);
    	// 写数据库-测试为domain。 body为InputStream
    	inputStreamUpload(url, path, "test.domain");
		
	}
}

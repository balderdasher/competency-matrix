package com.mrdios.competencymatrix.java.readingnotes.distributed_website_architecture.soa;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileWriter;

/**
 * 通过Apache HttpClient发送HTTP请求
 *
 * @author MrDios
 * @date 2017-07-21
 */
public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        // http请求链接
        String url = "http://www.mrdios.com/13-atomic-classes-in-java";

        // 组装请求
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        // 接收相应
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        // 处理结果
        byte[] bytes = EntityUtils.toByteArray(entity);
        String result = new String(bytes);
        System.out.println(result);
        File html = new File("mrdios.html");
        if (!html.exists()) {
            html.createNewFile();
        }
        FileWriter writer = new FileWriter(html);
        writer.write(result);
    }
}

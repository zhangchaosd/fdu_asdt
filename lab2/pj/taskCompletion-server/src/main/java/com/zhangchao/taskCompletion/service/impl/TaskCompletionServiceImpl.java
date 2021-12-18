package com.zhangchao.taskCompletion.service.impl;

import org.springframework.stereotype.Service;
import com.zhangchao.taskCompletion.entity.TaskCompletion;
import com.zhangchao.taskCompletion.entity.Employee;
import com.zhangchao.taskCompletion.service.TaskCompletionService;

import javax.annotation.Resource;
import java.util.List;
import java.util.ArrayList;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.HttpClient;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.http.util.EntityUtils;

/**
 * @author zhangchao
 * @date 2021/12/17
 */
@Service
public class TaskCompletionServiceImpl implements TaskCompletionService {

    @Override
    public List<TaskCompletion> getTaskCompletions() {
        List<TaskCompletion> ret = new ArrayList<TaskCompletion>();
        try {
            HttpClient client = HttpClients.createDefault();
            System.out.println("okkkkkkkkkkkk222222222.55555");
            // HttpGet request = new HttpGet("http://pj_employee-server_1:9999/employees");
            HttpGet request = new HttpGet("http://employee-server:9999/employees");
            request.setHeader("Accept", "application/json");
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            ObjectMapper mapper = new ObjectMapper();
            // String resultStr = EntityUtils.toString(entity, "UTF-8");
            // System.out.println(resultStr);
            List<Employee> employees = mapper.readValue(entity.getContent(), new TypeReference<List<Employee>>() {});
            for(Employee e : employees) {
                TaskCompletion tc = new TaskCompletion();
                tc.setDepartment(e.getDepartment());
                ret.add(tc);
            }
            // String url = "http://pj_employee-server_1:9999/employees";
            // URL restURL = new URL(url);
            // HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
            // conn.setRequestMethod("GET"); // POST GET PUT DELETE
            // conn.setRequestProperty("Accept", "application/json");
            // BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // String line;
            // while((line = br.readLine()) != null ){
            //     System.out.println(line);
            // }
            // br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}

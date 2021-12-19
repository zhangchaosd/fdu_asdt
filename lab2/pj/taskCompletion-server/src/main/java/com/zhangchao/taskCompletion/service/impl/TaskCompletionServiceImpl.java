package com.zhangchao.taskCompletion.service.impl;

import org.springframework.stereotype.Service;
import com.zhangchao.taskCompletion.entity.TaskCompletion;
import com.zhangchao.taskCompletion.entity.Employee;
import com.zhangchao.taskCompletion.entity.Task;
import com.zhangchao.taskCompletion.service.TaskCompletionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.net.MalformedURLException;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.ContentType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhangchao
 * @date 2021/12/19
 */
@Service
public class TaskCompletionServiceImpl implements TaskCompletionService {

    @Override
    public List<TaskCompletion> getTaskCompletions() {
        List<TaskCompletion> ret = new ArrayList<TaskCompletion>();
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet("http://employee-server:9999/employees");
            request.setHeader("Accept", "application/json");
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            ObjectMapper mapper = new ObjectMapper();
            List<Employee> employees = mapper.readValue(entity.getContent(), new TypeReference<List<Employee>>() {});

            HashMap<String, Integer> done = new HashMap<String, Integer>();
            HashMap<String, Integer> total = new HashMap<String, Integer>();
            for(Employee em : employees) {
                String department = em.getDepartment();
                Integer userid = em.getId();
                boolean completed = getTaskInfo(userid, 1); ////1 表示任务类别，用个宏定义更好
                if(done.containsKey(department)) {
                    Integer t = done.get(department);
                    t += 1;
                    if(completed) {
                        done.put(department, t);
                    }
                    Integer t2 = total.get(department);
                    t2 += 1;
                    total.put(department, t2);
                }
                else {
                    if(completed) {
                        done.put(department, 1);
                    }
                    else {
                        done.put(department, 0);
                    }
                    total.put(department, 1);
                }
            }
            for (String dep : done.keySet()) {
                TaskCompletion tc = new TaskCompletion();
                tc.setDepartment(dep);
                tc.setCompleted(done.get(dep));
                tc.setTotal(total.get(dep));
                ret.add(tc);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private boolean getTaskInfo(Integer userid, Integer category) {
        boolean ret = false;
        try {
            Task task = new Task();
            task.setTaskid(1);
            task.setUserid(userid);
            task.setCategory(category);
            HttpClient client = HttpClients.createDefault();
            HttpPost request = new HttpPost("http://task-server:9997/gettasksbyuseridandcategory");
            String ts = JSONObject.toJSONString(task);
            StringEntity requestentity = new StringEntity(ts);
            requestentity.setContentType(ContentType.APPLICATION_JSON.toString());
            request.setEntity(requestentity);
            HttpResponse response2 = client.execute(request);
            HttpEntity entity = response2.getEntity();
            ObjectMapper mapper = new ObjectMapper();
            List<Task> tcs = mapper.readValue(entity.getContent(), new TypeReference<List<Task>>() {});
            ret = tcs.get(0).getCompleted();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}

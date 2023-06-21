package org.simple.sm.quartz.cache;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  项目启动时初始化操作：
 *
 * 1、实现CommandLineRunner类，重写run方法
 *
 * 2、实现InitializingBean类，重新afterPropertiesSet方法，但bean需要通过set构造方法注入
 *
 * 3、通过构造方法注入
 *
 * @PostConstruct
 * public void init() {
 *     log.info("----初始化系统参数----");
 * }
 */
@Component
public class GlobalJobCache implements CommandLineRunner {
//    @Resource
//    RemindMeJobInfoService remindMeJobInfoService;
    //定义全局变量
    public static Map<String, JSONObject> allCache = new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
//        List<RemindMeJobInfo> list = remindMeJobInfoService.list();
//        list.forEach(e->{
//            JSONObject jsonObject = this.putJobInfo(e.getUrl(), e.getKey(), e.getClient());
//            this.addAndModifuJobToCache(e.getJobNo(),jsonObject);
//        });
//    }
//
//    /**
//     * 填充job的json
//     * @param url
//     * @param key
//     * @param client
//     * @return
//     */
//    public static JSONObject putJobInfo(String url,String key,String client){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("url",url);
//        jsonObject.put("key",key);
//        jsonObject.put("client",client);
//        return jsonObject;
//    }
//
//    /**
//     * 添加或修改缓存
//     * @param jobNo
//     * @param jobInfo
//     */
//    public static void addAndModifuJobToCache(String jobNo,JSONObject jobInfo){
//        allCache.put(jobNo,jobInfo);
//    }
//
//    /**
//     * 删除缓存
//     * @param jobNo
//     */
//    public static void delJobFromCache(String jobNo){
//        allCache.remove(jobNo);
    }
}

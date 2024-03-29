package org.simple.sm.notification.bark.service;

/**
 * bark消息推送接口
 */
public interface BarkService {
    /**
     * 推送消息
     * @param msg 消息内容
     */
    void push(String group, String msg);

    /**
     * 推送带有标题的消息
     * @param title 标题
     * @param msg 消息内容
     */
    void push(String group, String title, String msg);

    /**
     * 推送带有标题及跳转url的消息
     * 携带url时，点击推送会自动跳转到这个url
     * @param title 标题
     * @param msg 消息内容
     * @param url 跳转url
     */
    void push(String group, String title, String msg, String url);

}

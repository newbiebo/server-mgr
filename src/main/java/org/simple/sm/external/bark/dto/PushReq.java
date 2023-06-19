package org.simple.sm.external.bark.dto;

import lombok.Data;

/**
 * @author newbiebo
 */
@Data
public class PushReq {
    //    /**推送内容*/
//    private String content;
//    /**推送标题*/
//    private String title;
//    /**推送声音*/
//    private String sound;
//    /**自动保存通知消息，1-是*/
//    private boolean isArchive;
//    /**自定义图标*/
//    private String icon;
//    /**对消息进行分组*/
//    private String group;
//    /**时效性通知，
//     * 1、active-默认值，系统会立即亮屏通知
//     * 2、timeSensitive-可在专注模式下显示通知
//     * 3、passive-仅将通知添加到通知列表，不会亮屏提醒
//     * */
//    private String level;
//    /**携带url时，点击推送会自动跳转到这个url*/
    private String url;
    //    /**可复制推送内容*/
//    private String copy;
//    /**可为推送设置角标*/
//    private String badge;
//    /**自动复制推送内容到剪贴板*/
//    private String autoCopy;
    private String key;
    private String client;
}

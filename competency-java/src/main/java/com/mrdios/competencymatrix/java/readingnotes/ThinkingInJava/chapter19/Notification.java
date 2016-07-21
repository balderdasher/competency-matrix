package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter19;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * 单例通知，用于提示
 * 0:弹出框和页面提示均需设置"infoTip"参数用于展示提示信息
 * 1:弹出框提示须设置"type"参数用于artDialog展示不同的样式、"redirectUrl"参数可选决定关闭弹出框时的跳转链接(x)
 * 2:页面提示时设置"title"参数设置页面的title属性
 *
 * @author huxiong
 * @date 2015/09/14 15:27
 */
public enum Notification implements NotifyInterface {
	NOTICE {
		@Override
        public void doNotify(Model model) {
            model.addAttribute("infoTip", this);
        }
	    @Override
	    public void doNotify(HttpServletRequest request) {
		    request.setAttribute("infoTip", this);
	    }
    };

	public static final String BACK_NOTIFY_VIEW = "info";
    private NoticeType type;
    private String title;
    private String infoTip;
    private String redirectUrl;
    private String callBack;//附加回调参数
	private int historyGo = -1;//页面中history.go(int)的参数，仅当redirectUrl为空时此字段才有用，默认-1，即回退1个历史记录

    /**
     * 通知后擦黑板，防止当前通知影响下一个通知
     *
     * @return this
     */
    public void reset() {
        this.type = null;
        this.callBack = null;
        this.title = null;
        this.infoTip = null;
        this.redirectUrl = null;
	    this.historyGo = -1;
    }


    public String getCallBack() {
        return callBack;
    }

    public Notification setCallBack(String callBack) {
        this.callBack = callBack;
        return this;
    }

    public String getInfoTip() {
        return infoTip;
    }

    public Notification setInfoTip(String infoTip) {
        this.infoTip = infoTip;
        return this;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public Notification setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Notification setTitle(String title) {
        this.title = title;
        return this;
    }

    public NoticeType getType() {
        return type;
    }

    public Notification setType(NoticeType type) {
        this.type = type;
        return this;
    }

	public int getHistoryGo() {
		return historyGo;
	}

	public Notification setHistoryGo(int historyGo) {
		this.historyGo = historyGo;
		return this;
	}
}

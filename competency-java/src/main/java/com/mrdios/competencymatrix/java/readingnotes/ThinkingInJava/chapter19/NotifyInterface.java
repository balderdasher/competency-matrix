package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter19;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huxiong
 * @date 2015/09/20 23:51
 */
public interface NotifyInterface {
    void doNotify(Model model);
	void doNotify(HttpServletRequest request);
}

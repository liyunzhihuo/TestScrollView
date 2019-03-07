package com.xiao.testscrollview.util.interfaces;

/**
 * description: 加载更多接口
 * Created by 谢光亚 on  2017-04-19
 * QQ/E-mail：409918544
 * Version：1.0
 */

public interface ILoadMoreStatus {

    void loadingMore();//加载中

    void loadComplete();//加载完成

    void loadComplete(String text);

    void loadFailed();//加载失败

//    View getView();
}

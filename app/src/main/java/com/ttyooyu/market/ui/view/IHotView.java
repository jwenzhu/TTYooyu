package com.ttyooyu.market.ui.view;

import com.ttyooyu.market.data.entity.Community;
import com.ttyooyu.market.data.entity.Product;
import com.ttyooyu.market.ui.view.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2016-08-25.
 */
public interface IHotView extends IBaseView{

    /**
     * @param communityList
     */
    void fillDiscussionData(List<Community> communityList);
}

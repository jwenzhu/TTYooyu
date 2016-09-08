/*
 *
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 * Copyright (C) 2015 GuDong <maoruibin9035@gmail.com>
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ttyooyu.market.presenter.base;

import android.app.Activity;


import com.ttyooyu.market.core.MainFactory;
import com.ttyooyu.market.core.TTYooYu;
import com.ttyooyu.market.ui.view.base.IBaseView;


/**
 *
 */
public class BasePresenter<GV extends IBaseView> {

    public GV mView;
    /**
     * TODO 这里用是否用Activity待考证
     */
    public Activity mContext;

    public static final TTYooYu M_TT_YOO_YU = MainFactory.getTTYooYuInstance();

    public BasePresenter(Activity context, GV view) {
        mContext = context;
        mView = view;
    }

}

package com.foodie.bjtu.foodie.util;

import java.util.List;

/**
 * Created by zhao on 2016/5/17.
 */
public interface EncodeCallBackListener {
    void onFinish(List<String> encodedImages);
    void onError();
}

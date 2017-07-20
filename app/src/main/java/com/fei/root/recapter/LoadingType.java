package com.fei.root.recapter;

import android.support.annotation.IntDef;

import static com.fei.root.recapter.LoadingType.LOAD_FAIL;
import static com.fei.root.recapter.LoadingType.LOAD_ING;
import static com.fei.root.recapter.LoadingType.LOAD_NONE;
import static com.fei.root.recapter.LoadingType.LOAD_START;
import static com.fei.root.recapter.LoadingType.LOAD_SUCCESS;

/**
 * Created by PengFeifei on 17-7-17.
 */
@IntDef({LOAD_START, LOAD_ING, LOAD_FAIL, LOAD_SUCCESS,LOAD_NONE})
public @interface LoadingType {
    int LOAD_START = 0;
    int LOAD_ING = 1;
    int LOAD_FAIL = 2;
    int LOAD_SUCCESS = 3;
    int LOAD_NONE = 4;
}
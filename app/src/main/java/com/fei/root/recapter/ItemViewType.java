package com.fei.root.recapter;

import android.support.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import static com.fei.root.recapter.ItemViewType.FOOTER;
import static com.fei.root.recapter.ItemViewType.HEADER;
import static com.fei.root.recapter.ItemViewType.ITEM;

/**
 * Created by PengFeifei on 17-7-13.
 */
@Target(ElementType.METHOD)
@IntDef({HEADER, FOOTER, ITEM})
public @interface ItemViewType {
    int HEADER = 0;
    int FOOTER = 1;
    int ITEM = 2;
}
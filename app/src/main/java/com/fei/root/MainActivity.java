package com.fei.root;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fei.root.recapter.R;
import com.fei.root.recapter.action.LoadMoreAction;
import com.fei.root.recapter.action.RefreshDataAction;
import com.fei.root.recapter.adapter.RefloadAdapter;
import com.fei.root.recapter.listener.AdapterListeners;
import com.fei.root.recapter.view.DefaultRefreshFooterView;
import com.fei.root.recapter.view.DefaultRefreshHeaderView;
import com.fei.root.recapter.view.RefloadRecyclerView;
import com.fei.root.recapter.viewholder.CommonHolder;
import com.fei.root.viewbinder.Binder;
import com.fei.root.viewbinder.ViewBinder;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements LoadMoreAction<String>,RefreshDataAction<String> {

    @Binder
    private TextView btn;
    @Binder
    private RefloadRecyclerView recyclerView;

    private RefloadAdapter<String> commonAdapter;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(view);
        ViewBinder.bindViews(this, view);
        init();
    }

    private void init() {
        ArrayList<String> list = new ArrayList<>();
        list.add(i++ + "");
        list.add(i++ + "");
        list.add(i++ + "");
        list.add(i++ + "");
        list.add(i++ + "");
        list.add(i++ + "");
        list.add(i++ + "");
        list.add(i++ + "");
        list.add(i++ + "");
        list.add(i++ + "");
        list.add(i++ + "");
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        commonAdapter = new RefloadAdapter<String>(list, R.layout.list_item) {
            @Override
            protected void convert(CommonHolder holder, String s, int position) {
                holder.setText(R.id.btn, s);
            }
        };
        recyclerView.setAdapter(commonAdapter);
        commonAdapter.setOnHeaderClick(new AdapterListeners.OnHeaderClick() {
            @Override
            public void onHeaderClick(RecyclerView recyclerView, View header, int Position) {
            }
        });
        commonAdapter.setRefreshHeader(new DefaultRefreshHeaderView(this));
        commonAdapter.setLoadMoreFooter(new DefaultRefreshFooterView(this));
        commonAdapter.setRefreshDataListener(this);
        commonAdapter.setLoadMoreDataListener(this);
        commonAdapter.setEnablePullLoadMore(true);
        commonAdapter.setEnablePullRefreshing(true);
    }

    @Override
    public void onLoading() {
        Toast.makeText(this, "onLoading", Toast.LENGTH_SHORT).show();
        int result = new Random(100).nextInt();
        recyclerView.postDelayed(() -> {
            if (result % 2 == 0) {
                commonAdapter.appendItem("load");
                commonAdapter.onLoadSuccess(false);
            } else if (result % 3 == 0) {
                commonAdapter.onLoadNone();
            } else {
                commonAdapter.onLoadFail(false);
            }
        }, 3000);
    }

    @Override
    public void onLoadFail() {
        Toast.makeText(this, "onLoadFail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadSuccess() {
        Toast.makeText(this, "onLoadSuccess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadNone() {

    }

    public void onClick(View view) {
        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
    }

    public void onClick1(View view) {

    }

    @Override
    public void onRefreshing() {
        int result = new Random(100).nextInt();
        recyclerView.postDelayed(() -> {
            if (result % 2 == 0) {
                commonAdapter.appendItem("refresh");
                commonAdapter.onLoadSuccess(true);
            } else {
                commonAdapter.onLoadFail(true);
            }
        }, 3000);
    }

    @Override
    public void onRefreshFail() {

    }

    @Override
    public void onRefreshSuccess() {

    }
}

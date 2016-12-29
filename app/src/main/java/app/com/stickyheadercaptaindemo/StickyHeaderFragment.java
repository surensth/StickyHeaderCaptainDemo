package app.com.stickyheadercaptaindemo;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;
import java.util.List;

import app.com.stickyheadercaptaindemo.adapter.CustomAdapter;
import app.com.stickyheadercaptaindemo.model.BodyItem;
import app.com.stickyheadercaptaindemo.model.HeaderItem;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by surensth on 12/28/16.
 */

public class StickyHeaderFragment extends Fragment {
    //    @BindView(R.id.recycler_view)
//    RecyclerView mRecyclerView;
    RecyclerView mRecyclerView;

    public static StickyHeaderFragment newInstance() {
        StickyHeaderFragment fragment = new StickyHeaderFragment();
        return fragment;
    }

    public StickyHeaderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sticky_header, container, false);
        ButterKnife.bind(this, view);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        createHeader();
        createBody();

        setUpRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void setUpRecyclerView() {
//       LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
//        mRecyclerView.setLayoutManager(mLinearLayoutManager);
//        mRecyclerView.setHasFixedSize(true);
        CustomAdapter mAdapter = new CustomAdapter(mHeaderList, mBodyList);
        mRecyclerView.setAdapter(mAdapter);


        int orientation = getLayoutManagerOrientation(getResources().getConfiguration().orientation);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), orientation, false);
        mRecyclerView.setLayoutManager(layoutManager);

        // Add the sticky headers decoration
        final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(mAdapter);
        mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                headersDecor.invalidateHeaders();
            }
        });
        mRecyclerView.addItemDecoration(headersDecor);

    }

    List<HeaderItem> mHeaderList = new ArrayList<>();

    public List<HeaderItem> createHeader() {
        for (int i = 0; i < 10; i++) {
            mHeaderList.add(new HeaderItem(i, "header " + i));
        }
        return mHeaderList;
    }

    List<BodyItem> mBodyList = new ArrayList<>();

    public List<BodyItem> createBody() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                mBodyList.add(new BodyItem(j, "Data " + j, "value of title " + i, i));
            }
        }
        return mBodyList;
    }

    private int getLayoutManagerOrientation(int activityOrientation) {
        if (activityOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            return LinearLayoutManager.VERTICAL;
        } else {
            return LinearLayoutManager.HORIZONTAL;
        }
    }
}

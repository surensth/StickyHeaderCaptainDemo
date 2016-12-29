package app.com.stickyheadercaptaindemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.ArrayList;
import java.util.List;

import app.com.stickyheadercaptaindemo.R;
import app.com.stickyheadercaptaindemo.model.BodyItem;
import app.com.stickyheadercaptaindemo.model.HeaderItem;

/**
 * Created by surensth on 12/28/16.
 */

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyRecyclerHeadersAdapter<CustomAdapter.HeaderItemViewHolder> {
    List<HeaderItem> headerList = new ArrayList<>();
    List<BodyItem> bodyList = new ArrayList<>();


    public CustomAdapter(List<HeaderItem> mHeaderList, List<BodyItem> mBodyList) {
        setHasStableIds(true);
        this.headerList = mHeaderList;
        this.bodyList = mBodyList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.body_row, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.v("test", "header" + headerList.size());

        BodyItem mBodyItem = bodyList.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.mTvTitle.setText(mBodyItem.getTitle());
        itemViewHolder.mTvValue.setText(mBodyItem.getValue());
    }

    @Override
    public long getHeaderId(int position) {
        Log.v("gtest", "header id is " + bodyList.get(position).getHeaderId());
        return bodyList.get(position).getHeaderId();
    }

    @Override
    public HeaderItemViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.header_row, parent, false);
        return new HeaderItemViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderItemViewHolder holder, int position) {
        Log.v("test", "bind header" + headerList.size());
        int m = bodyList.get(position).getHeaderId();
        for (HeaderItem header : headerList) {
            if (header.getId() == m) {
                holder.mTvTitle.setText(header.getTitle());
            }
        }


    }

    @Override
    public int getItemCount() {
        return bodyList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvTitle;
        public TextView mTvValue;

        public ItemViewHolder(View view) {
            super(view);
            mTvTitle = (TextView) view.findViewById(R.id.bodyTitleTextView);
            mTvValue = (TextView) view.findViewById(R.id.bodyValueTextView);
        }
    }

    public class HeaderItemViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvTitle;

        public HeaderItemViewHolder(View view) {
            super(view);
            mTvTitle = (TextView) view.findViewById(R.id.titleTextView);
        }
    }
}

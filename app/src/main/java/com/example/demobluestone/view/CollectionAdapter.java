package com.example.demobluestone.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demobluestone.R;
import com.example.demobluestone.model.common.HeaderItem;
import com.example.demobluestone.model.common.JCollection;
import com.example.demobluestone.model.common.ListItem;
import com.example.demobluestone.utils.GlideApp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<ListItem> listItems;


    public CollectionAdapter(Context context, List<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == 1) {
            View v = inflater.inflate(R.layout.header_list_view_item, parent, false);
            return new HeaderViewHolder(v);
        } else {
            View v = inflater.inflate(R.layout.collection_list_item_view, parent, false);
            return new CollectionListViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderViewHolder){
            HeaderItem headerItem = (HeaderItem) listItems.get(position);
            HeaderViewHolder headerViewHolder = (HeaderViewHolder)holder;
            headerViewHolder.headerTxtView.setText(headerItem.getHeadingName());


        }else if (holder instanceof CollectionListViewHolder){
            JCollection collection = (JCollection) listItems.get(position);
            CollectionListViewHolder collectionListViewHolder = (CollectionListViewHolder) holder;
            collectionListViewHolder.collectionName.setText(collection.getName());
            collectionListViewHolder.collectionDesc.setText(collection.getShortDescription());
            collectionListViewHolder.collectionDesCount.setText(String.valueOf(collection.getDesignCount())+ " Designs");
            collectionListViewHolder.collectionDesStPrice.setText("Starting from Rs."+ String.valueOf(collection.getStartPrice()));
            GlideApp.with(context)
                    .load(collection.getImageUrl())
                    .into(collectionListViewHolder.categoryImage);

        }

    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) {
            return 1;
        } else
            return 0;
    }

    private boolean isHeader(int position) {
        return listItems.get(position) instanceof HeaderItem;
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.header_txt_view)
        TextView headerTxtView;

        Unbinder unbinder;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);

        }
    }

    class CollectionListViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.category_image)
        ImageView categoryImage;
        @BindView(R.id.collection_name)
        TextView collectionName;
        @BindView(R.id.collection_desc)
        TextView collectionDesc;
        @BindView(R.id.dotted_line)
        View dottedLine;
        @BindView(R.id.collection_des_count)
        TextView collectionDesCount;
        @BindView(R.id.collection_des_st_price)
        TextView collectionDesStPrice;
        Unbinder unbinder;

        public CollectionListViewHolder(View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }
    }

}

package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.astro.astrotechnology.R;

import java.util.ArrayList;
import java.util.List;

import Model.ChannelItems;
import Model.MainItems;

/**
 * Created by vitinhHienAnh on 05-11-17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    public List<ChannelItems> list;
    String responseMessage , responseCode;
    Context context;
    private static ClickListener clickListener;

//    public MainAdapter(List<MainItems> itemses){
//        list = itemses;
//    }

    public MainAdapter() {
        list = new ArrayList<>();
    }

    public void setData(List<ChannelItems> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public void setString(String responseCo , String responseMe){
        responseMessage = responseMe;
        responseCode = responseCo;
        notifyDataSetChanged();
    }

    public ChannelItems getData(int position){
        return  list.get(position);
    }




    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_channel_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        holder.tvchannelIdMain.setText(list.get(position).getChannelTitle());
        holder.tvChannelTitleMain.setText(list.get(position).getChannelStbNumber());
        //holder.tvChannelNumberMain.setText(responseCodeRecyc);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvchannelIdMain, tvChannelTitleMain, tvChannelNumberMain;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvchannelIdMain = itemView.findViewById(R.id.tvchannelIdMain);
            tvChannelTitleMain = itemView.findViewById(R.id.tvChannelTitleMain);

        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        MainAdapter.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick (int position , View view);
    }
}

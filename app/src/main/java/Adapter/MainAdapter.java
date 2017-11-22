package Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.astro.astrotechnology.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import Model.ChannelFavorite;
import Model.ChannelItems;

/**
 * Created by vitinhHienAnh on 05-11-17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    public List<ChannelItems> list;
    public List<ChannelFavorite> listFavorite;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String ChannelTitle = "ChannelTitle";
    public static final String ChannelNumber = "ChannelNumber";
    public static final String ChannelID = "ChannelID";
    SharedPreferences sharedpreferences;
    String responseMessage, responseCode;
    Context context;
    private static ClickListener clickListener;

//    public MainAdapter(List<MainItems> itemses){
//        list = itemses;
//    }

    public MainAdapter(Activity activity) {
        list = new ArrayList<>();

        listFavorite = new ArrayList<>();

        //get shared Preference
        sharedpreferences = activity.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = sharedpreferences.getString("ChannelID", "");
        listFavorite = gson.fromJson(json, new TypeToken<ArrayList<ChannelFavorite>>() {}.getType());


    }

    public void setData(List<ChannelItems> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setString(String responseCo, String responseMe) {
        responseMessage = responseMe;
        responseCode = responseCo;
        notifyDataSetChanged();
    }

    public ChannelItems getData(int position) {
        return list.get(position);
    }


    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_channel_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainAdapter.ViewHolder holder, final int position) {
        final ChannelItems item = list.get(position);

        holder.tvchannelIdMain.setText(list.get(position).getChannelTitle());
        holder.tvChannelTitleMain.setText(list.get(position).getChannelStbNumber());

        ChannelFavorite channelFavorite = new ChannelFavorite(item.getChannelId());

        for (ChannelFavorite channelFavorite_ : listFavorite) {
            Log.d("bbbbbb", "value: " + listFavorite);
            if (channelFavorite_.channelId.equals(item.getChannelId()) == true) {
                channelFavorite = channelFavorite_;
                break;
            }
        }

        if (channelFavorite.isFavorite == true) {
            holder.imgLikeMain.setImageResource(R.drawable.img_liked);
        } else {
            holder.imgLikeMain.setImageResource(R.drawable.img_like);
        }


        holder.imgLikeMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int index = indexInListFavorite(item.getChannelId());
                Log.d("aaaaaaa", "value: " + index);
                if (index > -1) {
                    listFavorite.get(index).isFavorite = !listFavorite.get(index).isFavorite;
                } else {
                    ChannelFavorite favorite = new ChannelFavorite(item.getChannelId());
                    favorite.isFavorite = true;
                    listFavorite.add(favorite);

                }
                // save to shared preference
                Gson gson = new Gson();
                String json = gson.toJson(listFavorite);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(ChannelID, json);
                editor.commit();


                notifyItemChanged(position);

            }
        });

        //holder.tvChannelNumberMain.setText(responseCodeRecyc);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvchannelIdMain, tvChannelTitleMain, tvChannelNumberMain;
        ImageView imgLikeMain;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvchannelIdMain = itemView.findViewById(R.id.tvchannelIdMain);
            tvChannelTitleMain = itemView.findViewById(R.id.tvChannelTitleMain);
            imgLikeMain = itemView.findViewById(R.id.imgLikeMain);

        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);

        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        MainAdapter.clickListener = clickListener;
    }

    private int indexInListFavorite(String channelId) {
        for (int i = 0; i < listFavorite.size(); i++) {
            if (listFavorite.get(i).channelId.equals(channelId) == true) {
                return i;
            }
        }
        return -1;
    }

    public interface ClickListener {
        void onItemClick(int position, View view);

    }


}

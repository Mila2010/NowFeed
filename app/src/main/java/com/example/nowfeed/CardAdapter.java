package com.example.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.nowfeed.model.InstagramUserPOJO;
import com.example.nowfeed.model.WeatherRespond;

import java.util.List;

/**
 * Created by Millochka on 10/30/16.
 */
public class CardAdapter extends RecyclerView.Adapter {

    private List<Object> items;
    private final int  INSTAGRAM = 0,WEATHER = 1,NOTES=2 ;

    public static final String SHARED_NAME= "mynotes";


    public CardAdapter(List<Object> items) {
        this.items=items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case INSTAGRAM:
                viewHolder = new FirstCardViewHolder(parent);
                break;
            case WEATHER:
                viewHolder = new SecondCardViewHolder(parent);
                break;
            default:
                viewHolder = new ThirdCardViewHolder(parent);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case INSTAGRAM:
                FirstCardViewHolder firstCard= (FirstCardViewHolder) holder;
//                firstCard.onBind((Instagram) items.get(position));
                break;

            case WEATHER:
                SecondCardViewHolder secondCard = (SecondCardViewHolder) holder;
                secondCard.onBind((WeatherRespond) items.get(position));
                break;

            default:
                ThirdCardViewHolder thirdCard = (ThirdCardViewHolder) holder;
                thirdCard.onBind((String) items.get(position));
                break;
        }
    }

        @Override
        public int getItemCount () {
            return items.size();
        }

        @Override
        public int getItemViewType ( int position){
            if (items.get(position) instanceof InstagramUserPOJO) {
                return  INSTAGRAM;
            } else if (items.get(position) instanceof WeatherRespond) {
                return WEATHER;
            }else if (items.get(position) instanceof String) {
                return NOTES;
            }
            return -1;
        }
}

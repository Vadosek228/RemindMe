package com.vadosek.remindme.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vladislav.remindme.R;
import com.vadosek.remindme.dto.RemindDTO;

import java.util.List;

public class RemindListAdapter extends RecyclerView.Adapter<RemindListAdapter.RemindViewHolder>{

    //делаем хранилище для Item
    private List<RemindDTO> data;

    //чтобы дата сюда попадала, создаем конструктор
    public RemindListAdapter(List<RemindDTO> data) { //передает и инициализирует списки
        this.data = data;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //то что нам вернет наш view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remind_item, parent, false);

        //передаем в наш RemindViewHolder наш View
        return new RemindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RemindViewHolder holder, int position) {

        //просечиваем значение на наш Item
        //проставляем тайтл
        //holder.title.setText(data.get(position).getTitle());//берез значение из data //position - id

        //с даты получаем элемент item, который является типом RemindDTO
        RemindDTO item = data.get(position);
        // с него можем получать данные такие как
        //title и последующий
        holder.title.setText(item.getTitle());


    }

    @Override
    public int getItemCount() {
        return data.size();//для реализации
    }

    public static class RemindViewHolder extends RecyclerView.ViewHolder{

        //элементы, которыми будем управлять
        CardView cardView;
        TextView title;

        //заполняющий элемент
        public RemindViewHolder(View itemView){
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
        }

    }
}

package bingo.notes.ui.main.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bingo.notes.R;
import bingo.notes.data.entity.pojo.Message;
import bingo.notes.ui.detail.DetailActivity;

import static bingo.notes.ui.detail.DetailActivity.MSG;

/**
 * Created by bingo on 14.03.16.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<Message> list;

    public NotesAdapter(List<Message> messages) {
        list = messages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.i_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMsg;
        TextView txtMsg;
        TextView txtDesc;
        TextView text;
        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            imgMsg = (ImageView) itemView.findViewById(R.id.imgMsg);
            txtMsg = (TextView) itemView.findViewById(R.id.txtMesg);
            txtDesc = (TextView) itemView.findViewById(R.id.txtDesc);
            text = (TextView) itemView.findViewById(R.id.text);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }

        public void bind(final Message message) {
            imgMsg.setImageResource(message.getResId());
            txtMsg.setText(message.getMsg());
            txtDesc.setText(message.getDesc());
            text.setText(message.getDescId());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtra(MSG, message.getDesc());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}



package sq.test_socketchat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by sp01 on 2017/4/28.
 */

public class MyAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<MyBean> data;
    private static final int TYPEONE = 1;
    private static final int TYPETWO = 2;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<MyBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getNumber();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case TYPEONE:
                View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
                holder = new OneViewHolder(view);
                break;
            case TYPETWO:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item2,parent,false);
                holder = new TwoViewHolder(view1);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case TYPEONE:
                OneViewHolder oneViewHolder = (OneViewHolder) holder;
                oneViewHolder.tv1.setText(data.get(position).getData());
                oneViewHolder.name1.setText(data.get(position).getName());
                oneViewHolder.time1.setText(data.get(position).getTime());
                break;
            case TYPETWO:
                TwoViewHolder twoViewHolder = (TwoViewHolder) holder;
                twoViewHolder.tv2.setText(data.get(position).getData());
                twoViewHolder.name2.setText(data.get(position).getName());
                twoViewHolder.time2.setText(data.get(position).getTime());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return  data != null && data.size() > 0 ? data.size() : 0;
    }

    class OneViewHolder extends RecyclerView.ViewHolder{
       private TextView tv1;
        private TextView name1,time1;
       public OneViewHolder(View itemView) {
           super(itemView);
           tv1 = (TextView) itemView.findViewById(R.id.tv);
           name1 = (TextView) itemView.findViewById(R.id.tv_name);
           time1 = (TextView) itemView.findViewById(R.id.tv_time);
       }
   }

    class TwoViewHolder extends RecyclerView.ViewHolder{
        private TextView tv2;
        private TextView name2,time2;
        public TwoViewHolder(View itemView) {
            super(itemView);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
            name2 = (TextView) itemView.findViewById(R.id.tv_name2);
            time2 = (TextView) itemView.findViewById(R.id.tv_time2);
        }
    }

}

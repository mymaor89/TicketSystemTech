package tech.sunspark.org.ticketsystem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

// The adapter class which
// extends RecyclerView Adapter
public class Adapter
    extends RecyclerView.Adapter<Adapter.MyView> {
    private Context mContext;
    // List with String type
    private List<String> list;

    // View Holder class which
    // extends RecyclerView.ViewHolder
    public class MyView
            extends RecyclerView.ViewHolder {

        // Text View
        TextView textView;
        TextView textView2;
        ImageView image_icon;
        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyView(View view)
        {
            super(view);

            // initialise TextView with id
            textView = (TextView)view.findViewById(R.id.tv_heading);
            textView2 = (TextView) view.findViewById(R.id.tv_details);
            image_icon = (ImageView) view.findViewById(R.id.iv_icon);
        }
    }

    // Constructor for adapter class
    // which takes a list of String type
    public Adapter(List<String> horizontalList,Context mContext)
    {
        this.list = horizontalList;
        this.mContext = mContext;
    }

    // Override onCreateViewHolder which deals
    // with the inflation of the card layout
    // as an item for the RecyclerView.
    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType)
    {

        // Inflate item.xml using LayoutInflator
        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item,
                        parent,
                        false);

        // return itemView
        return new MyView(itemView);
    }

    // Override onBindViewHolder which deals
    // with the setting of different data
    // and methods related to clicks on
    // particular items of the RecyclerView.
    @Override
    public void onBindViewHolder(final MyView holder,
                                 final int position)
    {

        // Set the text of each item of
        // Recycler view with the list items
        holder.textView.setText(list.get(position));
        holder.textView2.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Position : "+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.
    @Override
    public int getItemCount()
    {
        return list.size();
    }
}

package com.example.niklas.projekt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Niklas on 22.12.2014.
 */
public class StringArrayAdapter extends BaseAdapter {

    String[] names;
    Context ctxt;
    LayoutInflater myInflater;

    public StringArrayAdapter(String[] args, Context c)
    {
        this.names = args;
        this.ctxt = c;
        this.myInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        // TODO Number of elements in list
        return names.length;
    }

    @Override
    public Object getItem(int position)
    {
        // TODO return names[position]
        return names[position];
    }

    @Override
    public long getItemId(int position)
    {
        // TODO position = id
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Create the call (View) and populate it with an element of the array
        if(convertView == null)
        {
            convertView = myInflater.inflate(android.R.layout.simple_list_item_1,parent,false);
        }
        TextView name = (TextView)convertView.findViewById(android.R.id.text1);
        name.setText(names[position]);

        return convertView;
    }

    public void remove(String itemString)
    {
        int pos = 0;
        for(int i = 0; i < names.length; i++)
        {
            if(names[i].equals(itemString))
            {
                for(int j = pos; j < names.length; j++)
                {
                    names[i] = names[i+1];
                }
            }
            pos = pos + 1;
        }
        names[names.length] = "";
    }
}

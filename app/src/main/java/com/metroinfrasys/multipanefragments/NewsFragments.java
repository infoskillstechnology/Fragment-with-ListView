package com.metroinfrasys.multipanefragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class NewsFragments extends Fragment {

    private List<String> newList;

    public NewsFragments() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_fragments, container, false);

        newList = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            newList.add("Item " + i);

        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(new MyAdapter());
        return view;
    }


    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return newList.size();
        }

        @Override
        public Object getItem(int position) {
            return newList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.row, null);
            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText(newList.get(position));
            return view;
        }
    }
}

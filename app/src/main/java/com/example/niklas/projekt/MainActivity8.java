package com.example.niklas.projekt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity8 extends Activity {

    private List<String> mItems;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter<CustomViewHolder> mAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity8);

        initData();
        initRecyclerView();
    }

    private void initData() {
        String[] values = {"Aufwärmen",
                "Beine",
                "Brust",
                "Rücken",
                "Schulter",
                "Nacken",
                "Bauch",
                "Bizeps",
                "Trizeps",
                "Abkühlen"
        };

        // Fuege alle Werte aus dem Array values ind die ArrayList vals ein
        mItems = new ArrayList<String>(Arrays.asList(values));
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerView.Adapter<CustomViewHolder>() {
            @Override
            public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1
                        , viewGroup, false);
/*                LayoutInflater inf = LayoutInflater.from(viewGroup.getContext());
                View view = inf.inflate(R.layout.simple_list_item_1, viewGroup, false);*/
                return new CustomViewHolder(view);
            }

            @Override
            public void onBindViewHolder(CustomViewHolder viewHolder, int i) {
                viewHolder.mTextView.setText(mItems.get(i));
            }

            @Override
            public int getItemCount() {
                return mItems.size();
            }
        };
        mRecyclerView.setAdapter(mAdapter);

        SwipeDismissRecyclerViewTouchListener touchListener =
                new SwipeDismissRecyclerViewTouchListener(
                        mRecyclerView,
                        new SwipeDismissRecyclerViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
//                                    mLayoutManager.removeView(mLayoutManager.getChildAt(position));
                                    mItems.remove(position);
                                    mAdapter.notifyItemRemoved(position);
                                }
                                mAdapter.notifyDataSetChanged();
                            }
                        });
        mRecyclerView.setOnTouchListener(touchListener);
        // Setting this scroll listener is required to ensure that during ListView scrolling,
        // we don't look for swipes.
        mRecyclerView.setOnScrollListener(touchListener.makeScrollListener());
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(MainActivity8.this, "Clicked " + mItems.get(position), Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public CustomViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private OnItemClickListener mListener;

        GestureDetector mGestureDetector;

        public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildPosition(childView));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
        }
    }

    public void buttonOnClick3(View v) {
        // do something when the button is clicked
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(),MainActivity6.class));
    }
}
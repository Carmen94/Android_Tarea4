package com.iteso.tarea4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.tarea4.beans.ItemProduct;
import com.iteso.tarea4.tools.Constants;

import java.util.ArrayList;
import java.util.Iterator;


public class FragmentHome extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemProduct> myDataSet;
    public FragmentHome() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_home_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        myDataSet = new ArrayList<ItemProduct>();
        recyclerView.setLayoutManager(mLayoutManager);
        ItemProduct fridge = new ItemProduct();
        fridge.setTitle(getString(R.string.fridgeTitle));
        fridge.setStore(getString(R.string.bbStore));
        fridge.setLocation(getString(R.string.fridgeLocation));
        fridge.setPhone(getString(R.string.fridgePhone));
        fridge.setImage(2);
        fridge.setDescription(getString(R.string.fridgeDescription));
        fridge.setCode(getString(R.string.fridgeCode));
        fridge.setCategory(2);
        myDataSet.add(fridge);

        mAdapter = new AdapterProduct(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ItemProduct itemProduct = data.getParcelableExtra(Constants.PRODUCT);
        Iterator<ItemProduct> iterator = myDataSet.iterator();
        int position = 0;
        while(iterator.hasNext()){
            ItemProduct item = iterator.next();
            if(item.getCode().equals(itemProduct.getCode())){
                myDataSet.set(position, itemProduct);
                break;
            }
            position++;
        }
        mAdapter.notifyDataSetChanged();
    }
}
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


public class FragmentElectronics extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemProduct> myDataSet;
    public FragmentElectronics() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_electronics, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_electronics_recycler_view);
        recyclerView.setHasFixedSize(true);
        myDataSet = new ArrayList<ItemProduct>();
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        ItemProduct micro = new ItemProduct();
        micro.setTitle(getString(R.string.microTitle));
        micro.setStore(getString(R.string.bbStore));
        micro.setLocation(getString(R.string.microLocation));
        micro.setPhone(getString(R.string.microPhone));
        micro.setImage(3);
        micro.setDescription(getString(R.string.microDescription));
        micro.setCode(getString(R.string.microCode));
        micro.setCategory(3);

        myDataSet.add(micro);
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
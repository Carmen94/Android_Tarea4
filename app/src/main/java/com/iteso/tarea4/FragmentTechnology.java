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


public class FragmentTechnology extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemProduct> myDataSet;
    public FragmentTechnology() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__technology, container, false);
        RecyclerView recyclerView = (RecyclerView)
                view.findViewById(R.id.fragment_technology_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        myDataSet = new ArrayList<ItemProduct>();

        ItemProduct macbook = new ItemProduct();
        macbook.setTitle(getString(R.string.macbookTitle));
        macbook.setStore(getString(R.string.bbStore));
        macbook.setLocation(getString(R.string.macbookLocation));
        macbook.setPhone(getString(R.string.macbookPhone));
        macbook.setImage(0);
        macbook.setDescription(getString(R.string.macbookDescription));
        macbook.setCode(getString(R.string.macbookCode));
        macbook.setCategory(1);

        ItemProduct allienware = new ItemProduct();
        allienware.setTitle(getString(R.string.allienwareTitle));
        allienware.setStore(getString(R.string.bbStore));
        allienware.setLocation(getString(R.string.allienwareLocation));
        allienware.setPhone(getString(R.string.allienwarePhone));
        allienware.setImage(1);
        allienware.setDescription(getString(R.string.allienwareDescription));
        allienware.setCode(getString(R.string.allienwareCode));
        allienware.setCategory(1);

        myDataSet.add(macbook);
        myDataSet.add(allienware);
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
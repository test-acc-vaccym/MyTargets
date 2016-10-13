/*
 * MyTargets Archery
 *
 * Copyright (C) 2015 Florian Dreier
 * All rights reserved
 */

package de.dreier.mytargets.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.dreier.mytargets.R;
import de.dreier.mytargets.adapters.ListAdapterBase;
import de.dreier.mytargets.databinding.FragmentListBinding;
import de.dreier.mytargets.databinding.ItemImageSimpleBinding;
import de.dreier.mytargets.shared.models.WindDirection;
import de.dreier.mytargets.utils.SlideInItemAnimator;
import de.dreier.mytargets.utils.ToolbarUtils;
import de.dreier.mytargets.utils.multiselector.SelectableViewHolder;

public class WindDirectionListFragment extends SelectItemFragment<WindDirection> {

    protected FragmentListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        binding.recyclerView.setHasFixedSize(true);
        mAdapter = new WindDirectionAdapter(getContext());
        binding.recyclerView.setItemAnimator(new SlideInItemAnimator());
        binding.recyclerView.setAdapter(mAdapter);
        binding.fab.setVisibility(View.GONE);
        useDoubleClickSelection = false;
        ToolbarUtils.showUpAsX(this);
        return binding.getRoot();
    }

    @Override
    public void onLongClick(SelectableViewHolder holder) {
        onClick(holder, (WindDirection) holder.getItem());
    }

    private class WindDirectionAdapter extends ListAdapterBase<WindDirection> {
        WindDirectionAdapter(Context context) {
            super(context);
            setList(WindDirection.getList(getContext()));
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_image_simple, parent, false);
            return new ViewHolder(itemView);
        }
    }

    private class ViewHolder extends SelectableViewHolder<WindDirection> {
        ItemImageSimpleBinding binding;

        public ViewHolder(View itemView) {
            super(itemView, mSelector, WindDirectionListFragment.this);
            binding = DataBindingUtil.bind(itemView);
        }

        @Override
        public void bindItem() {
            binding.name.setText(mItem.name);
            binding.image.setImageDrawable(mItem.getDrawable(getContext()));
        }
    }
}
package com.example.vishal.sampletv;

import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.RowPresenter;


/**
 * Custom {@link #ListRowPresenter}, it can have multiple rows.
 * <p>
 * Detail: Internally it is changing {@link ListRowPresenter.ViewHolder}'s
 * {@link ListRowPresenter.ViewHolder#mGridView} to set number of rows.
 */
public class CustomListRowPresenter extends ListRowPresenter {

    private static final String TAG = CustomListRowPresenter.class.getSimpleName();

    public CustomListRowPresenter() {
        super();
        setHeaderPresenter(new RowHeaderTextPresenter());
    }

    @Override
    protected void onBindRowViewHolder(RowPresenter.ViewHolder holder, Object item) {
        /* This two line codes changes the number of rows of ListRow */
        if (item instanceof CustomListRow) {
            int numRows = ((CustomListRow) item).getNumRows();
            ((ListRowPresenter.ViewHolder) holder).getGridView().setNumRows(numRows);
        }
        super.onBindRowViewHolder(holder, item);
    }

    @Override
    protected void initializeRowViewHolder(RowPresenter.ViewHolder holder) {
        super.initializeRowViewHolder(holder);

        /* Disable Shadow */
        // setShadowEnabled(false);
    }
}
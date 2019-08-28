package meugeninua.androidpluralstest;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {

    private final LayoutInflater inflater;

    public DataAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_data, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    static class DataHolder extends RecyclerView.ViewHolder {

        private final Resources resources;
        private final TextView booksCountView;
        private final TextView booksOwnsView;

        DataHolder(@NonNull View itemView) {
            super(itemView);
            resources = itemView.getResources();
            booksCountView = itemView.findViewById(R.id.books_count);
            booksOwnsView = itemView.findViewById(R.id.books_owns);
        }

        void bind(int position) {
            booksCountView.setText(resources.getQuantityString(
                    R.plurals.books_count_text, position, position));
            String name = resources.getString(R.string.name);
            booksOwnsView.setText(resources.getQuantityString(
                    R.plurals.books_owns_text, position, name));
        }
    }
}

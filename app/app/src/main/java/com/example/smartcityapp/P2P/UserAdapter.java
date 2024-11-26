package com.example.smartcityapp.P2P;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcityapp.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

/**
 * UserAdapter class for managing the display of users in a RecyclerView.
 * This adapter binds user data to the view components for each item in the RecyclerView.
 * author: Lujin Sun (u7897414)
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;
    private OnUserClickListener onUserClickListener;

    /**
     * Constructor for UserAdapter.
     *
     * @param userList           List of users to be displayed.
     * @param onUserClickListener Listener to handle user click events.
     */
    public UserAdapter(List<User> userList, OnUserClickListener onUserClickListener) {
        this.userList = userList;
        this.onUserClickListener = onUserClickListener;
    }

    /**
     * ViewHolder class for representing each user item.
     */
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public ImageView imageViewAvatar;

        public UserViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);
        }
    }

    /**
     * Called when RecyclerView needs a new ViewHolder for a user item.
     *
     * @param parent   The ViewGroup into which the new view will be added.
     * @param viewType The view type of the new view.
     * @return A new instance of UserViewHolder.
     */
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    /**
     * Called to bind data to the view for a specific position in the RecyclerView.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the item.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textViewName.setText(user.getName());
        // Get the user's avatar storage path
        String avatarPath = user.getAvatar();

        // Get a reference to the Firebase Storage for the avatar
        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child(avatarPath);

        // Asynchronously get the download URL for the avatar
        storageRef.getDownloadUrl().addOnSuccessListener(uri -> {
            String avatarUrl = uri.toString();

            // Load the avatar into the ImageView using Glide
        Glide.with(holder.itemView.getContext())
                .load(avatarUrl)
                .placeholder(R.drawable.ic_avatar_placeholder)
                .error(R.drawable.ic_avatar_error)
                .into(holder.imageViewAvatar);
        }).addOnFailureListener(exception -> {
            // Log an error if the download URL could not be retrieved
            Log.e("UserAdapter", "Failed to get download URL: " + exception.getMessage());
            // Set a default error avatar if loading fails
            holder.imageViewAvatar.setImageResource(R.drawable.ic_avatar_error);
        });
        holder.itemView.setOnClickListener(v -> onUserClickListener.onUserClick(user));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public interface OnUserClickListener {
        void onUserClick(User user);
    }
}

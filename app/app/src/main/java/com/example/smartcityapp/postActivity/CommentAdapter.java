package com.example.smartcityapp.postActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcityapp.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
/**
 * This class is responsible for adapting the list of comments to be displayed
 * in a RecyclerView. It binds comment data (e.g., user name, avatar, comment text)
 * to the appropriate views in each comment item.
 *
 * @author Xuefei Luan (u7604123)
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private List<CommentModel> commentList;
    public CommentAdapter(List<CommentModel> commentList) {
        this.commentList = commentList;
    }


    /**
     * This method is called when the RecyclerView needs a new ViewHolder to represent an item.
     * It inflates the layout for the comment item.
     *
     * @param parent The parent ViewGroup.
     * @param viewType The view type of the new View.
     * @return A new CommentViewHolder that holds the View for each comment.
     */
    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each comment item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        // Get the comment at the current position
        CommentModel comment = commentList.get(position);

        // Bind the comment data to the UI elements
        holder.commentUserName.setText(comment.getUser());
        holder.commentText.setText(comment.getComment());

        // Load the user's avatar with Glide (or any image loading library)
        Glide.with(holder.itemView.getContext()).load(comment.getAvatar()).into(holder.commentAvatar);
    }


    @Override
    public int getItemCount() {
        return commentList.size(); // Return the total number of comments
    }


    // ViewHolder class to hold the views for each comment item
    static class CommentViewHolder extends RecyclerView.ViewHolder {
        ImageView commentAvatar;
        TextView commentUserName, commentText;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize the views for each comment item
            commentAvatar = itemView.findViewById(R.id.avatar);
            commentUserName = itemView.findViewById(R.id.user);
            commentText = itemView.findViewById(R.id.otherComments);
             }
    }
}

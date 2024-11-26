package com.example.smartcityapp.postActivity;
/**
 * This class represents the data model for a comment. It contains information
 * about the user who made the comment, their avatar URL, and the comment text itself.
 * @author Xuefei Luan (u7604123)
 */
public class CommentModel {
    private String user;
    private String avatar;
    private String comment;

    // Default constructor required for calls to DataSnapshot.getValue(CommentModel.class)
    public CommentModel() {
    }


    public CommentModel(String user, String avatar, String comment) {
        this.user = user;
        this.avatar = avatar;
        this.comment = comment;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}

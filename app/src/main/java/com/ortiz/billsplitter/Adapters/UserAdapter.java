package com.ortiz.billsplitter.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ortiz.billsplitter.Listeners.SelectListener;
import com.ortiz.billsplitter.Models.User;
import com.ortiz.billsplitter.R;
import com.ortiz.billsplitter.Service.UserService;
import com.ortiz.billsplitter.Service.UserServiceImpl;
import com.ortiz.billsplitter.ViewHolders.UsersViewHolder;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UsersViewHolder>
{

    private Context context;
    private List<User> users;
    private SelectListener listener;
    private UserService userService;

    public UserAdapter(Context context, List<User> users, SelectListener listener, UserService userService)
    {
        this.context = context;
        this.users = users;
        this.listener = listener;
        this.userService = userService;
    }
    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        context = parent.getContext();
        return new UsersViewHolder(LayoutInflater.from(context).
                inflate(R.layout.rv_users_user_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position)
    {
        holder.tvUsersUserName.setText(users.get(position).getName());
        holder.itemView.setOnClickListener(view -> {
            RecyclerView recyclerView = userService.fetchRecyclerView();
            if (recyclerView == null)
            {
                Log.e("RecyclerView", "The recycler view in the onClick is empty.");
                return;
            }
            User clickedUser = users.get(holder.getAdapterPosition());
            listener.onItemClicked(clickedUser);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}

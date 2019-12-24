package kz.mobile.listapplication.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import org.w3c.dom.Text;

import java.util.List;

import kz.mobile.listapplication.R;
import kz.mobile.listapplication.RetroPhoto;
import kz.mobile.listapplication.User;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private ImageView avatar;
    private TextView fullName;
    private TextView phone;
    private TextView email;
    private TextView username;
    private TextView website;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        avatar = view.findViewById(R.id.avatar);
        fullName = view.findViewById(R.id.fullName);
        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        website = view.findViewById(R.id.website);
        notificationsViewModel.getData();
        notificationsViewModel.liveData.observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                setData(user);
            }
        });
    }

    public void setData(User user) {
        this.fullName.setText(user.getName());
        this.username.setText(user.getUsername());
        this.email.setText(user.getEmail());
        this.phone.setText(user.getPhone());
        this.website.setText(user.getWebsite());
    }
}
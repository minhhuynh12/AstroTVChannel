package Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.astro.astrotechnology.R;

/**
 * Created by imac on 11/9/17.
 */

public class DetailChannelFragment extends Fragment {
    public DetailChannel{

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_channel, container , false );

        return view;
    }
}

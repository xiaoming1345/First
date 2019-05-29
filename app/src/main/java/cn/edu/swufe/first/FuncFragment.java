package cn.edu.swufe.first;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FuncFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frame_func,container);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        TextView tv = (TextView)getView().findViewById(R.id.funcTextView1);
        tv.setText("建筑是建筑物与构筑物的总称，是人们为了满足社会生活需要，利用所掌握的物质技术手段，并运用一定的科学规律、风水理念和美学法则创造的人工环境。");
    }
}

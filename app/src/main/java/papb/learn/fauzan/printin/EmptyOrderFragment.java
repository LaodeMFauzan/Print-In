package papb.learn.fauzan.printin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class EmptyOrderFragment extends Fragment implements View.OnClickListener {

    private Button btn_buat_order;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(R.layout.fragment_empty_order, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_empty_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        btn_buat_order = view.findViewById(R.id.btn_buat_order);
        btn_buat_order.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_buat_order:
                Intent toUploadFile = new Intent(this.getContext(),UploadFileActivity.class);
                startActivity(toUploadFile);
        }
    }
}

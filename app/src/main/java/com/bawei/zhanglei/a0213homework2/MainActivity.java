package com.bawei.zhanglei.a0213homework2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.zhanglei.a0213homework2.butterknife.BindView;
import com.bawei.zhanglei.a0213homework2.butterknife.ButterKnife;
import com.bawei.zhanglei.a0213homework2.butterknife.ContentView;
import com.bawei.zhanglei.a0213homework2.butterknife.DraweeViewAnnotation;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.simp_view)
    SimpleDraweeView simp_view;
    @BindView(R.id.yuanjiao)
    Button yuanjiao;
    @BindView(R.id.yuanxing)
    Button yuanxing;
    @BindView(R.id.bili)
    Button bili;
    @BindView(R.id.jianjin)
    Button jianjin;
    @BindView(R.id.zhujie)
    Button zhujie;
    @BindView(R.id.fanshe)
    Button fanshe;

    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        uri = Uri.parse("http://img1.imgtn.bdimg.com/it/u=2725262009,4290107754&fm=26&gp=0.jpg");
        simp_view.setImageURI(uri);
        yuanjiao.setOnClickListener(this);
        yuanxing.setOnClickListener(this);
        bili.setOnClickListener(this);
        jianjin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yuanjiao:
                uri = Uri.parse("http://img1.imgtn.bdimg.com/it/u=2725262009,4290107754&fm=26&gp=0.jpg");
                simp_view.setImageURI(uri);
                RoundingParams radiusRoundingParams = RoundingParams.fromCornersRadius(5f);
                radiusRoundingParams.setRoundAsCircle(false);
                radiusRoundingParams.setCornersRadius(7f);
                simp_view.getHierarchy().setRoundingParams(radiusRoundingParams);
                break;
            case R.id.yuanxing:
                RoundingParams circleRoundingParams = RoundingParams.fromCornersRadius(5f);
                circleRoundingParams.setRoundAsCircle(true);
                simp_view.getHierarchy().setRoundingParams(circleRoundingParams);
                break;
            case R.id.bili:
                simp_view.setAspectRatio(2.71f);
                break;
            case R.id.jianjin:
                AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                        .setAutoPlayAnimations(true)
                        .setUri(Uri.parse("http://img.soogif.com/wKPS4WyAImkZ692DUvTsodBXfuKJs6er.gif"))
                        .build();
                simp_view.setController(build);
                break;
            case R.id.zhujie:

                break;
            case R.id.fanshe:
                break;
        }
    }
}

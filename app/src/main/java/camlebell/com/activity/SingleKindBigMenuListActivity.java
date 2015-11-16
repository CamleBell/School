package camlebell.com.activity;

import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import camlebell.com.Adapter.SingleKindMenusAdapter;
import camlebell.com.base.ToolbarBaseActivity;
import camlebell.com.fragment.DrawHomeFragment;
import camlebell.com.manager.HttpManager;
import camlebell.com.model.DeviceInfo;
import camlebell.com.model.DishInfo;
import camlebell.com.model.ResultInfo;
import camlebell.com.myapplication.R;
import cn.yoho.yohobase.net.AbstractResponseListener;

/**
 * @author sunyan
 * 单一种类菜单详细列表
 */
public class SingleKindBigMenuListActivity extends ToolbarBaseActivity implements DrawHomeFragment.OnHomeFragmentInteractionListener {
    public DisplayMetrics dm;
    private SingleKindMenusAdapter singleKindMenusAdapter;
    private ListView vSingleMenuListView;
    private ArrayList<DishInfo> mDishInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_single_big_menus_list;
    }

    @Override
    protected void findViews() {
        vSingleMenuListView = findView(R.id.single_menus_list_layout);
    }

    @Override
    protected void iniData() {
        setTitle("大荤");
        DishInfo workOne = new DishInfo("12315","红烧肉","大荤");
        DishInfo workTwo = new DishInfo("12315","红烧排骨","大荤");
        DishInfo workThree = new DishInfo("12315","土豆烧鸡","大荤");
        DishInfo workFour = new DishInfo("12315","菇香小炒肉","大荤");
        DishInfo workFive = new DishInfo("12315","酱爆肉丁","大荤");
        DishInfo workSix = new DishInfo("12315","香菇鸡块","大荤");
        DishInfo workEight = new DishInfo("12315","土豆烩牛肉","大荤");
        DishInfo workNine = new DishInfo("12315","肉丝豆腐","大荤");
        DishInfo workTen = new DishInfo("12315","芹菜炒肉","大荤");
        mDishInfoList = new ArrayList<>();
        mDishInfoList.add(workOne);
        mDishInfoList.add(workTwo);
        mDishInfoList.add(workThree);
        mDishInfoList.add(workFour);
        mDishInfoList.add(workFive);
        mDishInfoList.add(workSix);
        mDishInfoList.add(workEight);
        mDishInfoList.add(workNine);
        mDishInfoList.add(workTen);

        singleKindMenusAdapter = new SingleKindMenusAdapter(SingleKindBigMenuListActivity.this, mDishInfoList);
        vSingleMenuListView.setAdapter(singleKindMenusAdapter);
    }

    @Override
    protected void setListener() {

    }


    @Override
    public void onHomeFragmentInteraction(Uri uri) {

    }

    /**
     * 设备型号列表
     */
    private void getDishList(String dishTypeId) {

        HttpManager.getDishInfo(dishTypeId, new AbstractResponseListener<ResultInfo<DishInfo>>() {
            @Override
            public void onResponseStart() {
            }

            @Override
            public void onResponseSuccess(ResultInfo<DishInfo> message) {
                super.onResponseSuccess(message);

            }

            @Override
            public void onResponseFailed(String reason) {
                Toast.makeText(SingleKindBigMenuListActivity.this, reason, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

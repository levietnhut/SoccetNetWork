package com.example.nhutdu.soccernetwork;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.lvn.soccernetwork.fragments.FragmentNews;
import com.lvn.soccernetwork.fragments.FragmentMaps;
import com.lvn.soccernetwork.fragments.FragmentFields;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setViewPager(viewPager);

        tabLayout = (TabLayout ) findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(viewPager);




    }
    public void setViewPager(ViewPager v){
        ViewpagerAdpater adpater = new ViewpagerAdpater(getSupportFragmentManager());
        adpater.addFragment(new FragmentNews(),"ONE");
        adpater.addFragment(new FragmentFields(),"TWO");
        adpater.addFragment(new FragmentMaps(),"THREE");

        v.setAdapter(adpater);
    }

    class ViewpagerAdpater extends FragmentPagerAdapter{
        List<Fragment> mListFragment = new ArrayList<>();
        List<String> mListTitleFrament = new ArrayList<>();

        public ViewpagerAdpater(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return mListFragment.get(position);
        }

        public void addFragment(Fragment fragment,String title){
            mListFragment.add(fragment);
            mListTitleFrament.add(title);
        }

        @Override
        public int getCount() {
            return mListFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mListTitleFrament.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

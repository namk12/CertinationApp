package pls.certination.com.Pls.Job_portal;

/**
 * Created by Kulwinder Singh on 8/20/2016.
 */


        import android.animation.ObjectAnimator;
        import android.content.Context;
        import android.content.Intent;
        import android.support.design.widget.AppBarLayout;
        import android.support.design.widget.TabLayout;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;
        import android.support.v4.content.ContextCompat;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;

        import pls.certination.com.certination.R;

public class Job_portal extends AppCompatActivity  implements AppBarLayout.OnOffsetChangedListener {

    private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
    private boolean mIsAvatarShown = true;

    private ImageView mProfileImage;
    private int mMaxScrollSize;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_job_portal);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.materialup_tabs);
        ViewPager viewPager  = (ViewPager) findViewById(R.id.materialup_viewpager);

        viewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    public static void start(Context c) {
        c.startActivity(new Intent(c, Job_portal.class));
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int percentage = (Math.abs(i)) * 100 / mMaxScrollSize;

//		if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
//			mIsAvatarShown = false;
//			mProfileImage.animate().scaleY(0).scaleX(0).setDuration(200).start();
//		}

        if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
            mIsAvatarShown = true;

            mProfileImage.animate()
                    .scaleY(1).scaleX(1)
                    .start();
        }
    }

    public void onCreateSearch(View view) {
        Intent i = new Intent(Job_portal.this,Search.class);
        startActivity(i);
    }




    class TabsAdapter extends FragmentPagerAdapter {
        public TabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int i) {
            switch(i) {
                case 0: return new Recents();
                case 1: return new Applied();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0: return "RECENTS";
                case 1: return "APPLIED";

            }
            return null;
        }
    }

}

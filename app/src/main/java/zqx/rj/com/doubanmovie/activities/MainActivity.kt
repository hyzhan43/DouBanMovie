package zqx.rj.com.doubanmovie.activities

import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import zqx.rj.com.baselibrary.base.BaseActivity
import zqx.rj.com.baselibrary.base.BaseFragment
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.fragment.book.BookFragment
import zqx.rj.com.doubanmovie.fragment.movie.MovieFragment

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mMovieFragment: BaseFragment? = null
    private var mBookFragment: BaseFragment? = null

    override fun getContentViewResId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        setToolBar(toolbar, resources.getString(R.string.movie))

        //导航按钮有旋转特效
        val toggle = ActionBarDrawerToggle(
                this, mDrawerMain, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        mDrawerMain.addDrawerListener(toggle)
        toggle.syncState()

        mNavigationMain.setCheckedItem(R.id.nav_menu_movie)
        mNavigationMain.setNavigationItemSelectedListener(this)

        showMovie()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //这个是HomeAsUp按钮的id永远都是android.R.id.home
            // 复写父类
            android.R.id.home -> mDrawerMain.openDrawer(GravityCompat.START)   //将滑动菜单显示出来
        }
        return true
    }

    fun showMovie() {
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        mMovieFragment = MovieFragment()
        fragmentTransaction.add(R.id.fl_main_content, mMovieFragment)
        fragmentTransaction.commit()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        hideAllFragments(fragmentTransaction)
        when (item.itemId) {

            R.id.nav_menu_movie -> {
                setToolBar(toolbar, resources.getString(R.string.movie))
                mMovieFragment?.let {
                    fragmentTransaction.show(it)
                } ?: MovieFragment().let {
                    mMovieFragment = it
                    fragmentTransaction.add(R.id.fl_main_content, mMovieFragment)
                }
            }

            R.id.nav_menu_book -> {
                setToolBar(toolbar, resources.getString(R.string.book))
                if (mBookFragment == null) {
                    mBookFragment = BookFragment()
                    fragmentTransaction.add(R.id.fl_main_content, mBookFragment)
                } else {
                    fragmentTransaction.show(mBookFragment)
                }
            }
        }

        fragmentTransaction.commit()
        mDrawerMain.closeDrawers()
        return true
    }

    private fun hideAllFragments(fragmentTransaction: FragmentTransaction) {
        mMovieFragment?.let { fragmentTransaction.hide(it) }
        mBookFragment?.let { fragmentTransaction.hide(it) }
    }
}

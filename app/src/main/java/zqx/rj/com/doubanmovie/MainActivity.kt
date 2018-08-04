package zqx.rj.com.doubanmovie

import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import zqx.rj.com.baselibrary.base.BaseActivity
import zqx.rj.com.doubanmovie.fragment.MovieFragment

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun getContentViewResId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        setToolBar(resources.getString(R.string.movie))

        //导航按钮有旋转特效
        val toggle = ActionBarDrawerToggle(
                this, drawerMain, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerMain.addDrawerListener(toggle)
        toggle.syncState()

        navigationMain.setCheckedItem(R.id.nav_menu_movie)
        navigationMain.setNavigationItemSelectedListener(this)

        showMovie()
    }

    fun showMovie(){
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fl_main_content, MovieFragment())
        fragmentTransaction.commit()
    }

    /**
     *  设置 toolbar 标题
     */
    fun setToolBar(title: String){
        toolbar.setTitle(title)
        setSupportActionBar(toolbar)
        val supportActionBar = supportActionBar

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        return true
    }
}

package com.brioal.lzuwelcome.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.brioal.baselib.util.klog.KLog;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.base.LzuBaseActivity;
import com.brioal.lzuwelcome.data.DataLoader;
import com.brioal.lzuwelcome.entity.User;
import com.brioal.net.entity.APIData;
import com.brioal.net.operator.APIRequest;
import com.brioal.net.operator.DefaultThreadPool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends LzuBaseActivity {

    @Bind(R.id.web_login)
    WebView mWebLogin;
    @Bind(R.id.login_toolbar)
    Toolbar mToolbar;
    private String mCookies = "";
    private String mLoginUrl = "http://jwk.lzu.edu.cn/academic/index.jsp";
    private String mUserInfoUrl = "http://jwk.lzu.edu.cn/academic/showPersonalInfo.do";
    private ProgressDialog mProgressDialog;

    @Override
    public void initVar() {
        Explode explode = new Explode();
        explode.setDuration(500);
        explode.setInterpolator(new AccelerateDecelerateInterpolator());
        getWindow().setEnterTransition(explode);
        getWindow().setExitTransition(explode);

    }


    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);
        initToolBar();
        initWebView();
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initWebView() {
        mWebLogin.getSettings().setJavaScriptEnabled(true);
        mWebLogin.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }

            @Override
            public void onPageFinished(final WebView view, String url) {
                if (url.startsWith("http://jwk.lzu.edu.cn/academic/index_new.jsp")) {
                    CookieManager cookieManager = CookieManager.getInstance();
                    mCookies = cookieManager.getCookie(url);
                    KLog.i(mCookies);
                    if (!mCookies.isEmpty()) {
                        mProgressDialog = new ProgressDialog(mContext);
                        mProgressDialog.setTitle("拉取信息中，请稍候。。。");
                        mProgressDialog.setMessage("正在获取个人信息");
                        mProgressDialog.setCancelable(false);
                        mProgressDialog.show();
                        getuserInfo();
                    }

                } else {
                    view.loadUrl("javascript:function myFunction(){document.getElementsByName(\"j_username\")[0].value='320130937631';document.getElementsByName(\"j_password\")[0].value='142536';}");
                    view.loadUrl("javascript:myFunction()");
                }
                super.onPageFinished(view, url);
            }


        });
        mWebLogin.loadUrl(mLoginUrl);
    }

    public void getuserInfo() {
        APIRequest.type = "utf-8";
        APIData data = new APIData("", 0, true, mUserInfoUrl);
        APIRequest request = new APIRequest(null, data, new LzuRequestCallBack() {
            @Override
            public void onSuccess(String content, String apiUrl, long expries) {
                KLog.i(content);
                parserHtml(content);
            }
        }) {
            @Override
            protected void HttpConnctionSetUp(HttpURLConnection connection) {
                connection.setRequestProperty("Cookie", mCookies);
            }
        };
        DefaultThreadPool.makeRequest(request);
    }

    public void parserHtml(String content) {
        Document doc = Jsoup.parse(content);
        Elements tables = doc.select("table");
        Elements trs = null;
        trs = tables.get(0).select("tr");
        ArrayList<String> infos = new ArrayList<>();
        for (int i = 0; i < trs.size(); i++) {
            Elements tds = trs.get(i).select("td");
            for (int j = 0; j < tds.size(); j++) {
                String text = tds.get(j).text();
                if (!text.isEmpty()) {
                    infos.add(text);
                }
                System.out.println(text);
            }
        }
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        User user = new User();
        user.setID(infos.get(0));
        user.setName(infos.get(1));
        user.setYuanxi(infos.get(2));
        user.setZhuanye(infos.get(3));
        user.setNianji(infos.get(4));
        user.setBanji(infos.get(6));
        DataLoader.newInstance(mContext).saveUserInfoLocal(user); //保存到本地
        setResult(RESULT_OK);
        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initTheme() {

    }

    @Override
    public void loadDataLocal() {

    }

    @Override
    public void loadDataNet() {

    }

    @Override
    public void setView() {

    }

    @Override
    public void updateView() {

    }

    @Override
    public void saveDataLocal() {

    }

    public static void enterActivity(Activity context) {
        context.getWindow().setEnterTransition(null);
        context.getWindow().setExitTransition(null);
        Intent intent = new Intent(context, LoginActivity.class);
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(context);
        context.startActivityForResult(intent, 0, compat.toBundle());

    }
}

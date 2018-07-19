//
//  TwitterSigninPackage.java
//  TwitterSignin
//
//  Created by Justin Nguyen on 22/5/16.
//  Copyright © 2016 Golden Owl. All rights reserved.
//

package com.goldenowl.twittersignin;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwitterSigninPackage implements ReactPackage {
    private TwitterSigninModule twitterModule = null;
    private static TwitterSigninPackage instance = null;
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        twitterModule = new TwitterSigninModule(reactApplicationContext);
        if (instance == null) {
            instance = this;
        }
        return Arrays.<NativeModule>asList(twitterModule);
    }

//    @Override
//    public List<Class<? extends JavaScriptModule>> createJSModules() {
//        return Collections.emptyList();
//    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
    public static TwitterSigninPackage getInstance() {
        if (instance == null) {
            instance = new TwitterSigninPackage();
        }

        return instance;
    }

    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        twitterModule.onActivityResult(activity, requestCode, resultCode, data);
    }
}

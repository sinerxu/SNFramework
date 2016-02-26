# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/xuhui/Documents/SDK/android/xamarin-android-sdk-24.0.2/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }
-dontwarn org.apache.http.**
-keep class org.apache.http.** { *; }
-dontwarn com.sina.weibo.**
-keep class com.sina.weibo.** { *; }
-dontwarn com.google.gson.jpush.**
-keep class com.google.gson.jpush.** { *; }
-dontwarn com.loopj.android.http.**
-keep class com.loopj.android.http.** { *; }
-dontwarn com.mob.**
-keep class com.mob.** { *; }
-dontwarn cn.sharesdk.**
-keep class cn.sharesdk.** { *; }
-dontwarn de.greenrobot.dao.**
-keep class de.greenrobot.dao.** { *; }
-dontwarn com.jeremyfeinstein.slidingmenu.**
-keep class com.jeremyfeinstein.slidingmenu.** { *; }
-keepattributes SourceFile,LineNumberTable
-keepattributes *Annotation*
-keepattributes Signature
-dontwarn **.R.**
-keep class **.R.** {*;}
-dontwarn com.sn.**
-keep class com.sn.** { *; }
package com.snlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * Created by xuhui on 16/8/2.
 */
public class ProjectMain {


    //region config
    static final String APPNAME = "贝乐Yeah";
    static final String PACKAGENAME = "com.jiaming.beileyeah";
    static final String PATH = "/Users/xuhui/Documents/Work/AndroidStudio_Workspace/beileyeah_android";
    static final String TEMPPATH = "/Users/xuhui/Documents/Work/AndroidStudio_Workspace/SNFramework/buildproject/src/main/java/com/snlib/temps";
    //endregion

    public static void main(String[] args) {

        String path = PATH;
        String packageName = PACKAGENAME;
        String codePath = getCodePath(path);
        String tempPath = TEMPPATH;

        //region 创建 annotation
        String annotationPath = codePath + "/annotation";
        String apiMappingTemp = tempPath + "/annotation/ApiMapping.tem";
        String apiMappingFile = annotationPath + "/ApiMapping.java";
        String bodyappingTemp = tempPath + "/annotation/BodyMapping.tem";
        String bodyMappingFile = annotationPath + "/BodyMapping.java";
        createDirectory(annotationPath);
        createTempFile(apiMappingTemp, apiMappingFile);
        createTempFile(bodyappingTemp, bodyMappingFile);
        //endregion

        //region 创建 controllers
        String controllersPath = codePath + "/" + "controllers";
        createDirectory(controllersPath);
        //region 创建activitys
        String activitysPath = controllersPath + "/" + "activitys";
        String baseActivityTemp = tempPath + "/activitys/BaseActivity.tem";
        String baseActivityFile = activitysPath + "/BaseActivity.java";
        createDirectory(activitysPath);
        createTempFile(baseActivityTemp, baseActivityFile);
        createTempFile(tempPath + "/activitys/WebBrowserActivity.tem", activitysPath + "/WebBrowserActivity.java");
        createTempFile(tempPath + "/activitys/LaunchActivity.tem", activitysPath + "/LaunchActivity.java");
        createTempFile(tempPath + "/activitys/LoginActivity.tem", activitysPath + "/LoginActivity.java");
        //endregion
        //region 创建fragments
        String fragmentsPath = controllersPath + "/" + "fragments";
        String baseFragmentTemp = tempPath + "/fragments/BaseFragment.tem";
        String baseFragmentFile = fragmentsPath + "/BaseFragment.java";
        createDirectory(fragmentsPath);
        createTempFile(baseFragmentTemp, baseFragmentFile);
        //endregion
        //region 创建injects
        String injectsPath = controllersPath + "/" + "injects";
        String baseInjectsTemp = tempPath + "/injects/BaseInject.tem";
        String baseInjectsFile = injectsPath + "/BaseInject.java";
        createDirectory(injectsPath);
        createTempFile(baseInjectsTemp, baseInjectsFile);
        //endregion
        //endregion

        //region 创建 cores
        String coresPath = codePath + "/" + "cores";
        createDirectory(coresPath);
        //region 创建configs
        String configsPath = coresPath + "/" + "configs";
        createDirectory(configsPath);
        createTempFile(tempPath + "/configs/AppConfig.tem", configsPath + "/AppConfig.java");
        createTempFile(tempPath + "/configs/AppPropConfig.tem", configsPath + "/AppPropConfig.java");
        //endregion
        //endregion

        //region 创建 dialogs
        String dialogsPath = codePath + "/" + "dialogs";
        String baseDialogTemp = tempPath + "/dialogs/BaseDialog.tem";
        String baseDialogFile = dialogsPath + "/BaseDialog.java";
        createDirectory(dialogsPath);
        createTempFile(baseDialogTemp, baseDialogFile);
        //endregion

        //region 创建 models
        String modelsPath = codePath + "/" + "models";
        String baseModelTemp = tempPath + "/models/BaseModel.tem";
        String baseModelFile = modelsPath + "/BaseModel.java";
        createDirectory(modelsPath);
        createTempFile(baseModelTemp, baseModelFile);
        createTempFile(tempPath + "/models/UserModel.tem", modelsPath + "/UserModel.java");
        //endregion

        //region 创建 widgets
        String widgetsPath = codePath + "/" + "widgets";
        createDirectory(widgetsPath);
        //endregion

        //region创建 managers
        String managersPath = codePath + "/" + "managers";
        createDirectory(managersPath);
        createTempFile(tempPath + "/managers/BaseManager.tem", managersPath + "/BaseManager.java");
        createTempFile(tempPath + "/managers/ManagerFactory.tem", managersPath + "/ManagerFactory.java");
        //region 创建app
        String appPath = managersPath + "/" + "app";
        String appImpls = managersPath + "/" + "app/impls";
        String appInterfaces = managersPath + "/" + "app/interfaces";
        createDirectory(appPath);
        createDirectory(appImpls);
        createDirectory(appInterfaces);

        createTempFile(tempPath + "/app/interfaces/IAppEventListenerManager.tem", appInterfaces + "/IAppEventListenerManager.java");
        createTempFile(tempPath + "/app/interfaces/IAppManager.tem", appInterfaces + "/IAppManager.java");
        createTempFile(tempPath + "/app/interfaces/IAppPropManager.tem", appInterfaces + "/IAppPropManager.java");
        createTempFile(tempPath + "/app/interfaces/IIntentManager.tem", appInterfaces + "/IIntentManager.java");
        createTempFile(tempPath + "/app/interfaces/IJavaScriptManager.tem", appInterfaces + "/IJavaScriptManager.java");
        createTempFile(tempPath + "/app/impls/AppEventListenerManager.tem", appImpls + "/AppEventListenerManager.java");
        createTempFile(tempPath + "/app/impls/AppManager.tem", appImpls + "/AppManager.java");
        createTempFile(tempPath + "/app/impls/AppPropManager.tem", appImpls + "/AppPropManager.java");
        createTempFile(tempPath + "/app/impls/IntentManager.tem", appImpls + "/IntentManager.java");
        createTempFile(tempPath + "/app/impls/JavaScriptManager.tem", appImpls + "/JavaScriptManager.java");

        //endregion
        //region 创建async
        String asyncPath = managersPath + "/" + "async";
        String asyncListeners = managersPath + "/" + "async/listeners";
        createDirectory(asyncPath);
        createDirectory(asyncListeners);
        createTempFile(tempPath + "/async/AsyncManagerResult.tem", asyncPath + "/AsyncManagerResult.java");
        createTempFile(tempPath + "/async/listeners/AsyncManagerListener.tem", asyncListeners + "/AsyncManagerListener.java");
        //endregion
        //region 创建main
        String mainPath = managersPath + "/" + "main";
        String mainImpls = managersPath + "/" + "main/impls";
        String mainInterfaces = managersPath + "/" + "main/interfaces";
        createDirectory(mainPath);
        createDirectory(mainImpls);
        createDirectory(mainInterfaces);
        //endregion
        //endregion

        //region 创建资源文件
        //region values
        String resTempPath = tempPath + "/values";
        String resPath = path + "/app/src/main/res/values";
        createTempFile(resTempPath + "/colors.xml", resPath + "/colors.xml");
        createTempFile(resTempPath + "/dimen.xml", resPath + "/dimen.xml");
        createTempFile(resTempPath + "/strings.xml", resPath + "/strings.xml");
        createTempFile(resTempPath + "/styles.xml", resPath + "/styles.xml");
        //endregion

        //region drawable
        String drawableTempPath = tempPath + "/drawable";
        String drawablePath = path + "/app/src/main/res/drawable";
        createTempFile(drawableTempPath + "/progressbar.xml", drawablePath + "/progressbar.xml");
        copyResourceFile(drawableTempPath + "/launch.png", drawablePath + "/launch.png");
        copyResourceFile(drawableTempPath + "/icon_close.png", drawablePath + "/icon_close.png");
        //endregion

        //region manifest
        String manifestPath = path + "/app/src/main";
        createTempFile(tempPath + "/AndroidManifest.xml", manifestPath + "/AndroidManifest.xml");
        //endregion

        //region layout
        String layoutTempPath = tempPath + "/layout";
        String layoutPath = path + "/app/src/main/res/layout";
        createTempFile(layoutTempPath + "/actvity_web_browser.xml", layoutPath + "/actvity_web_browser.xml");
        createTempFile(layoutTempPath + "/activity_login.xml", layoutPath + "/activity_login.xml");
        //endregion
        //endregion


        createTempFile(tempPath + "/MainApplication.tem", codePath + "/MainApplication.java");
    }


    static String getCodePath(String path) {
        String codePath = path + "/app/src/main/java/";
        String[] pns = PACKAGENAME.split("\\.");
        for (String i : pns) {
            codePath = codePath + "/" + i;
        }
        return codePath;

    }

    /**
     * 创建目录
     *
     * @param path
     */
    static void createDirectory(String path) {
        File annotationPathFile = new File(path);
        annotationPathFile.mkdirs();
        System.out.print(path);
    }


    static void createTempFile(String filename, String toFileName) {
        String content = fileRead(filename);
        content = content.replace("{packageName}", PACKAGENAME);
        content = content.replace("{appname}", APPNAME);
        fileWrite(toFileName, content);
    }

    static void copyResourceFile(String filename, String toFileName) {

        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(filename);
            if (oldfile.exists()) {
                InputStream inStream = new FileInputStream(filename);
                FileOutputStream fs = new FileOutputStream(toFileName);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("error  ");
            e.printStackTrace();
        }

    }

    static String fileRead(String strFilePath) {

        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                return null;
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            byte[] read_bytes = new byte[(int) file.length()];
            raf.readFully(read_bytes);
            String content = new String(read_bytes);
            raf.close();
            return content;

        } catch (Exception e) {
            return null;
        }
    }


    static boolean fileWrite(String strFilePath, String content) {

        // 每次写入时，都换行写
        String strContent = content + "\r\n";
        try {
            File file = new File(strFilePath);
            if (file.exists()) {
                file.delete();
            }
            file.getParentFile().mkdirs();
            file.createNewFile();
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
            return true;
        } catch (Exception e) {
            return false;
        }


    }
}
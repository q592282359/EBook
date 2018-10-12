package com.tdwd.ebook.util;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.DownloadFileListener;

/**
 * @author :Leew
 * @date ：2018/10/12 on 16:40
 * Description:
 */
public class BmobFileUtils {

    public static  void setimg(Context context,BmobFile bmobFile, ImageView img){
       if(bmobFile==null){
           return;
       }
       bmobFile.download(new DownloadFileListener() {
           @Override
           public void done(String s, BmobException e) {
               if(e == null){
                   Glide.with(context).load(s).into(img);
               }else{
                   ToastUtils.showToast("图片下载失败");
               }
           }

           @Override
           public void onProgress(Integer integer, long l) {

           }
       });
    }

    public static void setimgonglide(Context context,BmobFile bmobFile,ImageView img){
        if(bmobFile==null){
            return;
        }
        Glide.with(context).load(bmobFile.getFileUrl()).into(img);
    }
}

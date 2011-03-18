package org.goodev.home;

import android.app.Activity;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class Home extends Activity {
    /** Called when the activity is first created.  */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        WallpaperManager wpm = (WallpaperManager)getSystemService(WALLPAPER_SERVICE);
        
        Display display = getWindowManager().getDefaultDisplay();
        boolean isPortrait = display.getWidth() < display.getHeight();

        final int width = isPortrait ? display.getWidth() : display.getHeight();
        final int height = isPortrait ? display.getHeight() : display.getWidth();
        wpm.suggestDesiredDimensions(480 * 2, 800);
        
        int minHeight = wpm.getDesiredMinimumHeight();
        int minWidth = wpm.getDesiredMinimumWidth();
        Drawable cd = wpm.getDrawable();
        Drawable cfd = wpm.getFastDrawable();
        WallpaperInfo wi = wpm.getWallpaperInfo();
        
        
        System.out.println((wi==null?"wi==null":wi.toString()));
        System.out.println("minHeight:"+minHeight+" minWidth:"+minWidth);
        System.out.println("cd: width="+cd.getMinimumWidth()+" height="+cd.getMinimumHeight());
        System.out.println("cfd: width="+cfd.getMinimumWidth()+" height="+cfd.getMinimumHeight());
        System.out.println("cfd: Iwidth="+cfd.getIntrinsicWidth()+" Iheight="+cfd.getIntrinsicHeight());
        
        float left =   (cfd.getMinimumWidth() * 0.14285715f);
        Rect rect = cfd.getBounds();
        System.out.println("Cfd rect d: "+rect);
//        cfd.setBounds(left, 0, left+width, minHeight);
       
        
        final int dw = width;
        final int dh = height;
        final int bw = cfd.getIntrinsicWidth();
        final int bh = cfd.getIntrinsicHeight();
        final int availw = dw-bw;
        final int availh = dh-bh;
        float mXOffset =  0.14285715f;
        float mYOffset =   0f;
        int xPixels = availw < 0 ? (int)(availw*mXOffset+.5f) : (availw/2);
        int yPixels = availh < 0 ? (int)(availh*mYOffset+.5f) : (availh/2);

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        
        int diff = cfd.getIntrinsicWidth() - width;
         
        canvas.translate(xPixels, yPixels);
//        if (availw<0 || availh<0) {
//        	canvas.save(Canvas.CLIP_SAVE_FLAG);
//        	canvas.clipRect(0, 0, bw, bh, Op.DIFFERENCE);
//        	canvas.drawColor(0xff000000);
//        	canvas.restore();
//        }
        if (cfd != null) {
            cfd.draw(canvas);
        }
        
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(bitmap);
        System.out.println();
    }
}
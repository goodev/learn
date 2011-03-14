package com.baidu.home.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.graphics.Rect;
import android.util.Log;


public class FolderLayer extends FrameLayout/* implements DropTarget*/{

//	private Workspace mFolder;
	private FolderCloseRunnable mFolderClose = new FolderCloseRunnable();
	private final int CLOSE_DELAY = 1500;
//	private Launcher mLauncher;
	private Rect mRectTemp = new Rect();
	boolean mClose = false;


    public FolderLayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    public boolean dispatchKeyEvent(KeyEvent event) {
//		return true;
//    }

//	public void setFolderSpace(Workspace s){
//		mFolder = s;
//	}
//
//	public void setLauncher(Launcher l){
//		mLauncher = l;
//	}

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//		if(mFolder != null && ev.getAction() == MotionEvent.ACTION_DOWN){
//			View v = (View)mFolder.getParent();
//			if( v != null ){
//				int x = (int)ev.getX();
//				int y = (int)ev.getY();
//				final Rect r = mRectTemp;
//				v.getHitRect(r);
//				if (!r.contains(x, y) ){
//					mLauncher.closeFolder();
//				}
//			}
//		}
		return true;
    }


	private void closeFolder(int x, int y){
//		View v = (View)mFolder.getParent();
//		if( v != null ){
//			final Rect r = mRectTemp;
//			v.getHitRect(r);
//			if (!r.contains(x, y) ){
//				mClose = true;
				postDelayed(mFolderClose,CLOSE_DELAY);
//			}
//		
//		}
	}

//    public void onDrop(DragSource source, int x, int y, int xOffset, int yOffset,
//            DragView dragView, Object dragInfo){
//		removeCallbacks(mFolderClose);
//		if( source == mFolder ){
//			mFolder.onDropCompleted(mFolder,false);
//		}else{
//			mFolder.onDrop(source,x,y,xOffset,yOffset,dragView,dragInfo);
//		}
//	}
//    
//    public void onDragEnter(DragSource source, int x, int y, int xOffset, int yOffset,
//            DragView dragView, Object dragInfo){
//		if( !mClose )
//			closeFolder(x,y);
//	}
//
//    public void onDragOver(DragSource source, int x, int y, int xOffset, int yOffset,
//            DragView dragView, Object dragInfo){
//		if(!mClose)
//		    closeFolder(x,y);
//	}
//
//    public void onDragExit(DragSource source, int x, int y, int xOffset, int yOffset,
//            DragView dragView, Object dragInfo){
//		removeCallbacks(mFolderClose);
//	}
//
//    public boolean acceptDrop(DragSource source, int x, int y, int xOffset, int yOffset,
//            DragView dragView, Object dragInfo){
//		if( mFolder != null)
//			return mFolder.acceptDrop(source,x,y,xOffset,yOffset,dragView,dragInfo);
//		return false;
//	}
//
//	public int getTargetType(){
//		return FOLDERSPACE;
//	}

	class FolderCloseRunnable implements Runnable {
		public void run() {
//			mLauncher.closeFolder();
			mClose = false;
		}
	}

}

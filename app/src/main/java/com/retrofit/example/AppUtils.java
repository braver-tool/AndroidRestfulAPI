package com.retrofit.example;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

public class AppUtils {

    /**
     * Method used to get maximum goal value
     * This method used for ClinicalStaffGraphBaseFragment.java and GraphBaseFragment.java
     *
     * @param context - Current Activity
     * @return leader profile as Bitmap
     */
    @SuppressLint("ResourceType")
    public static  Bitmap getLeaderProfile(Context context, int position) {
        try {
            @SuppressLint("Recycle") TypedArray typedArray = context.getResources().obtainTypedArray(R.array.leaderProfileArray);
            return BitmapFactory.decodeResource(context.getResources(), typedArray.getResourceId(position, 15));
        } catch (Exception e) {
            Log.d("##getLeaderProfile", "------->Utils----->" + e.getMessage());
            return BitmapFactory.decodeResource(context.getResources(), R.drawable.default_profile);

        }
    }

    public static Bitmap getCircularBitmap(Bitmap srcBitmap) {
        // Calculate the circular bitmap width with border
        int squareBitmapWidth = Math.min(srcBitmap.getWidth(), srcBitmap.getHeight());
        // Initialize a new instance of Bitmap
        Bitmap dstBitmap = Bitmap.createBitmap(
                squareBitmapWidth, // Width
                squareBitmapWidth, // Height
                Bitmap.Config.ARGB_8888 // Config
        );
        Canvas canvas = new Canvas(dstBitmap);
        // Initialize a new Paint instance
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, squareBitmapWidth, squareBitmapWidth);
        RectF rectF = new RectF(rect);
        canvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        // Calculate the left and top of copied bitmap
        float left = (squareBitmapWidth - srcBitmap.getWidth()) / 2;
        float top = (squareBitmapWidth - srcBitmap.getHeight()) / 2;
        canvas.drawBitmap(srcBitmap, left, top, paint);
        // Free the native object associated with this bitmap.
        srcBitmap.recycle();
        // Return the circular bitmap
        return dstBitmap;
    }


    // Custom method to add a border around circular bitmap
    private static Bitmap addBorderToCircularBitmap(Context context, Bitmap srcBitmap, int borderWidth) {
        // Calculate the circular bitmap width with border
        int dstBitmapWidth = srcBitmap.getWidth() + borderWidth * 2;
        // Initialize a new Bitmap to make it bordered circular bitmap
        Bitmap dstBitmap = Bitmap.createBitmap(dstBitmapWidth, dstBitmapWidth, Bitmap.Config.ARGB_8888);
        // Initialize a new Canvas instance
        Canvas canvas = new Canvas(dstBitmap);
        // Draw source bitmap to canvas
        canvas.drawBitmap(srcBitmap, borderWidth, borderWidth, null);
        // Initialize a new Paint instance to draw border
        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.gray));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(borderWidth);
        paint.setAntiAlias(true);
        canvas.drawCircle(
                canvas.getWidth() / 2, // cx
                canvas.getWidth() / 2, // cy
                canvas.getWidth() / 2 - borderWidth / 2, // Radius
                paint // Paint
        );
        // Free the native object associated with this bitmap.
        srcBitmap.recycle();
        // Return the bordered circular bitmap
        return dstBitmap;
    }
}

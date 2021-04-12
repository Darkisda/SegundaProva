package tads.eaj.ufrn.segundaprova.utils

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewClickListener(val ctx: Context, recyclerView: RecyclerView, val listener: clickListener): RecyclerView.OnItemTouchListener {

    var gestureDetector: GestureDetector

    init {
        gestureDetector = GestureDetector(ctx, object: GestureDetector.SimpleOnGestureListener(){
            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                super.onSingleTapUp(e)

                val childView = recyclerView.findChildViewUnder(e!!.x, e.y)

                if(childView != null) {
                    listener.onClick(childView, recyclerView.getChildAdapterPosition(childView))
                }

                return true
            }

            override fun onLongPress(e: MotionEvent?) {
                super.onLongPress(e)
                val childView = recyclerView.findChildViewUnder(e!!.x, e.y)
                if (childView != null ){
                    listener.onHolding(childView, recyclerView.getChildAdapterPosition(childView))
                }
            }
        })
    }

    interface clickListener {
        fun onClick(v: View, position: Int)
        fun onHolding(v: View, position: Int)
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(e)
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        TODO("Not yet implemented")
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("Not yet implemented")
    }
}
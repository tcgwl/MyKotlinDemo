package net.println.kotlin.network

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.widget.LinearLayout
import kotlin.math.abs

class HamburgerLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    interface OnDragListener {
        fun onDragReleased()
    }

    private var startX = 0
    private var startY = 0
    private var isDragging = false
    private var onDragListener: OnDragListener? = null

    private val touchSlop: Int = ViewConfiguration.get(context).scaledTouchSlop

    fun setOnDragListener(listener: OnDragListener) {
        onDragListener = listener
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                // 记录触摸点的初始位置
                startX = ev.x.toInt()
                startY = ev.y.toInt()
                isDragging = false
            }
            MotionEvent.ACTION_MOVE -> {
                // 计算水平和垂直的移动距离
                val dx = abs(ev.x.toInt() - startX)
                val dy = abs(ev.y.toInt() - startY)

                // 只有当水平移动距离大于垂直移动距离，并且大于阈值时，才拦截事件
                if (dx > dy && dx > touchSlop) {
                    isDragging = true
                    return true // 拦截事件
                }
            }
        }
        return false // 不拦截事件
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.rawX.toInt()

        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                val offsetX = x - startX
                if (offsetX > 0) {
                    translationX = offsetX.toFloat()
                }
            }
            MotionEvent.ACTION_UP -> {
                val offsetX = x - startX
                if (offsetX > 0) {
                    if (offsetX > width / 3) {
                        // 调用接口回调
                        onDragListener?.onDragReleased()
                    } else {
                        // 重置位置
//                        translationX = 0f
                        animate().translationX(0f).setDuration(300).start()
                    }
                }
            }
        }
        return true // 表明我们已经处理了触摸事件
    }
}


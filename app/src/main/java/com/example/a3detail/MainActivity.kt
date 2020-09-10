package com.example.a3detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //addLinearLayoutJava()
        /**默认情况下代码的尺寸默认为pix像素 但手机分辨率不同
         * 若手机密度为1 则对应像素是100dp
         * 若手机密度为2 则对应像素是50dp(一个点显示2个像素)
         */
        addLinearLayoutKotlin()
    }
    private fun addLinearLayoutKotlin(){
        val container=LinearLayout(this).apply {
            // 设置宽高
            layoutParams=LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT
            )
            // 设置方向
            orientation=LinearLayout.VERTICAL

            // 设置颜色
            background=getDrawable(R.color.colorBlue)
        }.also { setContentView(it) }
        //创建第一个子控件
        LinearLayout(this).apply {
            // 设置宽高
            layoutParams=LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,dp2px(100)
            )
            // 设置方向
            orientation=LinearLayout.HORIZONTAL

            // 设置颜色
            background=getDrawable(R.color.colorGreen)
            container.addView(this)
        }.apply {
            ImageView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(
                    dp2px(120),
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                setImageResource(R.drawable.a2)
                scaleType = ImageView.ScaleType.CENTER_CROP
                addView(this)
            }
            // 添加文字标题
            TextView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT
                ).apply {
                    weight=1f
                    setMargins(dp2px(10),dp2px(10),dp2px(10),dp2px(10))

                }
                text = "连咖啡“变脸”求生，新配方道阻且长"
                setTextColor(getColor(R.color.colorWhite))
                textSize=20f
                addView(this)
            }
        }
        //创建第二个子控件TextView
        TextView(this).apply {
            layoutParams=LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            ).apply {
               setMargins(dp2px(10),dp2px(10),dp2px(10),dp2px(10))
            }

            text = "9月8日，连咖啡在其公众号中表示，门店已经全部关闭，暂时也没有再开的打算。未来连咖啡发布的都会是预包装产品，微信公众号和天猫旗舰店都是主要货架，其他电商渠道也会陆续登陆。\n" +
                    "\n" +
                    "从产品形态来看，连咖啡将提供包括但绝不限于胶囊、浓缩液、冻干粉、冷萃液、瓶装咖啡等产品；从销售渠道来看，也不再局限于北上广深，将「配送范围」变成「物流范围」，消费者在天猫、便利店和加油站等更多地方都可以找到连咖啡。\n" +
                    "\n" +
                    "此外，连咖啡和中石化易捷联手的「易捷咖啡」是另一个亮点。“中国的加油站咖啡，这会是另一个全新的精彩故事。”随后，连咖啡又在公众号中透露，“我们依然想要书写中国咖啡自己的故事。虽然这并不容易，但很有意义。”"
            setTextColor(getColor(R.color.colorWhite))
            textSize=17f
            container.addView(this)
        }
    }
    // 获取屏幕密度
    fun dp2px(dp:Int):Int{
        return (resources.displayMetrics.density*dp).toInt()
    }
    private fun addLinearLayoutJava(){
        // 1.创建容器
        val linearLayout=LinearLayout(this)
        // 2.给容器设置宽高
        linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT)
        // 3.设置布局方向
        linearLayout.orientation=LinearLayout.VERTICAL
        linearLayout.background=getDrawable(R.color.colorAccent)
        // 4.添加容器到activity上
        setContentView(linearLayout)
    }
}
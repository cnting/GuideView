package easily.tech.guideview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.RelativeLayout
import android.widget.Toast
import easily.tech.guideview.lib.GuideViewBundle
import easily.tech.guideview.lib.GuideViewBundle.Direction.BOTTOM
import easily.tech.guideview.lib.GuideViewFragment
import easily.tech.guideview.lib.Utils.dp2px
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.guideview_left.view.*
import kotlinx.android.synthetic.main.guideview_right.view.*
import kotlinx.android.synthetic.main.guideview_top.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var guideViewFragment: GuideViewFragment
    private lateinit var menuMore: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val params: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(dp2px(this, 180f), WRAP_CONTENT)

        val hintViewLeft: View = View.inflate(this, R.layout.guideview_left, null)
        val hintViewTop: View = View.inflate(this, R.layout.guideview_top, null)
        val hintViewRight: View = View.inflate(this, R.layout.guideview_right, null)
        val hintViewBottom: View = View.inflate(this, R.layout.guideview_bottom, null)

        tvContent.setOnClickListener {
            Toast.makeText(this, "target view is clicked", Toast.LENGTH_SHORT).show()
        }

        hintViewLeft.tvLeftNext.setOnClickListener {
            guideViewFragment.onNext()
        }

        hintViewTop.tvTopNext.setOnClickListener {
            guideViewFragment.onNext()
        }

        hintViewRight.tvRightNext.setOnClickListener {
            guideViewFragment.onNext()
        }

        val space = dp2px(this, 10f)

        tvShow.setOnClickListener {
//            guideViewFragment = GuideViewFragment.Builder()
//                    .addGuidViewBundle(GuideViewBundle.Builder()
//                            .setTargetView(tvContent)
//                            .setHintView(hintViewLeft)
//                            .setDismissOnClicked(false)
//                            .condition(false)
//                            .setHintViewMargin(0, -160, 0, 0)
//                            .setTransparentSpace(space, space, space, space)
//                            .setOutlineType(TYPE_RECT)
//                            .setTargetViewClickable(true)
//                            .setHintViewParams(params)
//                            .setHintViewDirection(LEFT).build())
//                    .addGuidViewBundle(GuideViewBundle.Builder()
//                            .setTargetView(tvContent)
//                            .setOutlineType(TYPE_OVAL)
//                            .setHintView(hintViewTop)
//                            .setDismissOnClicked(false)
//                            .setHintViewParams(params)
//                            .setGuideViewHideListener {
//                                Toast.makeText(this, "dismissed", Toast.LENGTH_SHORT).show()
//                            }
//                            .setHintViewMargin(-dp2px(this, 55f), 0, 0, 0)
//                            .setTransparentSpace(space, space, space, space)
//                            .setHintViewDirection(TOP)
//                            .build())
//                    .addGuidViewBundle(GuideViewBundle.Builder()
//                            .setTargetView(tvContent)
//                            .setOutlineType(TYPE_OVAL)
//                            .setHintView(hintViewRight)
//                            .setDismissOnClicked(false)
//                            .setHintViewParams(params)
//                            .setHintViewMargin(0, -160, 0, 0)
//                            .setTransparentSpace(space, space, space, space)
//                            .setHintViewDirection(RIGHT)
//                            .build())
//                    .addGuidViewBundle(GuideViewBundle.Builder()
//                            .setTargetView(tvContent)
//                            .setOutlineType(TYPE_OVAL)
//                            .setHintViewParams(params)
//                            .setHintViewMargin(-dp2px(this, 55f), 0, 0, 0)
//                            .setHintView(hintViewBottom)
//                            .setTransparentSpace(space, space, space, space)
//                            .setHintViewDirection(BOTTOM)
//                            .build())
//                    .setCancelable(false)
//                    .build()
            guideViewFragment = GuideViewFragment.Builder()
                    .addGuidViewBundle(GuideViewBundle.Builder()
                            .setTargetView(menuMore.actionView)
                            .setHintView(hintViewLeft)
                            .setHintViewDirection(BOTTOM)
                            .setHintViewMargin(30,-30,30,0)
                            .build()
                    )
                    .setOnDismissListener{
                        Log.d("===>","dismiss")
                    }
                    .build()
            guideViewFragment.show(supportFragmentManager, "hit")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val flag = super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main, menu)
        menuMore = menu.findItem(R.id.menuMore)
        menuMore.setActionView(R.layout.view_menu)
        return flag
    }
}

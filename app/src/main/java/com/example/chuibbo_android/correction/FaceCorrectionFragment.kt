package com.example.chuibbo_android.correction

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.chuibbo_android.R
import com.example.chuibbo_android.download.DownloadFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.face_correction_fragment.*
import kotlinx.android.synthetic.main.main_activity.*

class FaceCorrectionFragment : Fragment() {

    @SuppressLint("ResourceAsColor")
    private fun changeView(index: Int) {
        when (index) {
            0 -> {
                activity?.supportFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.correction_contents, FaceCorrectionInsideFragment())
                }?.commit()
            }
            1 -> {
                activity?.supportFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.correction_contents, FaceCorrectionMakeupFragment())
                }?.commit()
            }
            2 -> {
                activity?.supportFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.correction_contents, FaceCorrectionDistortionFragment())
                }?.commit()
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.face_correction_fragment, container, false)

        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.correction_contents, FaceCorrectionInsideFragment())
        }?.commit()

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // this is for next button on the last page
        // btn = ImageButton(context)
        var btn: ImageButton = ImageButton(activity?.applicationContext)
        btn.setImageResource(R.drawable.ic_arrow_right)
        val l3 =
            androidx.appcompat.widget.Toolbar.LayoutParams(
                Toolbar.LayoutParams.WRAP_CONTENT,
                Toolbar.LayoutParams.WRAP_CONTENT
            )
        btn.setBackgroundColor(Color.WHITE)
        btn.layoutParams = l3
        btn.setBackground(null)
        btn.setOnClickListener {
            val transaction = activity?.supportFragmentManager!!.beginTransaction()
            transaction.replace(R.id.frameLayout, DownloadFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        activity?.toolbar!!.addView(btn)
        // This is how to set layout_gravity properties to Button
        // must be put this code after put button view on the activity
        (btn.layoutParams as androidx.appcompat.widget.Toolbar.LayoutParams)?.apply {
            this.gravity = Gravity.RIGHT
        }

        tablayout_face_correction.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                var pos = tab.getPosition()
                changeView(pos)
                // TODO: tab 선택시 폰트 크기 증가, bold, 높이 증가
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // do nothing
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // do nothing
            }
        })
    }
}
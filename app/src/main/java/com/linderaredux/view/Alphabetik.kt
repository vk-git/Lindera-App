package com.linderaredux.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.linderaredux.R

import java.util.Arrays

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Alphabetik(context: Context, attrs: AttributeSet) : RecyclerView(context, attrs) {

    private var alphabet = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#")

    private var fontSize: Float = 0.toFloat()
    private val selectedFontSize: Int = 0
    private val selectedItemColor: Int = 0
    private val selectedItemBackground: Int = 0

    private var adapter: SectionIndexAdapter? = null
    private var linearLayoutManager: LinearLayoutManager? = null

    init {
        this.overScrollMode = View.OVER_SCROLL_NEVER
        getAttributes(context, attrs)
        initRecyclerView()
    }

    private fun getAttributes(context: Context, attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.Alphabetik)

        val defaultSize = spToPixel(context, 12).toInt()
        val attFontSizeValue = ta.getDimensionPixelSize(R.styleable.Alphabetik_fontSize, defaultSize)
        fontSize = pixelsToSp(context, attFontSizeValue)

        val aItemsColor = R.styleable.Alphabetik_itemsColor
        if (ta.hasValue(R.styleable.Alphabetik_itemsColor)) {
            itemsColor = getColor(ta.getResourceId(aItemsColor, 0))
        }

        ta.recycle()
    }

    private fun getColor(id: Int): Int {
        return ContextCompat.getColor(context, id)
    }

    private fun pixelsToSp(context: Context, px: Int): Float {
        val scaledDensity = context.resources.displayMetrics.scaledDensity
        return px / scaledDensity
    }

    private fun spToPixel(context: Context, sp: Int): Float {
        val scaledDensity = context.resources.displayMetrics.scaledDensity
        return sp * scaledDensity
    }

    @SuppressLint("WrongConstant")
    private fun initRecyclerView() {
        adapter = SectionIndexAdapter(alphabet, context)
        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        this.setHasFixedSize(true)
        this.setAdapter(adapter)
        this.layoutManager = linearLayoutManager
    }

    fun setAlphabet(alphabet: Array<String>) {
        Arrays.sort(alphabet)
        this.alphabet = alphabet
        initRecyclerView()
    }

    fun onSectionIndexClickListener(sectionIndexClickListener: SectionIndexClickListener) {
        adapter!!.onSectionIndexClickListener(sectionIndexClickListener)
    }

    private fun generateAlphabet(): Array<String?> {
        val alphabetTemp = arrayOfNulls<String>(27)
        var index = 0
        var c = 'A'
        while (c <= 'Z') {
            alphabetTemp[index] = "" + c
            index++
            c++
        }
        return alphabetTemp
    }

    fun setLetterToBold(letter: String) {
        var index = Arrays.asList(*alphabet).indexOf(letter)
        val regex = "[0-9]+"
        if (letter.matches(regex.toRegex())) {
            index = alphabet.size - 1
        }
        adapter!!.setBoldPosition(index)
        this.linearLayoutManager!!.scrollToPositionWithOffset(index, 0)
        this.getAdapter()!!.notifyDataSetChanged()
    }

    internal inner class SectionIndexAdapter(private val alphabet: Array<String>, context: Context) : RecyclerView.Adapter<SectionIndexAdapter.ViewHolder>() {

        private var boldPosition = 0
        private val mInflater: LayoutInflater = LayoutInflater.from(context)
        private var sectionIndexClickListener: SectionIndexClickListener? = null

        fun onSectionIndexClickListener(sectionIndexClickListener: SectionIndexClickListener) {
            this.sectionIndexClickListener = sectionIndexClickListener
        }

        fun setBoldPosition(position: Int) {
            this.boldPosition = position
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = mInflater.inflate(R.layout.item_letter, parent, false)
            return ViewHolder(view)
        }

        @SuppressLint("ResourceAsColor")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val letter = alphabet[position]
            holder.tvLetter.text = letter

            //Set current position to bold
            val normalTypeface = Typeface.defaultFromStyle(Typeface.NORMAL)
            val boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD)
            holder.tvLetter.typeface = if (position == boldPosition) boldTypeface else normalTypeface
            holder.tvLetter.setTextColor(if (position == boldPosition) ContextCompat.getColor(context, R.color.black) else ContextCompat.getColor(context, R.color.medium_grey))

            //Custom Font size
            holder.tvLetter.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize)

            //Custom color
            if (itemsColor != 0) {
                holder.tvLetter.setTextColor(itemsColor)
            }
        }

        override fun getItemCount(): Int {
            return alphabet.size
        }

        internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            val tvLetter: TextView = itemView.findViewById(R.id.tvLetter) as TextView

            init {
                itemView.setOnClickListener(this)
            }

            override fun onClick(view: View) {
                if (sectionIndexClickListener != null) {
                    val character = "" + tvLetter.text.toString()
                    sectionIndexClickListener!!.onItemClick(view, this.position, character)
                    setLetterToBold(character)
                }
            }
        }
    }

    interface SectionIndexClickListener {
        fun onItemClick(view: View, position: Int, character: String)
    }

    companion object {
        private var itemsColor: Int = 0
    }
}
package com.example.uts_rohan_noval.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_rohan_noval.DetailMovieActivity
import com.example.uts_rohan_noval.Movie
import com.example.uts_rohan_noval.MovieAdapter
import com.example.uts_rohan_noval.R


class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter : MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList : ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            MovieAdapter(it, movieArrayList){
                val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }

    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.luffy,
            R.drawable.dragon,
            R.drawable.sabo,
            R.drawable.kaido,
            R.drawable.ace,
            R.drawable.shanks,
            R.drawable.newgate,
            R.drawable.brook,
            R.drawable.zoro,
            R.drawable.roger,

            )

        title = arrayOf(
            "MONKEY D LUFFY",
            "MONKEY D DRAGON",
            "SABO",
            "KAIDO",
            "HIKEN NO ACE",
            "AKAGAMI NO SHANKS",
            "WHITEBEARD EDGAR NEWGATE",
            "BROOK",
            "RORONOA ZORO",
            "GOL D ROGER",


            )

        descriptions = arrayOf(
            "Pengguna Buah Iblis Gomu Gomu No Mi",
            "Pengguna Buah Iblis Hito Hito No Mi",
            "Pengguna Buah Iblis Mera Mera No Mi",
            "Pengguna Buah Iblis Uo Uo no Mi",
            "Pengguna Buah Iblis Mera Mera No Mi",
            "Bukan Pengguna Buah Iblis",
            "Pengguna Buah Iblis Gura Gura no Mi",
            "Pengguna Buah Iblis Yomi Yomi no Mi ",
            "Bukan Pengguna Buah Iblis",
            "Bukan Pengguna Buah Iblis",
        )

        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }

    }


}
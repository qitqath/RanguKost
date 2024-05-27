package com.scandroid.rangukost

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scandroid.rangukost.databinding.ActivityPageBinding

class PageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val facilitiesSakura = listOf("Game Room", "Spa", "Laundry", "Cinema")
        val facilitiesChaewon = listOf("Gym", "Spa", "Free Parking", "Laundry", "Swimming Pool")
        val facilitiesYunjin = listOf("Gym", "Spa", "Cinema", "Laundry")
        val facilitiesKazuha = listOf("Gym", "Swimming Pool", "Cinema")
        val facilitiesEunchae = listOf("Game Room", "Cinema")

        setupRecyclerView(binding.recyclerViewSakura, facilitiesSakura)
        setupRecyclerView(binding.recyclerViewChaewon, facilitiesChaewon)
        setupRecyclerView(binding.recyclerViewYunjin, facilitiesYunjin)
        setupRecyclerView(binding.recyclerViewKazuha, facilitiesKazuha)
        setupRecyclerView(binding.recyclerViewEunchae, facilitiesEunchae)

        binding.profSakura.setOnClickListener {
            toggleVisibility(binding.tvFacilitiesSakura, binding.recyclerViewSakura)
        }

        binding.profChaewon.setOnClickListener {
            toggleVisibility(binding.tvFacilitiesChaewon, binding.recyclerViewChaewon)
        }

        binding.profYunjin.setOnClickListener {
            toggleVisibility(binding.tvFacilitiesYunjin, binding.recyclerViewYunjin)
        }

        binding.profKazuha.setOnClickListener {
            toggleVisibility(binding.tvFacilitiesKazuha, binding.recyclerViewKazuha)
        }

        binding.profEunchae.setOnClickListener {
            toggleVisibility(binding.tvFacilitiesEunchae, binding.recyclerViewEunchae)
        }
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, facilities: List<String>) {
        val adapter = FacilityAdapter(facilities)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun toggleVisibility(textView: View, recyclerView: View) {
        if (recyclerView.visibility == View.GONE) {
            textView.visibility = View.VISIBLE
            recyclerView.visibility = View.VISIBLE
        } else {
            textView.visibility = View.GONE
            recyclerView.visibility = View.GONE
        }
    }
}

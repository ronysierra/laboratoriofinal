package com.example.laboratoriopersonal.ui.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.laboratoriopersonal.R
import com.example.laboratoriopersonal.databinding.FragmentResultsBinding
import com.google.android.material.snackbar.Snackbar

class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val resultsViewModel =
            ViewModelProvider(this).get(ResultsViewModel::class.java)

        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textResults
        resultsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val listViewResult = binding.listviewresults

        val results = arrayOf(
            Result("Examen de sangre", R.drawable.img),
            Result("Radiografía de tórax", R.drawable.img),
            Result("Electrocardiograma", R.drawable.img),
            Result("Resonancia magnética", R.drawable.img),
            Result("Tomografía computarizada", R.drawable.img),
            Result("Ecografía", R.drawable.img),
            Result("Colonoscopia", R.drawable.img)
        )

        val adapter = ArrayAdapter(requireContext(), R.layout.item_list, R.id.textView, results)
        listViewResult.adapter = adapter

        listViewResult.setOnItemClickListener { parent, view, position, id ->
            Snackbar.make(view, "Haga clic en el examen $position", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

data class Result(val title: String, val imageResId: Int) {
    override fun toString(): String {
        return title
    }
}

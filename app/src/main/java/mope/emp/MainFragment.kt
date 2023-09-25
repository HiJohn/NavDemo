package mope.emp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.navigation.navGraphViewModels
import mope.emp.databinding.FragmentBlankBinding


/**
 *
 */
class MainFragment : Fragment() {


    private lateinit var binding :FragmentBlankBinding

    private val viewModel:NavViewModel by navGraphViewModels(R.id.nav_graph){
        SavedStateViewModelFactory(requireActivity().application, requireParentFragment())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sjn.setOnClickListener {
            nav().navigate(R.id.to_page_2)
        }
        binding.cda.setOnClickListener {
            viewModel.test.addAll(arrayListOf("a","b","c"))
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}